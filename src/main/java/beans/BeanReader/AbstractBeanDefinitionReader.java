package beans.BeanReader;

import beans.factory.BeanDefinition;
import beans.io.ResourceLoader;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 从配置中读取BeanDefinitionReader
 */
@Getter
public abstract class AbstractBeanDefinitionReader  implements BeanDefinitionReader{
    private Map<String,BeanDefinition> registry;


    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }
    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

}
