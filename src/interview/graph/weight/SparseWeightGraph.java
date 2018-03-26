package interview.graph.weight;

import java.util.List;

public class SparseWeightGraph<Weight extends Number & Comparable> implements WeightGraph{
    private int n;
    private int m;
    private boolean directed;
    private List<Edge<Weight>>[] g; // 图的具体数据

    @Override
    public int V() {
        return 0;
    }

    @Override
    public int E() {
        return 0;
    }

    @Override
    public void addEdge(Edge e) {

    }

    @Override
    public boolean hasEdge(int v, int w) {
        return false;
    }

    @Override
    public void show() {

    }

    @Override
    public Iterable<Edge> adj(int v) {
        return null;
    }


}
