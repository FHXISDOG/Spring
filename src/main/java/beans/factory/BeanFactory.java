package beans.factory;

/**
 * 为了保证扩展性，我们使用Extract Interface的方法，
 * 将BeanFactory替换成接口，而使用AbstractBeanFactory和AutowireCapableBeanFactory作为其实现。
 *
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param name bean在容器中的名称
     * @return 获取的bean
     * @throws Exception
     */
    Object getBean(String name) throws  Exception;
}
