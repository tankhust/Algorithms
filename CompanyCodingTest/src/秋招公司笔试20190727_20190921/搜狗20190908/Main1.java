package 秋招公司笔试20190727_20190921.搜狗20190908;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author tankInternshipInterview
 * @create 2019/09/08 16:56
 */
public class Main1 {
    static Map<String, Integer> resMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LRUCache lruCache = new LRUCache(n);
        while (true) {
            String key = sc.next();
            long value = sc.nextLong();
            lruCache.put(key, value);
        }
    }
    static class LRUCache{
        private final int capacity;
        private LinkedList<String> cacheList = new LinkedList<>();
        private HashMap<String, Long> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }
//
//        public int get(String key) {
//            if (!map.containsKey(key)) {
//                return -1;
//            }
//            return map.get(key);
//        }

        public void moveToFirst(String key) {
            cacheList.remove(key);
            cacheList.addFirst(key);
        }

        public void put(String key, long value) {
            if (!map.containsKey(key)) {
                if (map.size() >= capacity) {
                    removeLastElement();
                }
                cacheList.addFirst(key);
                map.put(key, value);
            }else{
                if (map.get(key) < value) {
                    moveToFirst(key);
                    map.put(key, value);
                }
            }
        }

        public void removeLastElement() {
            String key = cacheList.removeLast();
            System.out.print(key+ " ");
            System.out.println(map.get(key));// 记录被淘汰掉的记录
            map.remove(key);
        }
    }
}
