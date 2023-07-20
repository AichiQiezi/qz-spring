package cn.acqz.springframework.beans.factory.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author feng
 * @date 2023/7/18 10:50
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
