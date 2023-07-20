package cn.acqz.springframework.beans.factory.config;


/**
 * @author feng
 * @date 2023/7/17 17:58
 */

public interface BeanDefinitionRegistry {
    /**
     * register the BeanDefinition in the registry
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     *
     */
    String[] getBeanDefinitionNames();
}
