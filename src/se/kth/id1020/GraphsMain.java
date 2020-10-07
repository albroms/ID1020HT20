package se.kth.id1020;

import se.kth.id1020.graphs.SymbolGraph;
import se.kth.id1020.graphs.paths.BreadthFirstPaths;
import se.kth.id1020.graphs.paths.DepthFirstPaths;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphsMain {
    private static void testDFS(int source, int end, SymbolGraph symbolGraph){
        System.out.println("\nDepth First Path result:");
        DepthFirstPaths undirectedDFPath = new DepthFirstPaths(symbolGraph.getUGraph(), source);
        Iterable<Integer> depthPath = undirectedDFPath.pathTo(end);
        for(int v : depthPath){
            if(v == end){
                System.out.println(symbolGraph.name(v));
            }
            else {
                System.out.print(symbolGraph.name(v) + "<->");
            }
        }
    }
    private static void testBFS(int source, int end, SymbolGraph symbolGraph){
        System.out.println("\nBreadth First Path result:");
        BreadthFirstPaths undirectedBFPath = new BreadthFirstPaths(symbolGraph.getUGraph(), source);
        Iterable<Integer> breadthPath = undirectedBFPath.pathTo(end);
        for(int v : breadthPath){
            if(v == end){
                System.out.println(symbolGraph.name(v));
            }
            else {
                System.out.print(symbolGraph.name(v) + "<->");
            }
        }
    }
    private static void testDirected(int source, int end, SymbolGraph symbolGraph){

        System.out.println("\nDirected Paths test:");
        DepthFirstPaths directedDepthPath = new DepthFirstPaths(symbolGraph.getDGraph(), source);
        BreadthFirstPaths directedBreadthPath = new BreadthFirstPaths(symbolGraph.getDGraph(), source);
        System.out.println("Directed DFS:");
        Iterable<Integer> dirDepthPath = directedDepthPath.pathTo(end);
        if(dirDepthPath == null){
            System.out.println("No path was found between " + symbolGraph.name(source) + " and " + symbolGraph.name(end) + ".");
        }
        else {
            for(int v : dirDepthPath){
                if(v == end){
                    System.out.println(symbolGraph.name(v) + " was the path found.");
                }
                else {
                    System.out.print(symbolGraph.name(v) + "->");
                }
            }
        }

        System.out.println("Directed BFS:");
        Iterable<Integer> dirBreadthPath = directedBreadthPath.pathTo(end);
        if(dirBreadthPath == null){
            System.out.println("No path was found between " + symbolGraph.name(source) + " and " + symbolGraph.name(end) + ".");
        }
        else {
            for(int v : dirBreadthPath){
                if(v == end){
                    System.out.println(symbolGraph.name(v) + " was the path found.");
                }
                else {
                    System.out.print(symbolGraph.name(v) + "->");
                }
            }
        }
    }

    public static void main(String[] args){
        //Read file and open scanner to System.in.
        SymbolGraph symbolGraph;
        Scanner in = new Scanner(System.in);
        try {
            File states = new File("./src/se/kth/id1020/graphs/contiguous-usa.dat");
            symbolGraph = new SymbolGraph(states);
            System.out.println("Please specify the starting state.");
            String userStart = in.next();
            int source = symbolGraph.indexOf(userStart);

            System.out.println("Please specify the destination state.");
            String userEnd = in.next();
            int end = symbolGraph.indexOf(userEnd);

            testDFS(source, end, symbolGraph);
            testBFS(source, end, symbolGraph);
            testDirected(source, end, symbolGraph);
        }
        catch (FileNotFoundException e){
            System.out.println("Failed to build SymbolGraph. Pathname error.");
        }
        catch (NullPointerException e){
            System.out.println("Something went wrong with finding the path!");
        }

    }
}
