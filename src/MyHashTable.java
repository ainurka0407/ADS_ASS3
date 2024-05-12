public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private final K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }}

    private HashNode<K, V>[] chainArray;
    private int InitialCapacity = 11;

    private int size;

    public MyHashTable(int InitialCapacity){
        if(InitialCapacity <0) {
            throw new IllegalArgumentException("Initial capacity must be a positive integer");
        }
        this.InitialCapacity = InitialCapacity;
        chainArray = new HashNode[InitialCapacity];
        this.size = 0;
        }
    private int hash(K key){
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int hashCode = key.hashCode();
        if(hashCode < 0 ){
            hashCode = -hashCode;
        }
        return hashCode % chainArray.length;}
    public void put(K key, V value){
        if (key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        if(chainArray[index] == null){
            chainArray[index] = new HashNode<>(key, value);
            size++;
        }
        else{
            HashNode<K,V> current = chainArray[index];
            while(current.next != null){
                current = current.next;
            }
            current.next = new HashNode<>(key,value);
            size++;
        }}
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        if (chainArray[index] == null) {
            return null;
        }
        HashNode<K, V> current = chainArray[index];
        if (current.key.equals(key)) {
            chainArray[index] = current.next;
            size--;
            return current.value;
        }
        if (current.next != null && current.next.key.equals(key)) {
            V value = current.next.value;
            current.next = current.next.next;
            size--;
            return value;
        }
        current = current.next;
        return null;
    }
    public boolean contains(V value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        for (HashNode<K, V> current : chainArray) {
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    public K getKey(V value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        for (HashNode<K, V> current : chainArray) {
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }}


