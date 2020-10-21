package edu.tamuc.csci.common;

import edu.tamuc.csci.api.Queue;

/**
 * @author ruby_
 * @create 2020-10-19-3:05 PM
 */

public class BQueue<E> implements Queue<E> {
    private E[] data;
    private int head, tail;
    //boolean isFull

    @Override
    public int size() {
        if((tail & Integer.MIN_VALUE - 1) == head) return tail < 0 ? data.length : 0;
        else return tail > head ? tail - head : data.length - head + tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void offer(E val) {

    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
