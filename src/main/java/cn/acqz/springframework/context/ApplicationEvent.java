package cn.acqz.springframework.context;

import java.util.EventObject;

/**
 * @author feng
 * @date 2023/7/26 10:23
 */

public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

}
