package cn.acqz.springframework.context;

import cn.acqz.springframework.beans.BeansException;

/**
 * @author feng
 * @date 2023/7/20 6:49
 */

public interface ConfigurableApplicationContext extends ApplicationContext {
    void refresh() throws BeansException;
}
