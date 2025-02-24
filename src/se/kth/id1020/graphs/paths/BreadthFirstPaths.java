package se.kth.id1020.graphs.paths;

import se.kth.id1020.fundamentals.SimpleQueue;
import se.kth.id1020.fundamentals.Stack;
import se.kth.id1020.graphs.directedgraph.DGraph;
import se.kth.id1020.graphs.undirectedgraph.UGraph;

/**
 * Class for finding paths using the breadth first search algorithm.
 * Provides the main logic for task 2 and 3.
 */
public class BreadthFirstPaths {
    private boolean[] visited;
    private int[] edgeTo;
    private final int source;

    /**
     * Constructor for undirected graphs for task 2
     * @param g the graph
     * @param source the source vertex
     */
    public BreadthFirstPaths(UGraph g, int source){
        visited = new boolean[g.getNumberOfVertices()];
        edgeTo = new int[g.getNumberOfVertices()];
        this.source = source;
        bfs(g, source);
    }

    /**
     * Constructor for directed graphs for task 3
     * @param g the graph
     * @param source the source vertex
     */
    public BreadthFirstPaths(DGraph g, int source){
        visited = new boolean[g.getNumberOfVertices()];
        edgeTo = new int[g.getNumberOfVertices()];
        this.source = source;
        bfs(g, source);
    }

    //task 2
    private void bfs(UGraph g, int s){
        SimpleQueue<Integer> q = new SimpleQueue<>();
        visited[s] = true;
        q.enqueue(s);
        while (!q.isEmpty()){
            int v = q.dequeue();
            for(int w : g.adj(v)){
                if(!visited[w]){
                    edgeTo[w] = v;
                    visited[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    //task 3
    private void bfs(DGraph g, int s){
        SimpleQueue<Integer> q = new SimpleQueue<>();
        visited[s] = true;
        q.enqueue(s);
        while (!q.isEmpty()){
            int v = q.dequeue();
            for(int w : g.adj(v)){
                if(!visited[w]){
                    edgeTo[w] = v;
                    visited[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    /**
     * Check if there is a path to the given vertex.
     * @param v the vertex
     * @return true if there is a path to it, false if not.
     */
    public boolean hasPathTo(int v){
        return visited[v];
    }

    /**
     * Returns an iterable stack containing a path between the source vertex and the provided destination.
     * @param v the destination vertex
     * @return null if no path is found, otherwise the stack containing the path is returned
     */
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != source; x = edgeTo[x]){
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
