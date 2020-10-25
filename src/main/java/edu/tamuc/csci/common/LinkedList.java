package edu.tamuc.csci.common;

/**
 * @author ruby_
 * @create 2020-10-25-3:48 PM
 */

public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}

    private class Node<E> {
        E val;
        Node next;

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(E val) { this(val, null);}
        public Node() {this(null, null);}

        @Override
        public String toString() {
            return val.toString();
        }
    }
}
