package edu.tamuc.csci.common.MapAndSet;

import edu.tamuc.csci.api.Map;
import edu.tamuc.csci.common.TreeLike.BST;

/**
 * Demo: Map use BST
 */

public class BSTMap<K extends  Comparable<K>, V> implements Map<K, V> {
    BST<K, V> bst = new BST<>();

    @Override
    public void add(K key, V value) {
        bst.insert(key, value);
    }

    @Override
    public boolean contains(K key) {
        return bst.contains(key);
    }

    @Override
    public V get(K key) {
        return bst.valueOf(bst.getNode(key));
    }

    @Override
    public void set(K key, V value) {
        bst.set(key, value);
    }

    @Override
    public V remove(K key) {
        V ret = get(key);
        bst.remove(key);
        return ret;
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}