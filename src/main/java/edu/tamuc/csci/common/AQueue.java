package edu.tamuc.csci.common;

import edu.tamuc.csci.api.Queue;

/**
 * @author ruby_
 * @create 2020-10-16-4:17 PM
 */

public class AQueue<E> implements Queue<E> {
    Array<E> data;

    public AQueue() {data = new Array<>();}
    public AQueue(int capacity) { data = new Array<>(capacity);}

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void offer(E val) {
        data.append(val);
    }

    @Override
    public E poll() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: head --> [");
        for(int i = 0; i < size(); i++) {
            sb.append(data.get(i));
            if(i != size() - 1) sb.append(",");
        }
        sb.append("] <-- tail");
        return sb.toString();
    }
}
