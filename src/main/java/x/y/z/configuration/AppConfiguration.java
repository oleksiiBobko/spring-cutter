/**
 * 
 */
package x.y.z.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import x.y.z.impl.TerminatorQuoter;
import x.y.z.postprocessors.InjectRundomIntAnnotationPostProcessor;
import x.y.z.profiling.ProfilingHandlerBeanPostProcessor;

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
	
	@Bean InjectRundomIntAnnotationPostProcessor injectRundomIntAnnotationPostProcessor() {
		return new InjectRundomIntAnnotationPostProcessor();
	}
	
	@Bean
	public ProfilingHandlerBeanPostProcessor profilingHandlerBeanPostProcessor() throws Exception {
		return new ProfilingHandlerBeanPostProcessor();
	}
	
}
