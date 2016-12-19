package x.y.z;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import x.y.z.api.Quoter;
import x.y.z.configuration.AppConfiguration;

@ContextConfiguration(classes = AppConfiguration.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
	
	@Autowired
	private Quoter terminatorQuoter;
	
	@Test
	public void appTest() throws InterruptedException {
		while(true) {
			Thread.sleep(100);
			terminatorQuoter.sayQuote();
		}
	}
	
}
