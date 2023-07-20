package cn.acqz.springframework.beans.factory.config;

import cn.acqz.springframework.beans.PropertyValues;

/**
 * A BeanDefinition describes a bean instance, className、scope and so on
 *
 * @author feng
 * @date 2023/7/16 21:02
 */

public class BeanDefinition {
    private volatile Class<?> beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

}
