package se.kth.id1020.fundamentals;

import java.util.Iterator;
import java.util.ListIterator;

public class TaskSixSortedIntQueue implements Iterable<Integer>{
    private Node first;
    private Node last;
    private int size;

    private class Node{
        int value;
        Node next;
    }

    public TaskSixSortedIntQueue(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){ return first == null; }

    public int getSize(){ return size; }

    /**
     * Insert a new value into the queue so that the elements in the queue
     * are in ascending order.
     * @param value the value to insert.
     */
    public void insert(int value){
        if(isEmpty()){
            first = new Node();
            first.value = value;
            last = first;
        }
        else{
            if(value < first.value){
                Node oldFirst = first;
                first = new Node();
                first.value = value;
                first.next = oldFirst;
            }
            else{
                //insert after
                ListIterator<Integer> iterator = new ListIterator<>();
                while(iterator.hasNext()){}
            }
        }
        size++;
        //printIterable();
    }

    /**
     * Remove the largest value from the queue.
     * This element should be last in the queue.
     * @return the removed value.
     */
    public int removeLargest(){
        int removedValue = 0;

        size--;
        //printIterable();
        return removedValue;
    }

    public Iterator<Integer> iterator(){ return new ListIterator<Integer>(); }

    private class ListIterator<I> implements Iterator{
        private Node current = first;
        public boolean hasNext(){ return current != null;}
        public void remove(){}
        public Integer next(){
            int value = current.value;
            current = current.next;
            return value;
        }
    }
}
