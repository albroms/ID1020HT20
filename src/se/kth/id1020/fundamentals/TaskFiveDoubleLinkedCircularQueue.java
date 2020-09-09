package se.kth.id1020.fundamentals;

import java.util.Iterator;

/**
 * The queue data structure for task 5. I chose to implement a circular double linked list for this task so that
 * I can iterate in two directions
 * @param <Item>
 */
public class TaskFiveDoubleLinkedCircularQueue<Item>{
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item>{
        Item value;
        int index;
        Node<Item> next;
        Node<Item> prev;
    }

    /**
     * The Queue constructor, creates an empty queue.
     */
    public TaskFiveDoubleLinkedCircularQueue(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int getSize(){
        return size;
    }

    /**
     * Add an element to the end of the queue.
     * @param value the value of the Node to be added to the end of the queue.
     */
    public void enqueue(Item value) {
        if (isEmpty()) {
            first = new Node<>();
            first.value = value;
            last = first;
            first.next = last;
            first.prev = last;
            first.index = size + 1;
        } else {
            Node<Item> oldLast = last;
            last = new Node<>();
            last.value = value;
            last.index = size + 1;
            oldLast.next = last;
            first.prev = last;
            last.prev = oldLast;
            last.next = first;
        }
        size++;
        System.out.println("Added " + value + " to queue. Current Queue:");
        System.out.println("Iterative print:");
        printIterable();
    }

    /**
     * Remove the kth element from the queue.
     * @param k the index of the element we wish to remove.
     * @return the value of the removed node.
     */
    public Item remove(int k){
        ListIterator<Item> iterator = new ListIterator<>();
        Item returnedItem;

        if(k > size || k < 1)
            throw new IllegalArgumentException("The queue is not that big!");
        else if(k > size/2){
            //go backwards
            while (iterator.current.index != k){
                iterator.previous();
            }
        }
        else{
            //go forwards
            while (iterator.current.index != k){
                iterator.next();
            }
        }
        //modify references (same regardless of direction)
        returnedItem = iterator.current.value;
        iterator.current.next.index--;
        iterator.current.next.prev = iterator.current.prev;
        iterator.current.prev.next = iterator.current.next;

        printIterable();
        return returnedItem;
    }

    /**
     * Prints the queue contents using an iterator.
     * O(N)
     */
    public void printIterable(){
        ListIterator<Item> iterator = new ListIterator<>();
        while (iterator.current.next != first){
            System.out.print("[" + iterator.current.value + "], ");
            iterator.next();
        }
        if(iterator.current.next == first){
            System.out.println("[" + iterator.current.value + "]");
        }
    }

    /**
     * Returns a new instance of ListIterator with
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>();
    }
    private class ListIterator<I> implements Iterator<Item>{
        private Node<Item> current = first;
        public boolean hasNext(){ return current != null;}
        public void remove(){}
        public Item next(){
            Item value = current.value;
            current = current.next;
            return value;
        }
        public Item previous(){
            Item value = current.value;
            current = current.prev;
            return value;
        }
    }
}
