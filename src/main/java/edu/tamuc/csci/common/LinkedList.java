package edu.tamuc.csci.common;

import edu.tamuc.csci.api.Queue;

/**
 * @author ruby_
 * @create 2020-10-25-3:48 PM
 */

public class LinkedList<E> implements Queue<E> {

    private Node<E> head;
    private int size;

    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}

    @Override
    public void offer(E val) {
        add(size, val);
    }

    @Override
    public E poll() {
        final Node<E> h = head;
        return h == null ? null : unlinkFirst(h);
    }

    public void add(int index, E val) {
        if(index < 0 || index > size) throw new IllegalArgumentException("Error: Index out of boarder");

        if(index == 0) linkFirst(val);
        else {
            Node<E> pre = head;
            for(int i = 0; i < index - 1; i++) pre = pre.next;

//            Node<E> newNode = new Node<>(val, pre.next);
//            pre.next = newNode;
            pre.next = new Node<>(val, pre.next);

            size++;
        }
    }

    @Override
    public E peek() {
        final Node<E> h = head;
        return h == null ? null : head.val;
    }

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

    private void linkFirst(E val) {
//       Node<E> newNode = new Node<>(val, null);
//       newNode.next = head;
//       head = newNode;
        head = new Node<>(val, head);
        size++;
    }

    private E unlinkFirst(Node<E> h) {
        final E element = h.val;
        final Node<E> next = h.next;

        h.val = null;
        h.next = null;

        head = next;
        size--;
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: [");
        Node<E> cur = head;
        while(cur != null) {
            sb.append(cur.toString());
            if(cur.next != null) sb.append("->");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
