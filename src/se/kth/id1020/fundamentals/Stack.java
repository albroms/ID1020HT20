package se.kth.id1020.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int size;


    private class Node<Item>{
        private Item value;
        private Node<Item> next;
    }

    /**
     * A simple constructor to instantiate an empty stack.
     */
    public Stack(){
        first = null;
        size = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int getSize(){
        return size;
    }

    /**
     *
     * @param value the value we want our node to have that we are pushing on the stack
     */
    public void push(Item value){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.value = value;
        first.next = oldFirst;
        size++;
        System.out.println(this.toString());
    }

    /**
     * Pop a value off the stack.
     * @return the value that was popped off the top of the stack
     */
    public Item pop(){
        if(isEmpty())
            throw new NoSuchElementException("Stack underflow.");
        Item value = first.value;
        first = first.next;
        size--;
        System.out.println(this.toString());
        return value;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Item item : this){
            sb.append("[" + item + "],");
        }
        return sb.toString();
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item value = current.value;
            current = current.next;
            return value;
        }
    }

    public String stringifyStack(){
        return "";
    }

}
