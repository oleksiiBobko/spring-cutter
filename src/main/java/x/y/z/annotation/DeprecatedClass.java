/**
 * 
 */
package x.y.z.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author OBobko
 * @date 2017-01-04
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class<?> newImpl();
}
