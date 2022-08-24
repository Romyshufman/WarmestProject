import java.util.*;
public class Warmest<K,V> {

    private Map<K,V> elements= new HashMap<K,V>();
    private myLinkedList<V> warm_list = new myLinkedList<V>();
    private Map<V,myNode<V>> val_to_node= new HashMap<V,myNode<V>>();

    public void put(K key, V value){
        elements.put(key,value);
        warm_list.add(value);
        val_to_node.put(value,warm_list.getTail());
    }

    public V get(K k){
        if (!elements.containsKey(k)) {
            return null;
        }
        V val= elements.get(k);
        //System.out.println(val_to_node.get(val).getVal());
        warm_list.remove(val_to_node.get(val));
        warm_list.add(val);
        val_to_node.put(val,warm_list.getTail());
        return val;
    }

    public V remove(K k) {
        if (!elements.containsKey(k)) {
            return null;
        }
        V val = elements.get(k);
        elements.remove(k);
        warm_list.remove(val_to_node.get(val));
        val_to_node.remove(val);
        return val;
    }

    public V getWarmest(){
        if (elements.isEmpty()){
            return null;
        }
        return (V) warm_list.getTail().getVal();
    }

    public String getWarmList(){
        return warm_list.toString();
    }
}


