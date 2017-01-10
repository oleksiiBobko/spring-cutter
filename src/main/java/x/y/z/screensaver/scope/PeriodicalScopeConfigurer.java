/**
 * 
 */
package x.y.z.screensaver.scope;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalTime;
import static java.time.LocalTime.now;
import javafx.util.Pair;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @author OBobko
 * @date 2017-01-10
 */
@SuppressWarnings("restriction")
public class PeriodicalScopeConfigurer implements Scope {

    private Map<String, Pair<LocalTime, Object>> map = new HashMap<>();
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            int secondsSinceLastRequest = now().getSecond() - pair.getKey().getSecond();
            if(secondsSinceLastRequest > 3) {
                map.put(name, new Pair(now(), objectFactory.getObject()));
            }
        } else {
            map.put(name, new Pair(now(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

}
