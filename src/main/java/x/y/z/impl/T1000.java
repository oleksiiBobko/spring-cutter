/**
 * 
 */
package x.y.z.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import x.y.z.api.Quoter;

/**
 * @author OBobko
 * @date 2017-01-04
 */
public class T1000 extends TerminatorQuoter implements Quoter {

    private static final Logger LOG = LogManager.getLogger(T1000.class);
    
    public T1000() {
        LOG.info("instantiated");
    }
    
    @Override
    public void sayQuote() {
        LOG.info("I'm liquid");
    }
}
