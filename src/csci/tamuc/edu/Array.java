package csci.tamuc.edu;

/**
 * @author ruby_
 * @create 2020-10-05-2:40 PM
 */

public class Array<T> {

    private int size; //point to last avaiable empty space
    private T[] data; //actual data storage

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
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

    public T get(int index) {// return the element in that data at index: index
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Invalid access, index out of range");
        return data[index];
    }

    public void append(T val) {
        insert(size, val);
//        if(size == data.length)
//            throw new IllegalArgumentException("Fails because array is full");
//
//        data[size++] = val;
    }

    public void insert(int index, T val) {
        if(size == data.length)
            throw new IllegalArgumentException("Fails because array is full"); //todo: resize the data

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid access, index out of range");

        //copy all elements in [index, size - 1] >> 1
        for(int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        //modify index
        data[index] = val;
        size++;
    }

    public void set(int index, T val) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid access, index out of range");

        data[index] = val;
    }

    public boolean contains(T target) {
        for(T e : data) {
            if(e.equals(target)) return true;
        }

        return false;
    }

    //find the index holds target
    public int find(T target) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(target)) return i;
        }

        return -1;
    }

    public T removeLast() {
        return delete(size - 1);
    }

    public T removeFirst() {
        return delete(0);
    }

    public void removeElement(T target) {
        for(int i = 0; i < size; i++) {
            if (!data[i].equals(target)) continue;

            delete(i);
            break;
        }
    }

    public void removeAll(T target) {
        for(int i = 0; i < size; i++) {
            if (!data[i].equals(target)) continue;

            delete(i);
        }
    }

    public T delete(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid access, index out of range");

        T ret = data[index];

        //copy [index + 1, size - 1]
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
//        size--;
        data[--size] = null;
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current size: " + size + ", capacity: " + data.length + "\n[");
        for(T e : data) {
            sb.append(e + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}
