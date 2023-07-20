package cn.acqz.springframework.beans.factory.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.config.BeanDefinitionRegistry;
import cn.acqz.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.acqz.springframework.core.io.DefaultResourceLoader;
import cn.acqz.springframework.core.io.ResourceLoader;

/**
 * @author feng
 * @date 2023/7/18 16:13
 */

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
