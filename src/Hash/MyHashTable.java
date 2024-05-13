package Hash;

public class MyHashTable<K, V> {

    public class HashNode<K, V> {
        private final K key;
        private V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    public HashNode<K, V>[] chainArray;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.capacity = capacity;
        this.chainArray = new HashNode[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        int bucketIndex = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainArray[bucketIndex] == null) {
            chainArray[bucketIndex] = newNode;
        } else {
            HashNode<K, V> current = chainArray[bucketIndex];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public V get(K key) {
        int bucketIndex = hash(key);
        HashNode<K, V> current = chainArray[bucketIndex];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int bucketIndex = hash(key);
        HashNode<K, V> current = chainArray[bucketIndex];
        HashNode<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    chainArray[bucketIndex] = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean containsValue(V value) {
        for (HashNode<K, V> node : chainArray) {
            HashNode<K, V> current = node;
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
        for (HashNode<K, V> node : chainArray) {
            HashNode<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}

