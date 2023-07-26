package cn.acqz.springframework.context;

import cn.acqz.springframework.beans.factory.HierarchicalBeanFactory;
import cn.acqz.springframework.beans.factory.ListableBeanFactory;
import cn.acqz.springframework.core.io.ResourceLoader;

/**
 * Central interface to provide configuration for an application.
 * @author feng
 * @date 2023/7/20 6:07
 */

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
