/**
 * 
 */
package x.y.lambda.impl;

import x.y.lambda.Quoter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Component;

/**
 * @author OBobko
 * @date 2016-12-19
 */
@Component
public class TerminatorQuoter implements Quoter {
	
	private static final Logger LOG = LogManager.getLogger(TerminatorQuoter.class);
	
	@Override
	public void sayQuote() {
		LOG.info("I'll be back!!!");

	}

}
