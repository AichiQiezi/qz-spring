package cn.acqz.springframework.beans.factory;

import cn.acqz.springframework.beans.BeansException;

/**
 * @author feng
 * @date 2023/7/26 20:52
 */

public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}
