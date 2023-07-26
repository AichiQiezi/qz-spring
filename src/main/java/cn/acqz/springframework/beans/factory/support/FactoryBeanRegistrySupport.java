package cn.acqz.springframework.beans.factory.support;

import cn.acqz.springframework.beans.BeansException;
import cn.acqz.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Support base class for singleton registries which need to handle
 * {@link cn.acqz.springframework.beans.factory.FactoryBean} instances,
 * integrated with {@link DefaultSingletonBeanRegistry}'s singleton management.
 * @author feng
 * @date 2023/7/25 23:22
 */

public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    public final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            synchronized (getSingletonMutex()) {
                if (object == null) {
                    object = doGetObjectFromFactoryBean(factory, beanName);
                    this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
                }
                return (object != NULL_OBJECT ? object : null);
            }
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName){
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
