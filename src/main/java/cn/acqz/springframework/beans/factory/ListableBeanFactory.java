package cn.acqz.springframework.beans.factory;

import cn.acqz.springframework.beans.BeansException;

import java.util.Map;

/**
 * Extension of the BeanFactory interface to be implemented by
 * bean factories that can enumerate all their bean instances,
 * rather than attempting bean lookup by name one by one as requested by clients.
 * BeanFactory implementations that preload all their bean definitions
 * (such as XML-based factories) may implement this interface
 * @author feng
 * @date 2023/7/20 6:12
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     *  Return the bean instances that match the given object type
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     * @return the names of all beans defined in this factory,
     * or an empty array if none defined
     */
    String[] getBeanDefinitionNames();
}
