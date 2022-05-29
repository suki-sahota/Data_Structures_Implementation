/**
 * Author: Suki Sahota
 */
public class MyNode<K, V> {
    public K key;
    public V val;
    public MyNode<K, V> next;
    public MyNode<K, V> prev;

    // No-argument constructor
    public MyNode() {
        this.key = null;
        this.val = null;
        next = null;
        prev = null;
    }

    // Two-argument constructor
    public MyNode(K key, V val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }

    // Three-argument constructor
    public MyNode(K key, V val, MyNode<K, V> next) {
        this.key = key;
        this.val = val;
        this.next = next;
        prev = null;
    }

    // Four-argument constructor
    public MyNode(K key, V val, MyNode<K, V> next, MyNode<K, V> prev) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
