package interview.union;

public class Main {
    public static void main(String[] args) {
        int n = 100000;

        IUnionFind uf1 = new UnionFind1(n,"uf1");
        UnionTestHelper.testUF(uf1);
        System.out.println(uf1.count());
        // optimize.
        IUnionFind uf2 = new UnionFind2(n,"uf2");
        UnionTestHelper.testUF(uf2);
        System.out.println(uf2.count());
    }
}
