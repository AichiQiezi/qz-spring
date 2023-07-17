package cn.acqz.springframework.beans.factory.config;

/**
 * interface that define a registry for shared bean instance
 * @author feng
 * @date 2023/7/16 21:10
 */

public interface SingletonBeanRegistry {

    /**
     * Return the singleton object registered under the given name.
     * @param beanName the name of bean to look for
     * @return the registered singleton object, or null if none found
     */
    Object getSingleton(String beanName);
}
