/**
 * Author: Suki Sahota
 */
 import java.lang.reflect.Array;

public class MyLinkedHashMap<K, V> implements MyMap<K, V> {
    private final static int DEFAULT_SIZE = 64;

    private boolean first;
    private MyNode<K, V>[] hashTable;
    private int sz;
    private int cap;

    public MyLinkedHashMap(int length) {
        hashTable = (MyNode<K, V>[]) new MyNode[length];

        first = true;
        sz = 0;
        cap = length;
    }

    public MyLinkedHashMap() {
        this(DEFAULT_SIZE);
    }

    public void clear() {
        hashTable = new MyNode[DEFAULT_SIZE];
        sz = 0;
        cap = DEFAULT_SIZE;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < cap; ++i) {
            // Find node at this entry
            MyNode<K, V> curNode = hashTable[i];

            // While loop through each node at this entry
            while (curNode != null) {
                if (key == null
                    ? curNode.key == null
                    : key.equals(curNode.key))
                {
                    return true;
                }
                curNode = curNode.next;
            }
        }
        return false;
    }

    public boolean containsValue(V val) {
        for (int i = 0; i < cap; ++i) {
            // Find node at this entry
            MyNode<K, V> curNode = hashTable[i];

            // While loop through each node at this entry
            while (curNode != null) {
                if (val == null
                    ? curNode.val == null
                    : val.equals(curNode.val))
                {
                    return true;
                }
                curNode = curNode.next;
            }
        }
        return false;
    }

    public V get(K key) {
        int hashCode = key == null ? 0 : key.hashCode();
        int index = Math.abs(hashCode % cap);

        MyNode<K, V> curNode = hashTable[index];
        while (curNode != null) {
            if (key == null ? curNode.key == null : key.equals(curNode.key)) {
                return curNode.val;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public V getOrDefault(K key, V defaultValue) {
        int hashCode = key == null ? 0 : key.hashCode();
        int index = Math.abs(hashCode % cap);

        MyNode<K, V> curNode = hashTable[index];
        while (curNode != null) {
            if (key == null ? curNode.key == null : key.equals(curNode.key)) {
                return curNode.val;
            }
            curNode = curNode.next;
        }
        return defaultValue;
    }

    public boolean isEmpty() {
        return sz == 0 ? true : false;
    }

    public V put (K key, V val) {
        V ret = null;
        boolean found = false;

        int hashCode = key == null ? 0 : key.hashCode();
        int index = Math.abs(hashCode % cap);

        MyNode<K, V> curNode = hashTable[index];
        while (curNode != null) {
            if (key == null ? curNode.key == null : key.equals(curNode.key)) {
                ret = curNode.val;
                curNode.val = val;
                found = true;
                break;
            }
            curNode = curNode.next;
        }

        if (!found) {
            // Create a new node and place it before curNode
            MyNode<K, V> newNode = new MyNode(key, val, hashTable[index]);
            if (hashTable[index] != null) { hashTable[index].prev = newNode; }
            hashTable[index] = newNode;
        }

        ++sz;
        return ret;
    }

    public V remove(K key) {
        V ret = null;

        int hashCode = key == null ? 0 : key.hashCode();
        int index = Math.abs(hashCode % cap);

        MyNode<K, V> curNode = hashTable[index];
        while (curNode != null) {
            if (key == null ? curNode.key == null : key.equals(curNode.key)) {
                ret = curNode.val;
                // Remove node from link
                if (curNode.prev == null) {
                    hashTable[index] = curNode.next;
                    curNode.next = null;
                } else if (curNode.next == null) {
                    curNode.prev.next = curNode.next;
                } else {
                    curNode.prev.next = curNode.next;
                    curNode.next.prev = curNode.prev;
                }

                curNode.prev = null;
                curNode.next = null;

                --sz;
                break;
            }
        }

        return ret;
    }

    public int size() {
        return sz;
    }
}
