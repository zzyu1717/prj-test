package interview.graph;

public interface Graph {
    public int getV();
    public int getE();
    public void addEdge( int s , int w );
    boolean hasEdge( int s , int w );
    void show();
    public Iterable<Integer> adj(int s);
}
