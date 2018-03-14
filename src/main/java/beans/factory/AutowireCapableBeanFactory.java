package beans.factory;

import java.io.File;
import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValue(bean, beanDefinition);
        return bean;
    }

    /**
     * 为bean注入属性
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    private void applyPropertyValue(Object bean, BeanDefinition beanDefinition) throws  Exception{
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field field = bean.getClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference =  (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            field.set(bean,value);
        }
    }

    /**
     * 生成bean的实体
     * @param beanDefinition bean的容器
     * @return bean的实例
     */
    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        Class beanCalss = beanDefinition.getBeanClass();
        return beanCalss.newInstance();
    }
}
