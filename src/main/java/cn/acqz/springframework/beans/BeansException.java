package cn.acqz.springframework.beans;

/**
 * define bean exception
 * @author feng
 * @date 2023/7/16 20:49
 */

public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
