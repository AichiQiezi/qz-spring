package cn.acqz.springframework.beans.factory;

/**
 * Interface to be implemented by beans that want to release resources on destruction
 * @author feng
 * @date 2023/7/23 8:26
 */

public interface DisposableBean {

    void destroy() throws Exception;

}
