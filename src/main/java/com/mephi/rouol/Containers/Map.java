package com.mephi.rouol.Containers;

public class Map {

    private class Entry
    {
        public Object key;
        public Object value;
        // toString method
        @Override
        public String toString() {
            return '(' +
                    key.toString() +
                    ", " +
                    value.toString() +
                    ')';
        }
    }

    private static final int DEFAULT_SIZE = 16;
    private int count;
    private int capacity;
    private List nodes;
    private List keys;

    //                        CONSTRUCTOR
    //-----------------------------------------------------------
    /** creates empty Map with default size **/
    public Map() {
        count = 0;
        capacity = DEFAULT_SIZE;
        nodes = new List(DEFAULT_SIZE);
        keys = new List();
    }
    /** creates empty Map by size **/
    public Map(int size) {
        count = 0;
        capacity = size;
        nodes = new List(size);
        keys = new List();
    }

    //                          METHODS
    //-----------------------------------------------------------
    /** put a value by the key **/
    public void put(Object key, Object value) {
        int index = key.hashCode() & (capacity - 1);

        if (this.nodes.get(index) == null) {
            List temp = new List();
            Entry entry = new Entry();
            entry.key = key;
            entry.value = value;
            temp.add(entry);
            this.nodes.add(temp, index);
            this.keys.add(key);
        } else { // have collision
            List temp = (List) nodes.get(index);
            // check if key is present
            for (int i = 0; i < temp.size(); i++) {
                Entry entry = (Entry) temp.get(i);
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }
            Entry entry = new Entry();
            entry.key = key;
            entry.value = value;
            temp.add(entry);
            this.keys.add(key);
        }

        count++;
    }
    /** get a value by the key **/
    public Object get(Object key) {

        int index = key.hashCode() & (capacity - 1);

        List temp = (List) nodes.get(index);
        if (temp == null) return -1;
        for (int i = 0; i < temp.size(); i++) {
            Entry entry = (Entry) temp.get(i);
            if (entry.key.equals(key)) return entry.value;
        }
        return -1;

    }
    /** get a value by the key, but if the value is null, then you must return the default value, which is set by the second parameter. The default value must be saved. **/
    public Object get(Object key, Object bydefault) {

        int index = key.hashCode() & (capacity - 1);

        List temp = (List) nodes.get(index);
        if (temp == null) {
            this.put(key, bydefault);
            return bydefault;
        }
        for (int i = 0; i < temp.size(); i++) {
            Entry entry = (Entry) temp.get(i);
            if (entry.key == key) return entry.value;
        }
        this.put(key, bydefault);
        return bydefault;

    }
    /** delete by key, returns the current value **/
    public Object remove(Object key) {

        int index = key.hashCode() & (capacity - 1);

        List temp = (List) nodes.get(index);
        if (temp == null) return -1;
        for (int i = 0; i < temp.size(); i++) {
            Entry entry = (Entry) temp.get(i);
            if (entry.key == null){
                if (entry.key == key) {
                    temp.remove(i);
                    keys.remove(keys.indexOf(key));
                    if (temp.size() == 0) temp = null;
                    this.count--;
                    return entry.value;
                }
            } else if (entry.key.equals(key)) {
                temp.remove(i);
                keys.remove(keys.indexOf(key));
                if (temp.size() == 0) temp = null;
                this.count--;
                return entry.value;
            }
        }
        return -1;

    }
    /** check if the key is present **/
    public boolean keyContains(Object key) {
        return this.keys.contains(key);
    }
    /** get a list of keys **/
    public List getKeys() {
        return this.keys;
    }
    /** get a list of values **/
    public List getValues() {

        List values = new List();

        for (int i = 0; i < this.capacity; i++) {
            Object obj = this.nodes.get(i);
            if (obj != null) {
                List list = (List) obj;
                for (int j = 0; j < list.size(); j++) {
                    Entry entry = (Entry) list.get(j);
                    values.add(entry.value);
                }
            }
        }

        return values;
    }
    /** get a list of entries **/
    public List getEntries() {

        List values = new List();

        for (int i = 0; i < this.capacity; i++) {
            Object obj = this.nodes.get(i);
            if (obj != null) {
                List list = (List) obj;
                for (int j = 0; j < list.size(); j++) {
                    values.add(list.get(j));
                }
            }
        }

        return values;
    }
    /** returns current size of map **/
    public int size() {
        return this.count;
    }
    /** returns true if map is empty, false if not **/
    public Boolean isEmpty() {
        return this.count == 0;
    }

    /**
    // toString method
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (int i = 0; i < this.capacity; i++) {
            Object obj = this.nodes.get(i);
            if (obj != null) {
                sb.append("    ");
                sb.append(i);
                sb.append(": ");
                sb.append(obj);
                if (i < this.capacity - 1){
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
    **/
    // toString method
    @Override
    public String toString() {
        List entryList = this.getEntries();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < entryList.size(); i++) {
            Entry entry = (Entry) entryList.get(i);
            //sb.append("    ");
            sb.append(entry.key.toString());
            sb.append(": ");
            sb.append(entry.value.toString());
            if (i < entryList.size() - 1){
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
