package cn.acqz.springframework.beans.factory;


import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.acqz.springframework.beans.factory.config.BeanDefinition;
import cn.acqz.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
