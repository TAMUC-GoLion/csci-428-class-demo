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

    public BQueue(int capacity) {
        data = (E[]) new Object[capacity];
//        head = 0;
//        tail = 0;
    }

    public BQueue() {this(10);}

    @Override
    public int size() {
        if((tail & Integer.MAX_VALUE) == head) return tail < 0 ? data.length : 0;
        return tail > head ? tail - head : data.length - head + tail;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void offer(E val) {//enqueue a new element
        if(size() == data.length) resize(2 * data.length);

        data[tail++] = val;
        if(tail == data.length) tail = 0;
        if(tail == head) tail |= Integer.MIN_VALUE;
    }

    private void resize(int cap) {
        E[] newData = (E[]) new Object[cap];
        final int size = size();
        for(int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % data.length];
        }

        head = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E poll() {//Dequeue an element
        if(isEmpty()) throw new IllegalArgumentException("Error: queue is empty");
        if(size() == data.length) tail &= Integer.MAX_VALUE;

        E ret = data[head++];

        if(head == data.length) head = 0;

        if(size() < data.length / 3 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new IllegalArgumentException("Error: queue is emtpy");
        return data[head];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue of capacity: " + data.length + ": head -> [");
        for(int i = 0; i < size(); i++) {
            sb.append(data[(head + i) % data.length]);
            if(i != size() - 1) sb.append(",");
        }
        sb.append("] <- tail");
        return sb.toString();
    }
}
