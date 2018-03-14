package beans.factory;

import lombok.Data;

/**
 * bean的内容及元数据，保存在BeanFactory中，包装bean的实体
 */
@Data
public class BeanDefinition {
    /**
     * bean的实体
     */
    private Object bean;
    /**
     * bean的字节码对象
     */
    private Class beanClass;
    /**
     * bean的名称
     */
    private String beanClassName;
    /**
     * 保存bean的属性
     */
    private PropertyValues propertyValues = new PropertyValues();

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
