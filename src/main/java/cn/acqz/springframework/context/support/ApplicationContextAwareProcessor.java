package cn.acqz.springframework.context.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.config.BeanPostProcessor;
import cn.acqz.springframework.context.ApplicationContext;
import cn.acqz.springframework.context.ApplicationContextAware;

/**
 * @author feng
 * @date 2023/7/26 10:42
 */

public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
