package edu.tamuc.csci.common.MapAndSet;

import edu.tamuc.csci.api.Map;

/**
 * Demo: Customized HashMap with Binary Search Tree
 */

public class HashMap<K extends Comparable<K>, V> implements Map<K, V> {

    private BSTMap<K, V>[] table;
    private int capacity;
    private int size;

    public HashMap(int capacity) {
        this.capacity = capacity;
        table = new BSTMap[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new BSTMap<>();
        }
    }

    private int hash(K key) {//0x0111...1 <- 31 1's
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    @Override
    public void put(K key, V value) {
        BSTMap<K, V> map = table[hash(key)];
        if(!map.contains(key)) size++;
        map.put(key, value);
    }

    @Override
    public boolean contains(K key) {
        return table[hash(key)].contains(key);
    }

    @Override
    public V get(K key) {
        return table[hash(key)].get(key);
    }

    @Override
    public V remove(K key) {
        V ret = null;
        BSTMap<K, V> map = table[hash(key)];
        if (map.contains(key)) {
            size--;
            ret = map.remove(key);
        }
        return ret;
    }

    @Override
    public int getSize() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }
}
