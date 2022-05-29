/**
 * Author: Suki Sahota
 */
public interface MyMap<K, V> {
    public void clear();

    public boolean containsKey(K key);

    public boolean containsValue(V val);

    public V get(K key);

    public V getOrDefault(K key, V defaultValue);

    public boolean isEmpty();

    public V put(K key, V val);

    public V remove(K key);

    public int size();
}
