package com.mephi.rouol;

public class DynamicArray<E> {

    // Defaults
    private static final int DEFAULT_BUFFER_SIZE = 10;
    //private static final int DEFAULT_CAPACITY = DEFAULT_BUFFER_SIZE * 3;

    // count
    private int count = 0;
    //private int LCap = DEFAULT_BUFFER_SIZE;
    private int RCap = DEFAULT_BUFFER_SIZE;

    //This array will store all elements added to list
    private E data[];

    //                        CONSTRUCTOR
    //-----------------------------------------------------------
    // by size
    public DynamicArray(int size) {
        data = (E[]) new Object[size + DEFAULT_BUFFER_SIZE];
    }

    //                          METHODS
    //-----------------------------------------------------------
    // add to the end
    public void add(E e) {

        if (this.RCap > 0) {
            data[count++] = e;
            RCap--;
        } else {
            refreshRCap();
            data[count++] = e;
            RCap--;
        }
    }

    // Get method
    public E get(int index) {
        if (index == count || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) data[index];
    }

    private void refreshRCap() {
        int newSize = this.data.length + DEFAULT_BUFFER_SIZE;
        Object[] temp_data = data;
        data = (E[]) new Object[newSize];
        System.arraycopy(temp_data, 0, data, 0, newSize);
    }

    // toString method
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < this.count ;i++) {
            sb.append(this.data[i].toString());
            if(i < this.count - 1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

}
