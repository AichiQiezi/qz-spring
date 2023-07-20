package cn.acqz.springframework.context.support;

import cn.acqz.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.acqz.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author feng
 * @date 2023/7/20 8:40
 */

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
