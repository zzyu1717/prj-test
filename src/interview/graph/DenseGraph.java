package interview.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * implements dense graph representing by adjacency matrix.
 */
public class DenseGraph implements Graph {
    private int v; // number of vertex
    private int e; // number of edge.

    private boolean directed; // false represent undirected graph.
    private boolean[][] g; // store data of graph. false represent two vertex has no edge.

    public DenseGraph(int vertex, boolean directed) {
        this.v = vertex;
        this.e = 0;
        this.directed = directed;
        g = new boolean[v][v];
    }


    /**
     * add edge in graph.
     *
     * @param s vertex
     * @param w vertex
     */
    public void addEdge(int s, int w) {
        if (hasEdge(s, w)) {
            return;
        }
        g[s][w] = true;
        if (!directed) { // undirected.
            g[w][s] = true;
        }
        e++;
    }

    public boolean hasEdge(int s, int w) {
        return g[s][w];
    }

    @Override
    public void show() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++)
                System.out.print(g[i][j] + "\t");
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
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < v; i++) {
            if (g[s][i]) {
                set.add(i);
            }
        }
        return set;
    }
}
