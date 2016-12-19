/**
 * 
 */
package x.y.lambda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import x.y.lambda.impl.TerminatorQuoter;

/**
 * @author OBobko
 * @date 2016-12-19
 */
@Configuration
public class AppConfiguration {
	
	@Bean
	public TerminatorQuoter terminatorQuoter() {
		return new TerminatorQuoter();
	}
	
}
