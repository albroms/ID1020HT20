package se.kth.id1020.graphs.paths;

import se.kth.id1020.fundamentals.Stack;
import se.kth.id1020.graphs.directedgraph.DGraph;
import se.kth.id1020.graphs.undirectedgraph.UGraph;

/**
 * Class for finding paths using the depth first search algorithm.
 * Provides the main logic for task 1 and 3.
 */
public class DepthFirstPaths {
    private boolean[] visited;
    private int[] edgeTo;
    private final int source;

    /**
     * Constructor for undirected graphs for task 1
     * @param g the graph
     * @param source the source vertex
     */
    public DepthFirstPaths(UGraph g, int source){
        visited = new boolean[g.getNumberOfVertices()];
        edgeTo = new int[g.getNumberOfVertices()];
        this.source = source;
        dfs(g, source);
    }

    /**
     * Constructor for directed graphs for task 3.
     * @param g the graph
     * @param source the source vertex
     */
    public DepthFirstPaths(DGraph g, int source){
        visited = new boolean[g.getNumberOfVertices()];
        edgeTo = new int[g.getNumberOfVertices()];
        this.source = source;
        dfs(g, source);
    }

    //task 1
    private void dfs(UGraph g, int v){
        visited[v] = true;
        for(int w : g.adj(v)){
            if(!visited[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    //for task 3
    private void dfs(DGraph g, int v){
        visited[v] = true;
        for(int w : g.adj(v)){
            if(!visited[w]){
                edgeTo[w] = v;
                dfs(g, w);
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
