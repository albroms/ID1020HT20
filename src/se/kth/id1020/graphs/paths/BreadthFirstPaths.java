package se.kth.id1020.graphs.paths;

import se.kth.id1020.fundamentals.SimpleQueue;
import se.kth.id1020.fundamentals.Stack;
import se.kth.id1020.graphs.directedgraph.DGraph;
import se.kth.id1020.graphs.undirectedgraph.UGraph;

public class BreadthFirstPaths {
    private boolean[] visited; //each index represents a vertex and stores whether or not it has been visited.
    private int[] edgeTo; //
    private final int source;

    /**
     * Constructor for undirected graphs
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
     * Constructor for directed graphs
     * @param g the graph
     * @param source the source vertex
     */
    public BreadthFirstPaths(DGraph g, int source){
        visited = new boolean[g.getNumberOfVertices()];
        edgeTo = new int[g.getNumberOfVertices()];
        this.source = source;
        bfs(g, source);
    }

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
     * Returns an iterable stack containing a path between the source vertex and the provided path.
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
