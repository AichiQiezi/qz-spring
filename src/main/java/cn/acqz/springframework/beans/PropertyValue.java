package cn.acqz.springframework.beans;

/**
 * @author feng
 * @date 2023/7/18 9:31
 */

public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
