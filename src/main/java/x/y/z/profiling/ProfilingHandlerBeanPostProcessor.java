/**
 * 
 */
package x.y.z.profiling;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import x.y.z.annotation.Profiling;
import x.y.z.controllers.ProfilingController;

/**
 * @author OBobko
 * @date 2016-12-19
 */
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
	
	private static final Logger LOG = LogManager.getLogger(ProfilingHandlerBeanPostProcessor.class);
	
	private Map<String, Class> map = new HashMap<>();
	private ProfilingController controller = new ProfilingController();
	
	public ProfilingHandlerBeanPostProcessor() throws Exception {
		MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
		platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Class<?> beanClass = bean.getClass();
		if(beanClass.isAnnotationPresent(Profiling.class)) {
			map.put(beanName, beanClass);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class beanClass = map.get(beanName);
		if(beanClass != null) {
			return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					if(controller.isEnabled()) {
						LOG.info("begin profiling");
						long before = System.nanoTime();
						Object retVal = method.invoke(bean, args);
						long after = System.nanoTime();
						LOG.info(after - before);
						LOG.info("end");
						return retVal;
					} else {
						return method.invoke(bean, args);
					}
				}
			});
		}
		return bean;
	}

}
