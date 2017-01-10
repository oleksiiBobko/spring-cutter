/**
 * 
 */
package x.y.z.screensaver.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import x.y.z.screensaver.scope.PeriodicalScopeConfigurer;

/**
 * @author OBobko
 * @date 2017-01-10
 */
@Component
public class CustomScopeRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope("periodical", new PeriodicalScopeConfigurer());
    }

}
