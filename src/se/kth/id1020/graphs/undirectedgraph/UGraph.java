package se.kth.id1020.graphs.undirectedgraph;

import se.kth.id1020.fundamentals.SimpleQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UGraph {
    private int numberOfVertices; //number of vertices
    private int numberOfEdges; //number of edges
    private SimpleQueue<Integer>[] adj; //adjacency list

    /**
     * Create a graph with no edges.
     * @param vertices number of vertices in the graph
     */
    public UGraph(int vertices){
        this.numberOfVertices = vertices;
        this.numberOfEdges = 0;
        adj = (SimpleQueue<Integer>[]) new SimpleQueue[numberOfVertices];
        for(int v = 0; v < numberOfVertices; v++){
            adj[v] = new SimpleQueue<Integer>();
        }
    }

    public UGraph(Scanner sc){
        this(sc.nextInt());
        int numberOfEdges = sc.nextInt();
        for (int i=0; i<numberOfEdges; i++){
            int v = sc.nextInt();
            int w = sc.nextInt();
            addEdge(v, w);
        }
    }

    public int getNumberOfVertices(){
        return numberOfVertices;
    }
    public int getNumberOfEdges(){ return numberOfEdges; }

    public void addEdge(int v, int w){
        adj[v].enqueue(w); //add w to v's list
        adj[w].enqueue(v);//add v to w's list
        numberOfEdges++;
    }

    public Iterable<Integer> adj(int v){ return adj[v]; }
}
