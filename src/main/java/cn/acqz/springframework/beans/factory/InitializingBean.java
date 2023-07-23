package cn.acqz.springframework.beans.factory;

/**
 * Interface to be implemented by beans that need to react once all their
 * properties have been set by a BeanFactory: for example, to perform custom
 * initialization, or merely to check that all mandatory properties have been set.
 *
 * @author feng
 * @date 2023/7/21 9:11
 */

public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
