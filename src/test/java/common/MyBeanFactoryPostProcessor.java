package common;


import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.PropertyValue;
import cn.acqz.springframework.beans.PropertyValues;
import cn.acqz.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.acqz.springframework.beans.factory.config.BeanDefinition;
import cn.acqz.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
