package cn.acqz.springframework.beans.factory;

/**
 * @author feng
 * @date 2023/7/25 20:37
 */

public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
