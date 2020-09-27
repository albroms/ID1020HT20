package se.kth.id1020.fundamentals;

import java.util.Iterator;

public class SimpleQueue<Item> implements Iterable<Item>{
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item>{
        Item value;
        Node<Item> next;
    }

    public SimpleQueue(){
        first = null;
        size = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int getSize(){return size;}

    public void enqueue(Item value){
        Node oldLast = last;
        last = new Node<>();
        last.value = value;
        last.next = null;
        if(isEmpty()){
            first = last;
        }
        else{
            oldLast.next = last;
        }
        size++;
    }

    public Item dequeue(){
        Item value = first.value;
        first = first.next;
        size--;
        if(isEmpty()){
            last = null;
        }
        return value;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node<Item> current = first;
        public boolean hasNext(){ return current != null;}
        public Item next(){
            Item value = current.value;
            current = current.next;
            return value;
        }
    }

}
