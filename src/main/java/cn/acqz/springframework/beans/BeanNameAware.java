package cn.acqz.springframework.beans;

import cn.acqz.springframework.beans.factory.Aware;

/**
 * @author feng
 * @date 2023/7/23 10:56
 */

public interface BeanNameAware extends Aware {
    void setBeanName(String name);

}
