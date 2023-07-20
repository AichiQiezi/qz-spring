package cn.acqz.springframework.beans.factory.config;

/**
 * a logical reference to the name of a bean
 * @author feng
 * @date 2023/7/18 9:29
 */

public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
