package cn.acqz.springframework.beans.factory.config;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * Allows for custom modification of an application context's bean definitions,
 * adapting the bean property values of the context's underlying bean factory.
 * @author feng
 * @date 2023/7/20 8:23
 */

public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * Provide a mechanism to modify the beanDefinition property after all bean definition have been loaded
     * and before the bean object has been instantiated
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
