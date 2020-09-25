package se.kth.id1020.searching;

import se.kth.id1020.fundamentals.DoubleLinkedCircularQueue;

import java.util.NoSuchElementException;

public class TreeST<Key extends Comparable<Key>, Value> {
    Node root;

    private class Node{
        //a node represents a subtree.
        Key key;
        Value val;
        Node left;
        Node right;
        int size;

        Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private Node put(Node tree, Key key, Value val){
        if(tree == null){
            tree = new Node(key, val, 1);
        }
        else{
            int cmp = key.compareTo(tree.key);
            //if key to put is less, put in left tree
            if(cmp < 0){
                //go left
                tree.left = put(tree.left, key, val);
            }
            //if key to put is more, put in right tree
            else if(cmp > 0){
                //go right
                tree.right = put(tree.right, key, val);
            }
            else {
                //we have the same key
                tree.val = val;
            }
            tree.size = sizeOf(tree.left) + sizeOf(tree.right) + 1;
        }
        return tree;
    }

    public Value getValue(Key key){
        if(key == null){
            return null;
        }
        return getValue(key, root);
    }
    private Value getValue(Key key, Node tree){
        if(tree == null){
            return null;
        }
        else{
            int cmp = key.compareTo(tree.key);
            if(cmp < 0){
                //go left
                return getValue(key, tree.left);
            }
            else if(cmp > 0){
                //go right
                return getValue(key, tree.right);
            }
            else {
                //found
                return tree.val;
            }
        }
    }

    public boolean contains(Key key){
        return getValue(key) != null;
    }

    /**
     * Returns the size of the whole tree.
     * @return the total number of elements in the tree.
     */
    public int getSize(){ return sizeOf(root);}

    /**
     * Returns the size of a subtree.
     * @param tree the subtree which size we are looking for
     * @return the number of nodes in the given subtree
     */
    private int sizeOf(Node tree){
        if(tree == null)
            return 0;
        else
            return tree.size;
    }

    /**
     * Check if the tree is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty(){
        return root == null;
    }

    public String[] keysToString(){
        try{
            DoubleLinkedCircularQueue<String> q = new DoubleLinkedCircularQueue<>();

            int arraySize = root.size;
            addKeysFromTree(root, q);

            String[] arrayOfStringKeys = new String[arraySize];

            for(int i=0; i<arraySize; i++){
                arrayOfStringKeys[i] = q.dequeue();
            }
            return arrayOfStringKeys;
        }
        catch (NoSuchElementException e){
            System.out.println("Queue underflow!");
            return null;
        }
    }

    private void addKeysFromTree(Node tree, DoubleLinkedCircularQueue<String> queue){
        if(tree == null){
            return;
        }
        if(tree.key.compareTo((Key) "") == 0){
            return;
        }
        queue.enqueue(tree.key.toString());
        addKeysFromTree(tree.left, queue);
        addKeysFromTree(tree.right, queue);
    }
}
