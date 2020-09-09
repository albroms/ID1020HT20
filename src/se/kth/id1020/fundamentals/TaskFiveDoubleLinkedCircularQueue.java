package se.kth.id1020.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The queue data structure for task 5. I chose to implement a circular double linked list for this task so that
 * I can iterate in two directions. First will have the largest index number and last will have the smallest.
 * @param <Item>
 */
public class TaskFiveDoubleLinkedCircularQueue<Item> implements Iterable<Item>{
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
     * O(N) because even if the insertion is constant, the index update is linear.
     */
    public void enqueue(Item value) {
        if (isEmpty()) {
            first = new Node<>();
            first.value = value;
            last = first;
            first.next = last;
            first.prev = last;
            first.index = 1;
        } else {
            Node<Item> oldLast = last;
            ListIterator<Item> iterator = new ListIterator<>(); //for updating indexes
            last = new Node<>();
            last.value = value;
            last.index = 1;
            oldLast.next = last;
            first.prev = last;
            last.prev = oldLast;
            last.next = first;

            //update indexes
            iterator.current = last;
            for(int i=1; i<=size+1; i++){
                iterator.current.index = i;
                iterator.previous();
            }
        }
        size++;
        System.out.println("Added " + value + " to queue. Current size is " + size + ".");
        printIterable();
    }

    /**
     * Remove the first element in the queue.
     * @return the value of the node that was first before removal.
     * O(1)
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
        System.out.println("Removed " + value + " from queue. Current Queue:");
        printIterable();
        return value;
    }

    /**
     * Removes the element at the end of the queue.
     * last.prev becomes the new last and its next node will then refer to the first node.
     * O(1)
     * @return the value of the dequeued node.
     */
    public Item removeLast(){
        Item returnValue;
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow.");
        else if(size == 1){
            returnValue = last.value;
            first.prev = null;
            first.next = null;
            first = null;
            last = null;
            size--;
            System.out.println("Removed " + returnValue + " from back of queue. Queue is now empty.");
            return returnValue;
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
        printIterable();
        return returnValue;
    }

    /**
     * Remove the kth element from the queue.
     *
     * O(N)
     * @param k the index of the element we wish to remove.
     * @return the value of the removed node.
     */
    public Item remove(int k){
        ListIterator<Item> iterator = new ListIterator<>();
        Item returnedItem;

        if(k > size || k < 1)
            throw new IllegalArgumentException("The queue is not that big!");
        else if(k == 1){
            return removeLast();
        }
        else if(first.index == k){
            //we do not need to update indexes here since the highest index is removed.
            System.out.println("Least recently added item will be removed from index " + k + ".");
            return dequeue();
        }

        //go to lower index, we'll continue when we arrive at k.
        while (iterator.current.index != k){
            iterator.next();
        }

        returnedItem = iterator.current.value;

        //modify references
        iterator.current.next.prev = iterator.current.prev;
        iterator.current.prev.next = iterator.current.next;

        size--;

        iterator.current = last; //most recently added item
        for(int i = 1; i <= size; i++){
            iterator.current.index = i;
            iterator.previous();
        }

        System.out.println("Removed " + returnedItem + " from the list, which was at index " + k + ".");
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
     * Returns a new instance of ListIterator
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
