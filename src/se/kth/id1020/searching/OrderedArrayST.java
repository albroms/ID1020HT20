package se.kth.id1020.searching;

import se.kth.id1020.fundamentals.SimpleQueue;

/**
 * @param <Key>
 * @param <Value>
 */
public class OrderedArrayST <Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] vals;
    private int size;

    public OrderedArrayST(int capacity){
        //See method below for array-resizing code.
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    /**
     * Default constructor that creates arrays with a capacity of 1 element.
     * This should be a resizable array.
     */
    public OrderedArrayST(){
        int defaultCap = 0;
        this.size = defaultCap;
        keys = (Key[]) new Comparable[defaultCap];
        vals = (Value[]) new Object[defaultCap];
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

    /**
     * O(N)
     * @param key
     * @param val
     */
    public void put(Key key, Value val){
        int i = rank(key);
        //check that there is enough space to continue
        if(size == keys.length){
            if(size == 0){
                resize(1);
            }
            else {
                int newSize = 2*keys.length;
                resize(newSize);
            }
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

    /**
     * O(log(N))
     * @param key
     * @return
     */
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
     * Returns the number of keys strictly less than the parameter key.
     * O(log(N))
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

    //min() and max()
    public Key min(){ return keys[0];}
    public Key max(){ return keys[size-1];}

    /**
     * Return an iterable which iterates through all the keys
     * @return an iterable with all the keys
     */
    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    /**
     * Return an iterable which iterates through the keys in a given interval
     * @param lo the lower bounds
     * @param hi the upper bounds
     * @return an iterable with the keys in the given span
     */
    public Iterable<Key> keys(Key lo, Key hi){
        SimpleQueue<Key> q = new SimpleQueue<>();
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
