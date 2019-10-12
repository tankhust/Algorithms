package 春招公司笔试20190310_20190515.test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author tankInternshipInterview
 * @create 2019/03/06 9:04
 */
public class LRUCache_test {
    private final int capacity;
    private LinkedList<Integer> cacheList = new LinkedList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();

    public LRUCache_test(int capacity) {
        this.capacity = capacity;
    }

    public int get(Integer key){
        if (!map.containsKey(key)) {
            return -1;
        }
        moveToFirst(key);
        return map.get(key);
    }

    private void moveToFirst(Integer key) {
        cacheList.remove(key);
        cacheList.addFirst(key);
    }

    public void put(Integer key, Integer value) {
        if (!map.containsKey(key)) {
            if (map.size() >= capacity) {
                removeLastElment();
            }
            cacheList.addFirst(key);
            map.put(key, value);
        }else{
            moveToFirst(key);
        }
    }

    private void removeLastElment() {
        Integer key = cacheList.removeLast();
        map.remove(key);
    }

    @Override
    public String toString() {
       return cacheList.toString();
    }

    public static void main(String[] args) {
        LRUCache_test lruCache_test = new LRUCache_test(2);
        lruCache_test.put(1, 1);
        lruCache_test.put(2, 2);
        System.out.println(lruCache_test);
        lruCache_test.put(3, 3);
        System.out.println(lruCache_test);
        lruCache_test.get(2);
        System.out.println(lruCache_test);
    }
}
