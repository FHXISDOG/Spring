package beans.factory;

import lombok.Data;

/**
 * 用来处理bean注入的类
 */
@Data
public class BeanReference {
    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }
}
