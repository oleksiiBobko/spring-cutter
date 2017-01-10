/**
 * 
 */
package x.y.z.screensaver.config;

import java.awt.Color;
import java.util.Random;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import x.y.z.screensaver.ColorFrame;

/**
 * @author OBobko
 * @date 2017-01-10
 */
@Configuration
@ComponentScan(basePackages = {"x.y.z.screensaver"})
public class ScreensaverConfiguration {
    
    @Bean
    @Scope(value = "periodical")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
    
    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            
            private static final long serialVersionUID = 1L;

            @Override
            protected Color getColor() {
                return color();
            }
        };
    }
    
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreensaverConfiguration.class);
        while(true) {
            context.getBean(ColorFrame.class).showOnRundomPlace();
            Thread.sleep(100);
        }
        
    }
    
}
