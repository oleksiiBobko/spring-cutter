/**
 * 
 */
package x.y.z.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import x.y.z.annotation.InjectRandomInt;
import x.y.z.annotation.Profiling;
import x.y.z.api.Quoter;

/**
 * @author OBobko
 * @date 2016-12-19
 */

@Profiling
public class TerminatorQuoter implements Quoter {
	
	private static final Logger LOG = LogManager.getLogger(TerminatorQuoter.class);
	
	@InjectRandomInt(min = 2, max = 7)
	private int repeat;
	
	@Override
	public void sayQuote() {
		
		for(int i = 0; i < repeat; i ++) {
			LOG.info("I'll be back!!!");
		}

	}

}
