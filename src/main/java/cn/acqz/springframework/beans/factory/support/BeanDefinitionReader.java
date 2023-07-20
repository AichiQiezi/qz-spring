package cn.acqz.springframework.beans.factory.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.config.BeanDefinitionRegistry;
import cn.acqz.springframework.core.io.Resource;
import cn.acqz.springframework.core.io.ResourceLoader;

/**
 * @author feng
 * @date 2023/7/18 16:13
 */

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String... locations) throws BeansException;
}
