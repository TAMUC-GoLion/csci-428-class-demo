package edu.tamuc.csci.api;

public interface Queue<E> {
    int size();
    boolean isEmpty();
    void offer(E val); //enqueue
    E poll(); //remove head, return null if isEmpty()
    E peek(); //get head, return null if isEmpty()
}
