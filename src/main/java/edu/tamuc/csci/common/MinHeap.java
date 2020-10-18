package edu.tamuc.csci.common;

/**
 * @author ruby_
 * @create 2020-10-17-6:11 PM
 */

public class MinHeap<E extends Comparable<E>> {

    Array<E> data;

    public MinHeap() {
        this(10);
    }

    public MinHeap(int cap) {
        data = new Array<>(10);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) return -1;
        return (index - 1) / 2;
    }

    private int lChild(int index) {
        return 2 * index + 1;
    }

    private int rChild(int index) {
        return 2 * index + 2;
    }

    /**
     * Add element
     *
     * @param val
     */
    public void add(E val) {
        data.append(val);

        int i = data.size() - 1;
        heapifyUp(i);
    }

    private void heapifyUp(int i) {
        while (i != 0 && data.get(i).compareTo(data.get(parent(i))) < 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        while(lChild(i) < size()) {
            int minChild = lChild(i);
            if(rChild(i) < size() && data.get(rChild(i)).compareTo(data.get(minChild)) < 0) minChild = rChild(i);

            if(data.get(i).compareTo(data.get(minChild)) < 0) return;

            data.swap(i, minChild);
            i = minChild;
        }
    }

    /**
     * Extract the min value
     *
     * @return
     */
    public E extractMin() {
        if (isEmpty()) throw new IllegalArgumentException("Heap is empty");
        data.swap(0, data.size() - 1);
        E ret = data.removeLast();
        heapifyDown(0);
        return ret;
    }

    public E peek() {
        if (isEmpty()) return null;

        return data.getFirst();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
