package se.kth.id1020.searching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {
    private final int numberOfWordsToScan;
    private final int minLen;

    public FrequencyCounter(int numberOfWordsToScan, int minLen){
        this.numberOfWordsToScan = numberOfWordsToScan;
        this.minLen = minLen;
    }

    /**
     * Build an ordered array representation of a symbol table using the provided file and scanner.
     * @param textFile the text file to use
     * @return the built symbol table
     * @throws FileNotFoundException if the filepath is invalid
     */
    public OrderedArrayST<String, Integer> buildArrayST(File textFile) throws FileNotFoundException {
        Scanner textScanner = new Scanner(textFile);
        OrderedArrayST<String, Integer> st = new OrderedArrayST<>(minLen);

        int numberOfWordsScanned = 0; //increased until it matches numberOfWordsToScan
        while (textScanner.hasNext() && numberOfWordsScanned < numberOfWordsToScan){
            for(String word : textScanner.nextLine().split("\\s+")){
                //each line is split at whitespaces to create strings of words
                if(word.length() > 0)
                    //A word consisting of at least one letter.
                    numberOfWordsScanned++;
                if(word.length() >= minLen){
                    //A word of a length we actually think is significant.
                    if(!st.contains(word))
                        //new word
                        st.put(word, 1);
                    else{
                        //word previously encountered
                        int newVal = st.get(word) + 1;
                        st.put(word, newVal);
                    }
                }
            }
        }
        return st;
    }

    /**
     * Build a Binary Search Tree using a provided file.
     * @param textFile the file to use
     * @return the built tree
     * @throws FileNotFoundException if the filepath is invalid
     */
    public TreeST<String, Integer> buildTree(File textFile) throws FileNotFoundException{
        Scanner textScanner = new Scanner(textFile);
        TreeST<String, Integer> bt = new TreeST<>();

        int numberOfWordsScanned = 0; //increased until it matches numberOfWordsToScan

        while (textScanner.hasNextLine() && numberOfWordsScanned < numberOfWordsToScan){
            for(String word : textScanner.nextLine().split("\\s+")){
                if(word.length() > 0){
                    //A word consisting of at least one letter.
                    numberOfWordsScanned++;
                }
                if(word.length() >= minLen){
                    //A word of a length we actually think is significant.
                    if(!bt.contains(word)){
                        //new word
                        bt.put(word, 1);
                    }
                    else {
                        //word previously encountered
                        int newVal = bt.getValue(word) + 1;
                        bt.put(word, newVal);
                    }
                }
            }
        }
        return bt;
    }

    public void findMostCommonWordArrayST(OrderedArrayST<String, Integer> arrayST){
        if(arrayST == null){
            throw new IllegalArgumentException("Received a null object.");
        }
        String max = "-Place Holder-";
        arrayST.put(max, 0);
        
        for(String word : arrayST.keysToString()){
            if(arrayST.get(word) > arrayST.get(max))
                max = word;
        }
        System.out.println("\""+ max + "\"" + " was the most common word (occurred " + arrayST.get(max) + " times).");
    }

    public void findMostCommonWordTreeST(TreeST<String, Integer> tree){
        if(tree == null){
            throw new IllegalArgumentException("Received a null object.");
        }
        String max = "-Place Holder-";
        tree.put(max, 0);
        for(String word : tree.keysToString()){
            if(tree.getValue(word) > tree.getValue(max))
                max = word;
        }
        System.out.println("\""+ max + "\"" + " was the most common word (occurred " + tree.getValue(max) + " times).");
    }
}
