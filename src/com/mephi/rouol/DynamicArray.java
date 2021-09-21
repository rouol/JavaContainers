package com.mephi.rouol;

import java.util.Arrays;

public class DynamicArray<T> {

    // Defaults
    private static final int DEFAULT_BUFFER_SIZE = 10;
    //private static final int DEFAULT_CAPACITY = DEFAULT_BUFFER_SIZE * 3;

    // count
    private int count = 0;
    //private int LCap = DEFAULT_BUFFER_SIZE;
    private int RCap = DEFAULT_BUFFER_SIZE;

    //This array will store all elements added to list
    private T data[];

    //                        CONSTRUCTOR
    //-----------------------------------------------------------
    // empty
    public DynamicArray() {
        data = (T[]) new Object[0 + DEFAULT_BUFFER_SIZE];
        count = 0;
    }
    // by size and value
    public DynamicArray(int size, T defaultValue) {
        data = (T[]) new Object[size + DEFAULT_BUFFER_SIZE];
        for (int i = 0; i < size; i++){
            data[i] = (T) defaultValue;
        }
        count = size;
    }

    //                          METHODS
    //-----------------------------------------------------------
    // add to the end
    public void add(T e) {

        if (this.RCap > 0) {
            data[count++] = e;
            RCap--;
        } else {
            refreshRCap();
            data[count++] = e;
            RCap--;
        }
    }
    // add by index
    public void add(T e, int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + count);
        }
        data[index] = e;
    }
    // get method
    public T get(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + count);
        }
        return (T) data[index];
    }
    // remove method
    public T remove(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + count);
        }
        data[index] = null;
        return (T) data[index];
    }
    // set method
    public T set(T e, int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + count);
        }
        data[index] = e;
        return (T) data[index];
    }
    // contains method
    public Boolean contains(T e) {
        for (int i = 0; i < this.count; i++) {
            if (this.get(i) == e) return true;
        }
        return false;
    }

    private void refreshRCap() {
        data = Arrays.copyOf(data, this.data.length + DEFAULT_BUFFER_SIZE);
    }

    // toString method
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < this.count; i++) {
            sb.append(this.get(i).toString());
            if (i < this.count - 1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    // get size
    public int size() {
        return this.count;
    }

}
