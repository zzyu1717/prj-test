package interview.graph;

/**
 * 无权图的联通分量
 */
public class UnicomComponent {
    private Graph g;

    private boolean[] visited;

    private int ccount ; // count connected component

    private int[] id; // individual connected component identical.

    public UnicomComponent(Graph graph) {
        g = graph;
        ccount = 0;
        visited = new boolean[g.getV()];
        id = new int[g.getV()];

        // acquire the ccount.
        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    /**
     * depth traverse.
     * @param v start vertex
     */
    public void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for (int i : g.adj(v)) {
            if (!visited[i])  {
                dfs(i);
            }
        }
    }

    public int getConnectionComponent() {
        return ccount;
    }

    public boolean isConnected(int v, int w) {
        return id[v] == id[w]; // true, represent v and w in the same connected component.
    }

}
