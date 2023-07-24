import java.util.Arrays;

public class MyHashMap<K,V> {

        static class Entry<K,V>{
            K key;
            V value;
            Entry<K,V> next;

            public Entry() {
            }

            public Entry(K key, V value, Entry<K, V> next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }

            @Override
            public String toString() {
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }
        }
        private Entry<K,V>[] buckets;
        private int capacity=15;
        private int size=0;

    public MyHashMap() {
        buckets=new Entry[capacity];
    }


    public MyHashMap(int capacity) {
        this();
        this.capacity=capacity;
    }
    private int hash (K key)
    {
        return Math.abs (key.hashCode ())%capacity;
    }
    public void put(K key, V value){
        if(null == key) return; // null keys not allowed
        int hash = hash(key);
        Entry<K,V> add = new Entry<K,V> (key,value,null);
        if(buckets[hash]==null){
            buckets[hash]=add;
        }else{
            Entry<K,V> curr = buckets[hash];
            while(null !=curr){
                if(curr.key.equals (key)){
                    curr.value =value;
                    return;
                }else{
                    if(curr.next == null){
                        curr.next = add;
                        return;
                    }
                    curr = curr.next;
                }
            }
        }
        size++;
    }
    public V get(K key){
        if(null == key) return null;
        int hash = hash(key);
        Entry<K,V> b = buckets[hash];
        if(null == b) return null;
        while(null !=b){
            if(b.key.equals (key)){
                return b.value;
            }else{
                b=b.next;
            }
        }
        return null;
    }
    public boolean remove(K key){
        if(null == key) return false;
        int hash = hash(key);
        Entry<K,V> b = buckets[hash];
        if(null == b) return false;
        Entry<K,V> prev = null;
        while(null !=b){
            if(b.key.equals (key)){
                //delete
                if(prev == null) {  // first node to remove
                    buckets[hash]=b.next;
                    return true;
                }else{
                    prev.next = b.next;
                    return true;
                }
            }else{
                prev=b;
                b =b.next;
            }
        }
        size--;
        return false;
    }
    public int size(){
        return size;
    }
    public void clear(){
        for (int i = 0; i < buckets.length; ++i)
            if (buckets[i]!=null)buckets[i] = null;
        size=0;

    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "buckets=" + Arrays.toString(buckets) +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {

        MyHashMap<String,String> map=new MyHashMap<>();
        map.put("Ukraine","Kyiv");
        map.put("Polska","Warshava");
        map.put("Chech","Praha");
        System.out.println("map.get(\"Chech\") = " + map.get("Chech"));
        map.put("Slovakia","Bratislava");
        System.out.println(map);
        map.remove("Polska");
        System.out.println(map);
        map.clear();
        System.out.println(map);
        System.out.println("map.size() = " + map.size());
    }
}


