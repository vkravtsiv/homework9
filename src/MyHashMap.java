import java.util.Arrays;

public class MyHashMap<K, V> {
    //    HashMap hashMap
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" + "key=" + key + ", value=" + value + '}';
        }
    }

    private Node<K, V>[] buckets;
    private int capacity = 5;
    private int size = 0;

    public MyHashMap() {
        buckets = new Node[capacity];
    }


    public MyHashMap(int capacity) {
        this();
        this.capacity = capacity;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
        if (size > capacity) {
            resize();
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Node<K, V>[] newTable = new Node[newCapacity];
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = buckets[i];
            while (node != null) {
                Node<K, V> next = node.next;
                int index = hash(node.key);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
        buckets = newTable;
        capacity = newCapacity;
    }

    public V get(K key) {
        if (null == key) return null;
        int index = hash(key);
        Node<K, V> node = buckets[index];
        if (null == node) return null;
        while (null != node) {
            if (node.key.equals(key)) {
                return node.value;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        Node<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
//        for (int i = 0; i < buckets.length; ++i)
//            if (buckets[i] != null) buckets[i] = null;
        buckets = new Node[capacity];
        size = 0;
    }

    @Override
    public String toString() {
        return "MyHashMap{" + "buckets=" + Arrays.toString(buckets) + ", capacity=" + capacity + '}';
    }

    public static void main(String[] args) {

        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Ukraine", "Kyiv");
        map.put("Polska", "Warshava");
        map.put("Chech", "Praha");
        System.out.println("map.get(\"Chech\") = " + map.get("Chech"));
        map.put("Slovakia", "Bratislava");
        System.out.println(map);
        map.remove("Polska");
        System.out.println(map);
        map.clear();
        System.out.println(map);
        System.out.println("map.size() = " + map.size());
        System.out.println(map);
    }
}


