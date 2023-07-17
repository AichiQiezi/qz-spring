package cn.acqz.springframework.beans.factory;

import cn.acqz.springframework.beans.BeansException;

/**
 * the root interface for accessing a Spring bean container
 *
 * @author feng
 * @date 2023/7/16 20:49
 */

public interface BeanFactory {
    /**
     * Return a specified bean instance, which may be shared or independent.
     * @param name the name of bean to retrieve(收回)
     * @return an instance of the bean
     * @throws  BeansException – if the bean could not be created or there is no such bean definition
     */
    Object getBean(String name) throws BeansException;
}
