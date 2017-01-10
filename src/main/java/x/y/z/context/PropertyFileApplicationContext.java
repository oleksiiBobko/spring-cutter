package x.y.z.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import x.y.z.api.Quoter;

/**
 * @author OBobko
 * @date 2017-01-10
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {
    
    private static final Logger LOG = LogManager.getLogger(PropertyFileApplicationContext.class);
    
    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        LOG.info("found:" + i);
        refresh();
    }
    
    public static void main(String[] args) {
        PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.properties");
        Quoter quoter = context.getBean(Quoter.class);
        quoter.sayQuote();
        
    }
    
}
