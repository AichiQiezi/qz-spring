package cn.acqz.springframework.beans;

import cn.acqz.springframework.beans.factory.Aware;

/**
 * @author feng
 * @date 2023/7/23 10:51
 */

public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
