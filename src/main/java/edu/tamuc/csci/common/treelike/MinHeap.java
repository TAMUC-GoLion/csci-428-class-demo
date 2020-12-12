package edu.tamuc.csci.common.treelike;

import edu.tamuc.csci.common.basic.Array;

/**
 * @author ruby_
 * @create 2020-10-17-6:11 PM
 */

public class MinHeap<E extends Comparable<E>> {

    Array<E> data;

    public MinHeap (int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if(index == 0) return -1;
        return (index - 1) / 2; // (data.len - 2) / 2 ==> data.len / 2 - 1
    }

    private int lChild(int index) {
        return 2 * index + 1;
    }

    private int rChild(int index) {
        return 2 * index + 2;
    }

    public void offer(E val) {
        data.append(val);
        heapifyUp(size() - 1);
    }

    private void heapifyUp(int i) {
        while (i != 0 && data.get(i).compareTo(data.get(parent(i))) < 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    public E poll() {
        if(isEmpty()) throw new IllegalArgumentException("Heap is empty");

        data.swap(0, size() - 1);
        E ret = data.removeLast();
        heapifyDown(0);

        return ret;
    }

    private void heapifyDown(int i) {
        while(lChild(i) < size()) {
            int minChild = lChild(i);
            if(rChild(i) < size() && data.get(rChild(i)).compareTo(data.get(minChild)) < 0) minChild = rChild(i);

            if(data.get(i).compareTo(data.get(minChild)) <= 0) return;

            data.swap(i, minChild);
            i = minChild;
        }
    }

    public E peek() {
        if(isEmpty()) throw new IllegalArgumentException("Error: heap is empty");
        return data.get(0);
    }
}
