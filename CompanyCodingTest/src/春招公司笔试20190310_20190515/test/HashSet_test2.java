//package tankInternshipInterview.practice.test;
//
///**
// * @author tankInternshipInterview
// * @create 2019/03/15 10:07
// */
//public class HashSet_test2<Object,Object> {
//    private ExtEntry2<Object,Object>[] arr;
//    private int size;
//
//
//    public synchronized  get(Object key) {
//        int hash = key.hashCode();
//        int index = hash % arr.length;
//        for (ExtEntry2<Object, Object> e = arr[index]; e != null; e = e.next) {
//            if (e.getKey().hashCode() == hash && e.getKey().equals(key)) {
//                return (Object)e.getValue();
//            }
//        }
//        return null;
//    }
//
//    public synchronized Object put(Object key, Object value) {
//        int hash = key.hashCode();
//        int index = hash % arr.length;
//        for (ExtEntry2<Object, Object> e = arr[index]; e != null; e = e.next) {
//            if (e.getKey().hashCode() == hash && e.getKey().equals(key)) {
//                Object old = (Object)e.getValue();
//                e.setValue(value);
//                return old;
//            }
//        }
//        ExtEntry2<Object, Object> next = arr[index];
//        arr[index] = new ExtEntry2<Object,Object>(key, value, next);
//        return null;
//    }
//}
//class ExtEntry2<Object,Object>{
//    private Object key;
//    private Object value;
//    ExtEntry2<Object,Object> next;
//
//    public ExtEntry2<Object,Object>(Object key, Object value, ExtEntry2<Object,Object> next){
//        this.key = key;
//        this.value = value;
//        this.next = next;
//    }
//
//    public Object getKey() {
//        return key;
//    }
//
//    public void setKey(Object key) {
//        this.key = key;
//    }
//
//    public Object getValue() {
//        return value;
//    }
//
//    public void setValue(Object value) {
//        this.value = value;
//    }
//
//    public ExtEntry2<Object, Object> getNext() {
//        return next;
//    }
//
//    public void setNext(ExtEntry2<Object, Object> next) {
//        this.next = next;
//    }
//}
