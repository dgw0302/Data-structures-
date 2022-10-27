package 集合;

public interface Map<K,V> {
    V put(K k, V v);

    V get(K k);

    int size();

    V remove(K k);

    boolean isEmpty();

    void clear();
}
