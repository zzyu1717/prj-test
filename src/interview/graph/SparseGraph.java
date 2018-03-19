package interview.graph;

import java.util.*;

/**
 * implementing of sparse graph by adjacency table.
 */
public class SparseGraph implements Graph {
    private int v;
    private int e;
    private boolean directed;
    private Map<Integer, Set<Integer>> g; // use map represent adjacency table.

    public SparseGraph(int vertex, boolean directed) {
        this.v = vertex;
        this.e = 0;
        this.directed = directed;
        this.g = new HashMap<>();
        for (int i = 0; i < v; i++) {
            g.put(i, new HashSet<>());
        }
    }

    public void addEdge(int v, int w) {
        // because of using Set collection, need not use hasEdge() method filtering.
        // Set only can store one of repeatable elements.
        g.get(v).add(w);
        if (v != w && !directed) {
            g.get(w).add(v);
        }
        e++;
    }

    public boolean hasEdge(int v, int w) {
        Set<Integer> vSet = g.get(v); // acquire all connected vertex with v.
        for (int i : vSet) {
            if (i == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < v; i++) {
            System.out.print("vertex " + i + ":\t");
            for (Iterator<Integer> iter = g.get(i).iterator(); iter.hasNext();)
                System.out.print(iter.next() + "\t");
            System.out.println();
        }
    }


    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public Iterable<Integer> adj(int s) {
        return g.get(s);
    }
}
