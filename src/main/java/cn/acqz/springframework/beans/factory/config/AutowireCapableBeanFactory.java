package cn.acqz.springframework.beans.factory.config;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.BeanFactory;

/**
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 * @author feng
 * @date 2023/7/20 6:52
 */

public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}

