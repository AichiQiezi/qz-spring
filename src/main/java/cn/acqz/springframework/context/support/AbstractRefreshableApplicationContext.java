package cn.acqz.springframework.context.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.acqz.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author feng
 * @date 2023/7/20 8:07
 */

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
