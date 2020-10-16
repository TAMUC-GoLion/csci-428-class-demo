package edu.tamuc.csci.api;

public interface Stack<E> {
    int size();//return the size of stack, the number of the stored elements
    boolean isEmpty(); //
    void push(E val); //push
    E peek(); //watch the value on top of the stack
    E pop(); //take out the value on top

}
