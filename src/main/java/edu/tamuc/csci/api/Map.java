package edu.tamuc.csci.api;

public interface Map<K, V> {

    void put(K key, V value);
    boolean contains(K key);
    V get(K key);
    V remove(K key);
    int getSize();
    boolean isEmpty();
}
