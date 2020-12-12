package edu.tamuc.csci.common.queueandstack;

import edu.tamuc.csci.api.Stack;
import edu.tamuc.csci.common.basic.Array;

/**
 * @author ruby_
 * @create 2020-10-14-1:14 PM
 */

public class AStack<E> implements Stack<E> {

    Array<E> data;

    public AStack() {
        data = new Array<>();
    }

    public AStack(int capacity) {
        data = new Array<>(capacity);
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
    public void push(E val) {
        data.append(val);
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: bottom ==> [");
        for(int i = 0; i < size(); i++) {
            sb.append(data.get(i));
            if(i != size() - 1) sb.append(",");
        }
        sb.append("] <== top");
        return sb.toString();
    }
}
