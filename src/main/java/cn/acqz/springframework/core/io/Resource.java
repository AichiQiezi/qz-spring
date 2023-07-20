package cn.acqz.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author feng
 * @date 2023/7/18 15:52
 */
public interface Resource {
    InputStream getInputStream() throws IOException;

}
