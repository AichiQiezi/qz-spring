package cn.acqz.springframework.beans.factory.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.acqz.springframework.beans.factory.config.BeanDefinition;
import cn.acqz.springframework.beans.factory.config.BeanDefinitionRegistry;
import cn.acqz.springframework.beans.factory.config.BeanPostProcessor;
import cn.acqz.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  Register all bean definitions
 * @author feng
 * @date 2023/7/17 18:03
 */

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory{
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(128);

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {

    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return null;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

}
