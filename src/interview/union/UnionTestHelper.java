package interview.union;

public class UnionTestHelper {
    // 测试第一版本的并查集, 测试元素个数为n
    public static void testUF( IUnionFind uf) {
        int n = uf.count();
        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.union(a, b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println(uf.getName()+", " + 2 * n + " ops, " + (endTime - startTime)*1.0/1000 + "s");
    }
}
