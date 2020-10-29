package edu.tamuc.csci.common;

import edu.tamuc.csci.api.Queue;

/**
 * @author ruby_
 * @create 2020-10-28-10:00 PM
 *
 *  Demonstration on applying ArrayDeque
 */

public class DQueue<E> implements Queue<E> {

    private E[] data;
    private int head, tail;
    private static final int MIN_INIT_CAP = 8;
    private static final int MAX_CAP = Integer.MAX_VALUE - 8;

    public DQueue() {
        this(MIN_INIT_CAP);
    }

    public DQueue(int cap) {
        data = (E[]) new Object[calc(cap)];
    }

    private int calc(int cap) {
        int minCap = MIN_INIT_CAP;
        if (cap > minCap) {
            minCap = cap;
            minCap |= (minCap >>> 1);
            minCap |= (minCap >>> 2);
            minCap |= (minCap >>> 4);
            minCap |= (minCap >>> 8);
            minCap |= (minCap >>> 16);

            if (minCap < 0) minCap >>>= 1;
        }
        return minCap;
    }

    @Override
    public int size() {
        if ((tail & Integer.MAX_VALUE) == head) return tail < 0 ? data.length : 0;
        return tail > head ? tail - head : data.length - head + tail;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void offer(E val) {
        if (size() == data.length) resize(data.length << 1);
        data[tail++] = val;

        if (tail == data.length) tail = 0;
        if (tail == head) tail |= Integer.MIN_VALUE;
    }

    private void resize(int cap) {
        if (data.length == MAX_CAP) throw new IllegalArgumentException("Too big to be real...");

        final int newCap = cap < 0 ? MAX_CAP : cap;
        final int size = size();
        E[] newData = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) newData[i] = data[head + i & data.length - 1];

        head = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E poll() {
        if (isEmpty()) throw new IllegalArgumentException("Too real to be a good girl...");
        if (size() == data.length) tail &= Integer.MAX_VALUE;

        E ret = data[head++];
        if (head == data.length) head = 0;
        if (size() < data.length / 3 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalArgumentException("Too real to be a good girl...");
        return data[head];
    }
}