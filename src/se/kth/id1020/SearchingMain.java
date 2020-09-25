package se.kth.id1020;

import se.kth.id1020.searching.FrequencyCounter;
import se.kth.id1020.searching.OrderedArrayST;
import se.kth.id1020.searching.TreeST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchingMain {
    public static void main(String[] args) {
        //instantiate the necessary classes
        File file = new File("./src/se/kth/id1020/searching/TheTextFiltered.txt");
        Scanner in = new Scanner(System.in);
        Timer timer = new Timer();
        OrderedArrayST<String, Integer> st = null;
        TreeST<String, Integer> tree = null;


        //user provides input
        System.out.println("How many words do you want to scan?");
        int numberOfWordsToScan = in.nextInt();
        System.out.println("What is the shortest word length you want to scan? I.E. skip words shorter than N letters.");
        int minLen = in.nextInt();

        //begin build tests.
        System.out.println("\nBuild tests:");
        FrequencyCounter freqCount = new FrequencyCounter(numberOfWordsToScan, minLen);
        String buildErrorMsg = "Test failed because filepath is incorrect.";
        System.out.println("Testing with minimum word length of " + minLen + " and scanning " + numberOfWordsToScan + " words from the file.");
        timer.reset();
        try{
            st = freqCount.buildArrayST(file);
            System.out.println("Array symbol table took " + timer.getRunTime() + "ms to build.");
        }
        catch (FileNotFoundException e){
            System.out.println(buildErrorMsg);
        }

        timer.reset();
        try{
            tree = freqCount.buildTree(file);
            System.out.println("Binary search tree took " + timer.getRunTime() + "ms to build.");
        }
        catch (FileNotFoundException e){
            System.out.println(buildErrorMsg);
        }

        //begin frequency tests.
        System.out.println("\nFrequency counter tests:");
        String freqCountErrMsg = "Test failed because the provided symbol table was null.";
        timer.reset();
        try{
            System.out.println("Array ST:");
            freqCount.findMostCommonWordArrayST(st);
            System.out.println("Array symbol table took " + timer.getRunTime() + "ms to find the most common word.");
        }
        catch (IllegalArgumentException e){
            System.out.println(freqCountErrMsg);
        }

        timer.reset();
        try{
            System.out.println("BST:");
            freqCount.findMostCommonWordTreeST(tree);
            System.out.println("Binary search tree took " + timer.getRunTime() + "ms to find the most common word.");
        }
        catch (IllegalArgumentException e){
            System.out.println(freqCountErrMsg);
        }

    }
}
