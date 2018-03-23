package interview.graph.weight;

import java.util.Vector;

public class DenseWeightGraph<Weight extends Number & Comparable> implements WeightGraph{
    private int n; // 节点数
    private int m; // 边数
    private boolean directed;
    private Edge<Weight>[][] g;// 图的具体数据

    public DenseWeightGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    /**
     * 返回结点个数
     * @return
     */
    @Override
    public int V() {
        return n;
    }

    /**
     * 返回边的个数
     * @return
     */
    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        if (hasEdge(e.v(),e.w())) {
            return ;
        }
        g[e.v()][e.w()] = new Edge<Weight>(e);
        if (e.v() != e.w() && !directed) {
            g[e.w()][e.v()] = new Edge(e.w(),e.v(),e.wt());
        }

        m ++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        return g[v][w] != null;
    }

    @Override
    public void show() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (g[i][j] != null)
                    System.out.print(g[i][j].wt() + "\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjV = new Vector<>();
        for(int i = 0 ; i < n ; i ++ )
            if( g[v][i] != null )
                adjV.add( g[v][i] );
        return adjV;
    }
}
