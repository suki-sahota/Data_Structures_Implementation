/**
 * Author: Suki Sahota
 */
import java.util.InputMismatchException;

public class MyLinkedHashMap<K, V> implements MyMap<K, V> {
    private final static int DEFAULT_SIZE = 8;

    private MyHashNode<K, V>[] hashTable;
    private int sz;
    private int cap;
    private boolean first;
    private Class keyType;
    private Class valType;

    public MyLinkedHashMap(int length) {
        hashTable = (MyHashNode<K, V>[]) new MyHashNode[length];
        sz = 0;
        cap = length;

        first = true;
    }

    public MyLinkedHashMap() {
        this(DEFAULT_SIZE);
    }

    public void clear() {
        hashTable = new MyHashNode[DEFAULT_SIZE];
        sz = 0;
        cap = DEFAULT_SIZE;
    }

    public boolean containsKey(K key) {
        if (!first && key.getClass() != keyType) {
            throw new InputMismatchException("Type mismatch");
        }

        for (int i = 0; i < cap; ++i) {
            // Find node at this entry
            MyHashNode<K, V> curNode = hashTable[i];

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
        if (!first && val.getClass() != valType) {
            throw new InputMismatchException("Type mismatch");
        }

        for (int i = 0; i < cap; ++i) {
            // Find node at this entry
            MyHashNode<K, V> curNode = hashTable[i];

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
        if (!first && key.getClass() != keyType) {
            throw new InputMismatchException("Type mismatch");
        }

        V ret = null;

        int hashCode = key == null ? 0 : key.hashCode();
        int index = Math.abs(hashCode % cap);

        MyHashNode<K, V> curNode = hashTable[index];
        while (curNode != null) {
            if (key == null ? curNode.key == null : key.equals(curNode.key)) {
                ret = curNode.val;
                break;
            }
            curNode = curNode.next;
        }
        return ret;
    }

    public V getOrDefault(K key, V defaultValue) {
        if (!first &&
            (key.getClass() != keyType || defaultValue.getClass() != valType))
        {
            throw new InputMismatchException("Type mismatch");
        }

        V ret = defaultValue;

        int hashCode = key == null ? 0 : key.hashCode();
        int index = Math.abs(hashCode % cap);

        MyHashNode<K, V> curNode = hashTable[index];
        while (curNode != null) {
            if (key == null ? curNode.key == null : key.equals(curNode.key)) {
                ret = curNode.val;
                break;
            }
            curNode = curNode.next;
        }
        return ret;
    }

    public boolean isEmpty() {
        return sz == 0 ? true : false;
    }

    public V put(K key, V val) {
        if (first) {
            keyType = key.getClass();
            valType = val.getClass();
            first = false;
        }
        if (key.getClass() != keyType || val.getClass() != valType) {
            throw new InputMismatchException("Type mismatch");
        }

        V ret = null;
        boolean found = false;

        int hashCode = key == null ? 0 : key.hashCode();
        int index = Math.abs(hashCode % cap);

        MyHashNode<K, V> curNode = hashTable[index];
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
            MyHashNode<K, V> newNode = 
                new MyHashNode(key, val, hashTable[index]);
            if (hashTable[index] != null) { hashTable[index].prev = newNode; }
            hashTable[index] = newNode;
            ++sz;

            if (sz == cap) { doubleHashTable(); }
        }

        return ret;
    }

    public V remove(K key) {
        if (!first && key.getClass() != keyType) {
            throw new InputMismatchException("Type mismatch");
        }

        V ret = null;

        int hashCode = key == null ? 0 : key.hashCode();
        int index = Math.abs(hashCode % cap);

        MyHashNode<K, V> curNode = hashTable[index];
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

                if ((sz <= cap / 4) && (cap >= DEFAULT_SIZE * 2)) {
                    halveHashTable();
                }

                break;
            }
            curNode = curNode.next;
        }

        return ret;
    }

    public int size() {
        return sz;
    }

    // Helper functions
    private void doubleHashTable() {
        resizeHashTable(cap, cap * 2);
    }

    private void halveHashTable() {
        resizeHashTable(cap, cap / 2);
    }

    private void resizeHashTable(int oldCap, int newCap) {
        MyHashNode<K, V>[] myNewHashTable = new MyHashNode[newCap];

        for (int i = 0; i < oldCap; ++i) {
            MyHashNode<K, V> curNode = hashTable[i];

            while (curNode != null) {
                // Rehash to index in resized hashtable
                int hashCode = curNode.key == null 
                    ? 0 
                    : curNode.key.hashCode();
                int newIndex = Math.abs(hashCode % newCap); // cap is resized

                // Save next node in temporary node
                MyHashNode<K, V> tempNode = curNode.next;

                curNode.next = myNewHashTable[newIndex];
                if (myNewHashTable[newIndex] != null) {
                    myNewHashTable[newIndex].prev = curNode;
                }
                myNewHashTable[newIndex] = curNode;

                curNode = tempNode;
            }
        }

        hashTable = myNewHashTable;
        cap = newCap;
    }
}
