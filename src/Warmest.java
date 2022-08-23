import java.util.*;

public class Warmest<K,V> {

    private Map<K,V> elements= new HashMap<K,V>();
    private LinkedList<V> warm_list = new LinkedList<V>();

    public void put(K key, V value){
        elements.put(key,value);
        warm_list.add(value);
    }

    public V get(K k){
        if (!elements.containsKey(k)) {
            return null;
        }
        V val= elements.get(k);
        warm_list.remove(val);
        warm_list.add(val);
        return val;
    }

    public V remove(K k) {
        if (!elements.containsKey(k)) {
            return null;
        }
        V val = elements.get(k);
        elements.remove(k);
        warm_list.remove(val);
        return val;
    }

    public V getWarmest(){
        if (elements.isEmpty()){
            return null;
        }
        return warm_list.getLast();
    }

    public String getWarmList(){
        return warm_list.toString();
    }
}


