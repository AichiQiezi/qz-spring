package cn.acqz.springframework.beans.factory.config;

/**
 * A BeanDefinition describes a bean instance, className、scope and so on
 * @author feng
 * @date 2023/7/16 21:02
 */

public class BeanDefinition {
    private volatile Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
