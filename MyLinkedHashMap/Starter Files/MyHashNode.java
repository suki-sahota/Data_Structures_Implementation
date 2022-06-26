/**
 * Author: Suki Sahota
 */
public class MyHashNode<K, V> {
    public K key;
    public V val;
    public MyHashNode<K, V> next;
    public MyHashNode<K, V> prev;

    // No-argument constructor
    public MyHashNode() {
        this.key = null;
        this.val = null;
        next = null;
        prev = null;
    }

    // Two-argument constructor
    public MyHashNode(K key, V val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }

    // Three-argument constructor
    public MyHashNode(K key, V val, MyHashNode<K, V> next) {
        this.key = key;
        this.val = val;
        this.next = next;
        prev = null;
    }

    // Four-argument constructor
    public MyHashNode(K key, V val, MyHashNode<K, V> next,
        MyHashNode<K, V> prev)
    {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
