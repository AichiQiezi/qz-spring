package cn.acqz.springframework.context.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.acqz.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.acqz.springframework.beans.factory.config.BeanPostProcessor;
import cn.acqz.springframework.context.ApplicationEvent;
import cn.acqz.springframework.context.ApplicationListener;
import cn.acqz.springframework.context.ConfigurableApplicationContext;
import cn.acqz.springframework.context.event.AbstractApplicationEventMulticaster;
import cn.acqz.springframework.context.event.ContextClosedEvent;
import cn.acqz.springframework.context.event.ContextRefreshedEvent;
import cn.acqz.springframework.context.event.SimpleApplicationEventMulticaster;
import cn.acqz.springframework.core.io.DefaultResourceLoader;
import cn.hutool.core.lang.Assert;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2023/7/20 6:48
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";
    private final List<BeanFactoryPostProcessor> beanFactoryPostProcessors = new ArrayList<>();
    /**
     * Reference to the JVM shutdown hook, if registered
     */
    @Nullable
    private Thread shutdownHook;
    /**
     * Synchronization monitor for the "refresh" and "destroy".
     */
    private final Object startupShutdownMonitor = new Object();

    private AbstractApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        // create BeanFactory，and load BeanDefinition
        synchronized (startupShutdownMonitor) {
            // 1. 创建 bean factory，并加载 BeanDefinition
            refreshBeanFactory();
            // 2. 获取 beanFactory
            ConfigurableListableBeanFactory beanFactory = getBeanFactory();
            // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
            beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
            // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
            invokeBeanFactoryPostProcessors(beanFactory);
            // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
            registerBeanPostProcessors(beanFactory);
            // 6. 初始化事件发布者
            initApplicationEventMulticaster();
            // 7. 注册事件监听器
            registerListeners();
            // 8. 提前实例化单例Bean对象
            beanFactory.preInstantiateSingletons();
            // 9. 发布容器刷新完成事件
            finishRefresh();
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster =new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessors) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor) {
        Assert.notNull(postProcessor, "BeanFactoryPostProcessor must not be null");
        this.beanFactoryPostProcessors.add(postProcessor);
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public void registerShutdownHook() {
        if (this.shutdownHook == null) {
            this.shutdownHook = new Thread(this::close);
            Runtime.getRuntime().addShutdownHook(this.shutdownHook);
        }
    }

    @Override
    public void close() {
        publishEvent(new ContextClosedEvent(this));

        // 执行单例 bean 的销毁方法
        getBeanFactory().destroySingletons();
    }

}
