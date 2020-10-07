package se.kth.id1020.graphs.directedgraph;

import se.kth.id1020.fundamentals.SimpleQueue;

public class DGraph {
    private int numberOfVertices;
    private int numberOfEdges;
    private SimpleQueue<Integer>[] adj;

    public DGraph(int v){
        this.numberOfVertices = v;
        this.numberOfEdges = 0;
        adj = (SimpleQueue<Integer>[]) new SimpleQueue[v];
        for(int i = 0; i<numberOfVertices; i++){
            adj[i] = new SimpleQueue<Integer>();
        }
    }

    public int getNumberOfVertices(){ return numberOfVertices;}
    public int getNumberOfEdges(){ return numberOfEdges;}

    public void addEdge(int v, int w){
        adj[v].enqueue(w);
        numberOfEdges++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public DGraph reverse(){
        DGraph r = new DGraph(numberOfVertices);
        for(int v=0; v<numberOfVertices; v++){
            for(int w : adj(v)){
                r.addEdge(w, v);
            }
        }
        return r;
    }
}
