package beans.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用抽象类，定义模板行为，实现BeanFactory接口
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    /**
     * 所谓的容器，用来保存bean
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    /**
     * 获取bean的方法
     * @param name bean在容器中的名称
     * @return 获取到的bean
     * @throws Exception
     */
    public Object getBean(String name) throws Exception{
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No Bean Named " + name + "is defined");
        }
        Object bean  = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    /**
     *注册bean
     * @param name bean的名称
     * @param beanDefinition bean的容器
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    protected abstract  Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
