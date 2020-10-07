package csci.tamuc.edu;

/**
 * @author ruby_
 * @create 2020-10-05-2:40 PM
 */

public class Array {

    private int size; //point to last avaiable empty space
    private int[] data; //actual data storage

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = new int[capacity];
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

    public int get(int index) {// return the element in that data at index: index
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Invalid access, index out of range");
        return data[index];
    }

    public void append(int val) {
        insert(size, val);
//        if(size == data.length)
//            throw new IllegalArgumentException("Fails because array is full");
//
//        data[size++] = val;
    }

    public void insert(int index, int val) {
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

    public void set(int index, int val) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid access, index out of range");

        data[index] = val;
    }

    public boolean contains(int target) {
        for(int e : data) {
            if(e == target) return true;
        }

        return false;
    }

    //find the index holds target
    public int find(int target) {
        for(int i = 0; i < size; i++) {
            if(data[i] == target) return i;
        }

        return -1;
    }

    public int delete(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid access, index out of range");

        int ret = data[index];

        //copy [index + 1, size - 1]
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current size: " + size + ", capacity: " + data.length + "\n[");
        for(int e : data) {
            sb.append(e + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}
