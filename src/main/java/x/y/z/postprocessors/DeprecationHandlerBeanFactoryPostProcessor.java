/**
 * 
 */
package x.y.z.postprocessors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardMethodMetadata;

import x.y.z.annotation.DeprecatedClass;

/**
 * @author OBobko
 * @date 2017-01-04
 */
public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger LOG = LogManager.getLogger(DeprecationHandlerBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            LOG.info(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName != null) {
                try {
                    Class<?> beanClass = Class.forName(beanClassName);
                    DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                    if (annotation != null) {
                        beanDefinition.setBeanClassName(annotation.newImpl().getName());
                    }
                } catch (Exception e) {
                    LOG.error("error during postprocessing", e);
                }
            }
        }
    }

}
