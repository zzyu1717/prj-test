package interview.union;

public class UnionFind2 implements IUnionFind{
    private int[] rank; // base rank optimising.
    private int[] parent; // component parententifier.
    private int count; // numbers of components
    // test-use
    private String name;

    // initialize N sites with integer names(0 to N-1)
    public UnionFind2(int N,String name) {
        this.name = name;
        count = N;
        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // add connection between p and q
    // time complexity is O(h), h is height of tree(not equals lgN).
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return ;
        }
        // optimize.
        if (rank[p] < rank[q]) {
            parent[pRoot] = qRoot;
        } else if (rank[p] > rank[q]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }
        count--;
    }

    // find component parententifier for p (0 to N-1)
    //time complexity is O(h), h is height of tree(not equals lgN).
    public int find(int p) {
        while (parent[p] != p) {
            // path compression
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    // return true if p and q are in the same component.
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // numbers of components.
    public int count() {
        return count;
    }

    @Override
    public String getName() {
        return name;
    }
}
