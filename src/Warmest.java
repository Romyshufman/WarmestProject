import java.util.*;

public class Warmest<K,V> {

    private Map<K,V> elements= new HashMap<K,V>();
    private Map<V,K> elements_reverse= new HashMap<V,K>();
    //private LinkedList<V> warm_list = new LinkedList<V>();
    private Stack <V> warm_stack = new Stack<V>();

    public void put(K key, V value){
        elements.put(key,value);
        elements_reverse.put(value,key);
        //warm_list.add(value);
        warm_stack.push(value);
    }

    public V get(K k){
        if (!elements.containsKey(k)) {
            return null;
        }
        V val= elements.get(k);
        //warm_list.add(val);
        warm_stack.push(val);
        return val;
    }

    public V remove(K k) {
        if (!elements.containsKey(k)) {
            return null;
        }
        V val = elements.get(k);
        elements.remove(k);
        elements_reverse.remove(val);
//        ListIterator<V> iter = (ListIterator<V>) warm_list.iterator();
//        while (iter.hasNext()) {
//            V node = iter.next();
//            if (node.equals(val)) {
//                iter.remove();
//            }
//        }
        while(!warm_stack.isEmpty() && !elements_reverse.containsKey(warm_stack.peek())){
            warm_stack.pop();
        }
        return val;
    }

    public V getWarmest(){
        if (elements.isEmpty()){
            return null;
        }
//        return warm_list.getLast();
        return warm_stack.peek();
    }

//    private void printWarmList(){
//        for (int i = 0; i < warm_list.size(); i++) {
//            System.out.println(i +" = "+warm_list.get(i));
//        }
//    }
    public void printWarmStack(){
        System.out.println(warm_stack.toString());
    }
}


