package x.y.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import x.y.lambda.configuration.AppConfiguration;
import x.y.lambda.impl.TerminatorQuoter;

@ContextConfiguration(classes = AppConfiguration.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
	
	@Autowired
	private TerminatorQuoter terminatorQuoter;
	
	@Test
	public void appTest() {
		terminatorQuoter.sayQuote();
	}
	
}
