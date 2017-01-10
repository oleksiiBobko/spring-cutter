package x.y.z;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import x.y.z.api.Quoter;

@ContextConfiguration(locations = {"classpath:context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Autowired
    private Quoter terminatorQuoter;

    @Test
    public void appTest() throws InterruptedException {
        terminatorQuoter.sayQuote();
    }

}
