package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/02/15 22:42
 */
public class Hashtable_test<K, V> {
    private ExtEntry<K, V>[] table;
    private int size;

    public synchronized V get(Object key) {
        int hash = key.hashCode();
        int index = hash % table.length;
        for (ExtEntry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hashCode() == hash && e.getKey().equals(key)) {
                return (V) e.getValue();
            }
        }
        return null;
    }

    public synchronized V put(Object key, Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        int hash = key.hashCode();
        int index = hash % table.length;
        ExtEntry<K, V> e = table[index];
        //如果有这个key了，则修改key对应的value值
        for (; e != null; e = e.next) {
            if (e.hashCode() == hash && e.getKey().equals(key)) {
                V old = (V)e.getValue();
                e.setValue(value);
                return old;
            }
        }
        //如果没有，在原来的table上挂一个新的ExtEntry
        ExtEntry<K,V> c = table[index];
        table[index] = new ExtEntry<>(key,value,c);
        return null;
    }
}

class ExtEntry<K, V> {
    private Object key;
    private Object value;
    ExtEntry<K, V> next;

    public ExtEntry(Object key, Object value, ExtEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ExtEntry<K, V> getNext() {
        return next;
    }

    public void setNext(ExtEntry<K, V> next) {
        this.next = next;
    }
}
