package 春招公司笔试20190310_20190515.test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author tankInternshipInterview
 * @create 2019/02/17 16:22
 */
public class LRUCache {
    private final int capacity;
    private LinkedList<Integer> cacheList = new LinkedList<>();
    private HashMap<Integer,Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        moveToFirst(key);
        return map.get(key);
    }

    public void moveToFirst(Integer key){
        cacheList.remove(key);
        cacheList.addFirst(key);
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size() >= capacity){
                removeLastElement();
            }
            cacheList.addFirst(key);
            map.put(key,value);
        }else{
            moveToFirst(key);
            map.put(key,value);
        }
    }
    public void removeLastElement(){
        Integer key = cacheList.removeLast();
        map.remove(key);
    }

    @Override
    public String toString() {
        return cacheList.toString();
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(2, 1);
        obj.put(2, 2);
        System.out.println(obj.get(2));
        obj.put(1, 1);
        obj.put(4, 1);
        System.out.println(obj.get(2));
    }
}
