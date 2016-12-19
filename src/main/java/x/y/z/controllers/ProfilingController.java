/**
 * 
 */
package x.y.z.controllers;

/**
 * @author OBobko
 * @date 2016-12-19
 */
public class ProfilingController implements ProfilingControllerMBean {
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
