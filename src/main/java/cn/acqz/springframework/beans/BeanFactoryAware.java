package cn.acqz.springframework.beans;

import cn.acqz.springframework.beans.factory.Aware;
import cn.acqz.springframework.beans.factory.BeanFactory;

/**
 * @author feng
 * @date 2023/7/23 10:56
 */

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
