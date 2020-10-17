package edu.tamuc.csci.common;

import edu.tamuc.csci.api.Queue;

/**
 * @author ruby_
 * @create 2020-10-16-4:37 PM
 */

public class BQueue<E> implements Queue<E> {

    private E[] data;
    private int head, tail;

    public BQueue(int cap) {
        data = (E[]) new Object[cap];
    }

    public BQueue() {this(10);}

    @Override
    public int size() {
        if((tail & Integer.MIN_VALUE - 1) == head) return tail < 0 ? data.length : 0;
        else return tail > head ? tail - head : data.length - head + tail;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void offer(E val) {
        if(size() == data.length) resize(data.length * 2);

        data[tail++] = val;
        if(tail == data.length) tail = 0;
        if(tail == head) tail |= Integer.MIN_VALUE; //set up isFull indicator
    }

    private void resize(int cap) {
        E[] tmp = (E[]) new Object[cap];
        final int size = size();
        for(int i = 0; i < size; i++) tmp[i] = data[(head + i) % data.length];

        head = 0;
        tail = size;
        data = tmp;
    }

    @Override
    public E poll() {
        if(size() == 0) throw new IllegalArgumentException("Queue is empty");
        if(size() == data.length) tail &= Integer.MIN_VALUE - 1;

        E ret = data[head];
        data[head++] = null;
        if(head == data.length) head = 0;

        if(size() < data.length / 3 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }

    @Override
    public E peek() {
        if(size() == 0) throw new IllegalArgumentException("Queue is empty");
        return data[head];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: head -> [");
        for(int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if(i != data.length - 1) sb.append(",");
        }
        sb.append("] <- tail");
        return sb.toString();
    }
}
