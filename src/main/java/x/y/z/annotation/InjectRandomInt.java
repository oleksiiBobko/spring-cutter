/**
 * 
 */
package x.y.z.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author OBobko
 * @date 2016-12-19
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

	int min();

	int max();

}
