package x.y.lambda;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
	
	private static final Logger LOG = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		
		LOG.info("asdf");
		
		Set<Integer> unique = new HashSet<Integer>(1000000);
		
		
		
		long time = System.currentTimeMillis();
		long count = new Random().ints(1000000, 1, 1000000).filter(i -> unique.add(i)).count();
		
		System.out.printf("time:%d\n", System.currentTimeMillis() - time);
		
		
		System.out.println("end");
		//System.out.println(Stream.of("adf1", "b2").mapToInt(s -> s.length()).sum());
		
	}
}
