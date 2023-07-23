package cn.acqz.springframework.context.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.acqz.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.acqz.springframework.beans.factory.config.BeanPostProcessor;
import cn.acqz.springframework.context.ConfigurableApplicationContext;
import cn.acqz.springframework.core.io.DefaultResourceLoader;
import cn.hutool.core.lang.Assert;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2023/7/20 6:48
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

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


    @Override
    public void refresh() throws BeansException {
        // create BeanFactory，and load BeanDefinition
        synchronized (startupShutdownMonitor){
            refreshBeanFactory();

            ConfigurableListableBeanFactory beanFactory = getBeanFactory();

            invokeBeanFactoryPostProcessors(beanFactory);

            registerBeanPostProcessors(beanFactory);

            beanFactory.preInstantiateSingletons();
        }
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
        if (this.shutdownHook == null){
            this.shutdownHook = new Thread(this::close);
            Runtime.getRuntime().addShutdownHook(this.shutdownHook);
        }
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }

}
