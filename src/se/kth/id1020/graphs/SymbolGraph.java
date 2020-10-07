package se.kth.id1020.graphs;

import se.kth.id1020.graphs.directedgraph.DGraph;
import se.kth.id1020.graphs.undirectedgraph.UGraph;
import se.kth.id1020.searching.OrderedArrayST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraph {
    private OrderedArrayST<String, Integer> st; //String -> index
    private String[] keys; //index -> String
    private UGraph graph; //the undirected graph
    private DGraph digraph; //the directed graph

    /**
     * Generate a SymbolGraph with a given file.
     * @param file the file containing information to populate the symbol graph with.
     * @throws FileNotFoundException
     */
    public SymbolGraph(File file) throws FileNotFoundException {
        st = new OrderedArrayST<String, Integer>();
        Scanner in = new Scanner(file);
        while (in.hasNextLine()){
            String[] a = in.nextLine().split(" ");
            for(int i=0; i<a.length; i++){
                if(!st.contains(a[i])){
                    st.put(a[i], st.getSize());
                }
            }
        }
        keys = new String[st.getSize()];
        for(String state : st.keys()){
            keys[st.get(state)] = state;
        }
        graph = new UGraph(st.getSize());
        digraph = new DGraph(st.getSize());
        in = new Scanner(file);
        while (in.hasNextLine()){
            String[] a = in.nextLine().split(" ");
            int v = st.get(a[0]);
            for (int i = 1; i<a.length; i++){
                graph.addEdge(v, st.get(a[i]));
                digraph.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s){ return st.contains(s);}

    /**
     * Return the index associated with the given string
     * @param s the string
     * @return the index of the string
     */
    public int indexOf(String s){ return st.get(s);}

    /**
     * Returns the key (string) associated with the provided index (vertex)
     * @param v the provided index
     * @return the String associated with the given index.
     */
    public String name(int v){ return keys[v];}

    /**
     *
     * @return the undirected graph associated with the symbol graph.
     */
    public UGraph getUGraph(){ return graph;}

    /**
     *
     * @return the directed graph associated with the symbol graph.
     */
    public DGraph getDGraph(){ return digraph;}
}
