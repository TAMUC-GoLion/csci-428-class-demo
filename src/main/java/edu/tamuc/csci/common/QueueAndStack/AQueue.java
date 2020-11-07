package edu.tamuc.csci.common.QueueAndStack;

import edu.tamuc.csci.api.Queue;
import edu.tamuc.csci.common.Basic.Array;

/**
 * @author ruby_
 * @create 2020-10-19-2:49 PM
 */

public class AQueue<E> implements Queue<E> {

    Array<E> data; //head would always be 0, tail would always be size() - 1

    public AQueue(int capacity) {
        data = new Array<>(capacity);
    }

    public AQueue() {
        data = new Array<>();
    }

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
        sb.append("Array Queue, head -> [");
        for(int i = 0; i < data.size(); i++) {
            sb.append(data.get(i));
            if(i != size() - 1) sb.append(",");
        }
        sb.append("] <- tail");
        return sb.toString();
    }
}
