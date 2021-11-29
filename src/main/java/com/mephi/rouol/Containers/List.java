package com.mephi.rouol.Containers;

//import java.util.Arrays;

public class List {

    // Defaults
    private static final int DEFAULT_BUFFER_SIZE = 16;

    // count
    private int count;
    //private int LCap = DEFAULT_BUFFER_SIZE;
    private int RCap = DEFAULT_BUFFER_SIZE;

    //This array will store all elements added to list
    private Object[] data;

    //                        CONSTRUCTOR
    //-----------------------------------------------------------
    /** creates empty List **/
    public List() {
        data = new Object[DEFAULT_BUFFER_SIZE];
        count = 0;
    }
    /** creates List with defined size with nulls **/
    public List(int size) {
        data = new Object[size + DEFAULT_BUFFER_SIZE];
        count = size;
    }
    /** creates List with defined size and fill it with default value given **/
    public List(int size, Object defaultValue) {
        data = new Object[size + DEFAULT_BUFFER_SIZE];
        for (int i = 0; i < size; i++){
            data[i] = defaultValue;
        }
        count = size;
    }
    /** creates List from Object[] given **/
    public List(Object[] objects) {
        data = objects;
        count = objects.length;
    }

    //                          METHODS
    //-----------------------------------------------------------
    /** add object to the end **/
    public void add(Object object) {

        if (this.RCap > 0) {
            data[count++] = object;
            RCap--;
        } else {
            refreshRCap();
            data[count++] = object;
            RCap--;
        }
    }
    /** insert object by index **/
    public void add(Object object, int index) {
        if (index > this.count || index < 0) {   // add to this.count = add to the end
            throw new IndexOutOfBoundsException("index=" + index + " > size=" + count);
        }
        if (this.count == this.data.length) refreshRCap();
        System.arraycopy(data, index, this.data, index + 1, this.count - index);
        this.count++;
        this.RCap--;
        data[index] = object;
    }
    /** returns object by index **/
    public Object get(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("index=" + index + " > size=" + count);
        }
        return data[index];
    }
    /** sets null and returns old object by index **/
    public Object remove(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("index=" + index + " > size=" + count);
        }
        Object _object = this.data[index];
        if (this.count - (index + 1) >= 0)
            System.arraycopy(data, index + 1, data, index, this.count - (index + 1));
        data[this.count - 1] = null;
        this.count--;
        this.RCap++;
        return _object;
    }
    /** sets new object and returns old object **/
    public Object set(Object object, int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + count);
        }
        Object _object = data[index];
        data[index] = object;
        return _object;
    }
    /** returns true if list contains object, false if not **/
    public Boolean contains(Object object) {
        if (object == null){
            for (int i = 0; i < this.count; i++) {
                if (this.get(i) == object) return true;
            }
            return false;
        }
        for (int i = 0; i < this.count; i++) {
            if (this.get(i).equals(object)) return true;
        }
        return false;
    }
    /** returns index of object **/
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < this.count; i++) {
                if (this.get(i) == object) return i;
            }
            return -1;
        }
        for (int i = 0; i < this.count; i++) {
            if (this.get(i).equals(object)) return i;
        }
        return -1;
    }
    /** returns current size of list **/
    public int size() {
        return this.count;
    }
    /** returns true if list is empty, false if not **/
    public Boolean isEmpty() {
        return this.count == 0;
    }
    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < this.count; i++) {
            sb.append(this.get(i).toString());
            if (i < this.count - 1){
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    // PUBLIC STATIC
    /** returns merged sorted list of two given sorted lists **/
    public static List mergeSortedLists(List A, List B){
        if (A.size() == 0) return B;
        if (B.size() == 0) return A;
        int newlen = A.size() + B.size();
        List mergedList = new List(newlen);
        int headA = 0;
        int headB = 0;
        int a = (int) A.get(headA);
        int b = (int) B.get(headB);
        for (int i = 0; i < newlen; i++) {
            if (headA >= A.size()) {
                mergedList.set(b, i);
                headB++;
                continue;
            }
            if (headB >= B.size()) {
                mergedList.set(a, i);
                headA++;
                continue;
            }
            if (a <= b) {
                mergedList.set(a, i);
                headA++;
                if (headA < A.size()) a = (int) A.get(headA);
            } else {
                mergedList.set(b, i);
                headB++;
                if (headB < B.size()) b = (int) B.get(headB);
            }
        }

        return mergedList;
    }

    //                     PRIVATE METHODS
    //-----------------------------------------------------------
    private void refreshRCap() {
        //data = Arrays.copyOf(data, this.data.length + DEFAULT_BUFFER_SIZE);
        Object[] _data = this.data;
        this.data = new Object[this.data.length + DEFAULT_BUFFER_SIZE];
        System.arraycopy(_data, 0, this.data, 0, this.count);
        RCap = DEFAULT_BUFFER_SIZE;
    }

}
