package cn.acqz.springframework.core.io;

/**
 * @author feng
 * @date 2023/7/18 15:52
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
