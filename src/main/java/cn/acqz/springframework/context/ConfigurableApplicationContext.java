package cn.acqz.springframework.context;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * Configuration and lifecycle methods are encapsulated here to
 * avoid making them obvious to ApplicationContext client code.
 * @author feng
 * @date 2023/7/20 6:49
 */

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * this is a startup method
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

    void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);

}
