/**
 * Task 3 and 4 of Lab 1.
 */
package se.kth.id1020.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-linked, generic, iterable FIFO Queue.
 * @param <Item> the generic data type that provides support for any data types to use the queue.
 */
public class DoubleLinkedCircularQueue<Item> implements Iterable<Item>{
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item>{
        Item value;
        Node<Item> next;
        Node<Item> prev;
    }

    /**
     * The Queue constructor, creates an empty queue.
     */
    public DoubleLinkedCircularQueue(){
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns true if the queue is empty.
     * @return true if empty, false if not.
     */
    public boolean isEmpty(){
        return first == null;
    }

    public int getSize(){
        return size;
    }

    /**
     * Add an element to the end of the queue.
     * O(1) time complexity without printQueue/printIterable, O(N) with them.
     * @param value the value of the Node to be added to the end of the queue.
     */
    public void enqueue(Item value) {
        if (isEmpty()) {
            first = new Node<>();
            first.value = value;
            last = first;
            first.next = last;
            first.prev = last;
        } else {
            Node<Item> oldLast = last;
            last = new Node<>(); //new last
            last.value = value;
            oldLast.next = last;
            first.prev = last;
            last.prev = oldLast;
            last.next = first;
        }
        size++;
        /*
        System.out.println("Added " + value + " to queue. Current Queue:");
        printQueue();
        System.out.println("Iterative print:");
        printIterable();
        */
    }

    /**
     * Remove the first element in the queue.
     * O(1) time complexity without printQueue/printIterable, O(N) with them.
     * @return the value of the node that was first before removal.
     */
    public Item dequeue(){
        Item value;
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow.");
        else if(size == 1){
            value = first.value;
            first = null;
            last = null;
        }
        else {
            value = first.value;
            Node<Item> oldFirst = first;
            first = oldFirst.next;
            first.prev = last;
            last.next = first;
        }
        size--;
        /*
        System.out.println("Removed " + value + " from queue. Current Queue:");
        printQueue();
        System.out.println("Iterative print:");
        printIterable();
        */
        return value;
    }

    /**
     * Prints the queue contents by using the private printQueue method to recursively run through the queue to print its contents
     * O(N) time complexity
     * O(1) memory complexity
     */
    public void printQueue(){
        String queue = printQueue(first);
        System.out.println(queue);
    }

    private String printQueue(Node node){
        if(node.next == first){
            return "[" + node.value.toString() + "]";
        }
        return "[" + node.value.toString() + "], " + printQueue(node.next);
    }

    /**
     * Prints the queue contents using an iterator.
     * O(N) time complexity
     * O(1) memory complexity
     */
    public void printIterable(){
        ListIterator iterator = new ListIterator();
        while (iterator.current.next != first){
            System.out.print("[" + iterator.current.value + "], ");
            iterator.next();
        }
        if(iterator.current.next == first){
            System.out.println("[" + iterator.current.value + "]");
        }
    }

    /**
     * Returns a new instance of ListIterator
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node<Item> current = first;
        public boolean hasNext(){ return current != null;}
        public void remove(){}
        public Item next(){
            Item value = current.value;
            current = current.next;
            return value;
        }
    }

    //Code for task 4 below:

    /**
     * Adds an element to the start of the queue.
     * The newly added Node becomes first and last.next will refer to the newly added node.
     * If we add to an empty queue, we can simply reuse the enqueue method.
     * O(N) time complexity due to the printQueue(), would've been O(1) without it.
     * O(1) space complexity.
     * @param value the value to be given to the new node.
     */
    public void addToFront(Item value){
        if(isEmpty())
            enqueue(value);
        else{
            Node<Item> oldFirst = first;
            first = new Node<>();
            first.value = value;
            first.prev = last;
            first.next = oldFirst;
            last.next = first;
            oldFirst.prev = first;
        }
        size++;
        System.out.println("Added " + value + " to front of queue. Current queue:");
        printQueue();
    }

    /**
     * Removes the element at the end of the queue.
     * last.prev becomes the new last and its next node will then refer to the first node.
     * O(1) time complexity without printQueue method, O(N) with.
     * @return the value of the dequeued node.
     */
    public Item removeLast(){
        Item returnValue;
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow.");
        else if(size == 1){
            returnValue = last.value;
            first = null;
            last = null;
        }
        else {
            Node<Item> oldLast = last;
            returnValue = oldLast.value;
            last = oldLast.prev;
            last.next = first;
            first.prev = last;
        }
        size--;
        System.out.println("Removed " + returnValue + " from back of queue. Current queue:");
        printQueue();
        return returnValue;
    }
}
