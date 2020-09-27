package se.kth.id1020.searching;

/**
 * A hash table using separate chaining.
 * @param <Key> the hash value
 * @param <Value> a resizable ST containing key-value pairs associated with the hash value
 */

public class HashTable<Key extends Comparable<Key>, Value>{
    private int size;
    private OrderedArrayST<Key, Value>[] hashSTPair;

    /**
     * Default constructor that creates a hash table with 101 slots.
     */
    public HashTable(){this(101);}

    /**
     * Constructor with custom slot size.
     * @param size the number of slots in the hash table.
     */
    public HashTable(int size){
        this.size = size;
        hashSTPair = (OrderedArrayST<Key, Value>[]) new OrderedArrayST[size];
        for(int i=0; i<size; i++){
            hashSTPair[i] = new OrderedArrayST(); //a key-value pair for each slot in the hash table
        }
    }

    private int hash(Key key){
        //the hex value changes the signed bit to 0 in case of a negative hash value
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public Value get(Key key){
        return hashSTPair[hash(key)].get(key);
    }
    public void put(Key key, Value val){
        int hash = hash(key);
        hashSTPair[hash].put(key, val);
    }

    public void showHashDistribution(){
        int totalKeys = 0;
        for(int i = 0; i< hashSTPair.length; i++){
            System.out.println("Hash: " + i + ", Number of keys at this hash: " + hashSTPair[i].getSize());
            totalKeys += hashSTPair[i].getSize();
        }
        System.out.println("Total number of keys in the hash table: " + totalKeys);
    }
}
