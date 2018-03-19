package interview.union;

public interface IUnionFind {

    // add connection between p and q
    void union(int p, int q);

    // find component identifier for p (0 to N-1)
    int find(int p);

    // return true if p and q are in the same component.
    boolean isConnected(int p, int q);

    // numbers of components.
    int count();

    // test
    String getName();
}
