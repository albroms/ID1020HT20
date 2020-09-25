package se.kth.id1020.searching;

import se.kth.id1020.fundamentals.DoubleLinkedCircularQueue;

public class OrderedArrayST <Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] vals;
    private int size;

    public OrderedArrayST(int capacity){
        //See method below for array-resizing code.
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    private void resize(int newMax){
        Key[] auxKeys = (Key[]) new Comparable[newMax];
        Value[] auxVals = (Value[]) new Object[newMax];
        for(int i=0; i < size; i++){
            auxKeys[i] = keys[i];
            auxVals[i] = vals[i];
        }
        keys = auxKeys;
        vals = auxVals;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public void put(Key key, Value val){
        int i = rank(key);
        //check that there is enough space to continue
        if(size == keys.length){
            int newSize = 2*keys.length;
            resize(newSize);
        }

        if(i < size && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        for(int j = size; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        size++;
    }

    public Value get(Key key){
        if(isEmpty())
            return null;

        int i = rank(key);

        if(i < size && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }

    /**
     * Returns the number of keys less than the parameter key
     * @param key the reference key
     * @return number of keys with "lower value" than the reference key.
     */
    public int rank(Key key){
        int lo = 0;
        int hi = size-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0)
                hi = mid-1;
            else if(cmp > 0)
                lo = mid+1;
            else
                return mid;
        }
        return lo;
    }

    public Iterable<Key> keys(Key lo, Key hi){
        DoubleLinkedCircularQueue<Key> q = new DoubleLinkedCircularQueue<>();
        for(int i = rank(lo); i < rank(hi); i++){
            q.enqueue(keys[i]);
        }
        if(contains(hi)){
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }

    /**
     * Returns an array of strings representing the keys.
     * @return the array of strings.
     */
    public String[] keysToString(){
        String[] keysAsStrings = new String[size];
        for(int i=0; i < size; i++){
            keysAsStrings[i] = keys[i].toString();
        }
        return keysAsStrings;
    }
}
