package edu.tamuc.csci.common;

/**
 * @author ruby_
 * @create 2020-10-05-2:40 PM
 */

public class Array<E> {//generic type java 1.5

    private int size; //point to last avaiable empty space
    private E[] data; //actual data storage

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public E get(int index) {// return the element in that data at index: index
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Invalid access, index out of range");
        return data[index];
    }

    public void appendFirst(E val) {
        insert(0, val);//o(n)
    }

    public void append(E val) {
        insert(size, val); //o(1)
//        if(size == data.length)
//            throw new IllegalArgumentException("Fails because array is full");
//
//        data[size++] = val;
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void insert(int index, E val) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid access, index out of range");

        if(size == getCapacity()) resize(size * 2);

        //copy all elements in [index, size - 1] >> 1
        for(int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        //modify index
        data[index] = val;
        size++;
    }

    private void resize(int newCap) {
        //1) create a newData to hold
        E[] newData = (E[]) new Object[newCap];

        //2) copy original data to this new Data
//        for(int i = 0; i < size; i++) {
//            newData[i] = data[i];
//        }
        System.arraycopy(data, 0, newData, 0, size);

        //3) point data reference to newData
        data = newData;
    }

    public void set(int index, E val) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid access, index out of range");

        data[index] = val;
    }

    public boolean contains(E target) {
        for(E e : data) {
            if(e.equals(target)) return true;
        }

        return false;
    }

    //find the index holds target
    public int find(E target) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(target)) return i;
        }

        return -1;
    }

    public E delete(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid access, index out of range");

        E ret = data[index];

        //copy [index + 1, size - 1]
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

//        size--;
        data[--size] = null;

        if(size < data.length / 4  &&  data.length / 2 != 0) {
            resize(data.length / 2); //lazy mode
        }

        return ret;
    }

    public E removeLast() {
        return delete(size - 1);
    }

    public E removeFirst() {
        return delete(0);
    }

    //remove the first find target
    public void removeElement(E target) {
        for(int i = 0; i < size; i++) {
            if(!data[i].equals(target)) continue;

            delete(i);
            break;
        }
    }

    //remove all values that's equal to target
    public void removeAll(E target) {
        for(int i = 0; i < size; i++) {
            if(!data[i].equals(target)) continue;

            delete(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current size: " + size + ", capacity: " + data.length + "\n[");
        for(E e : data) {
            sb.append(e + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void swap(int i, int j) {
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
