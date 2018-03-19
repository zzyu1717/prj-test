package interview.union;

public class UnionFind1 implements IUnionFind{

    private int id[]; // component identifier.
    private int count; // numbers of components
    // test-use
    private String name;

    // initialize N sites with integer names(0 to N-1)
    public UnionFind1(int N,String name) {
        this.name = name;
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // add connection between p and q
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return ;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    // find component identifier for p (0 to N-1)
    public int find(int p) {
        return id[p];
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
