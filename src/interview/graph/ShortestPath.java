package interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ShortestPath {
    private Graph g;

    private int s; // start pointer.

    private boolean[] visited;

    private int[] from; // from[i] represent i's previous node in path.

    private int[] ord; // // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。

    public ShortestPath(Graph g, int s) {
        this.g = g;
        this.s = s;
        visited = new boolean[g.getV()];
        from = new int[g.getV()];
        ord = new int[g.getV()];
        for (int i = 0; i < from.length; i++) {
            from[i] = -1;
            ord[i] = -1;
        }

        bfs(s);
    }

    public void bfs(int v) {
        Deque<Integer> quque = new ArrayDeque<>();
        quque.add(v);
        visited[v] = true;
        ord[v] = 0;
        while (!quque.isEmpty()) {
            v = quque.remove();
            for (int i : g.adj(v)) {
                if (!visited[i]) {
                    from[i] = v;
                    ord[i] = ord[v]+1;
                    quque.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    // judging weather hsa path from s to w or not.
    public boolean hasPath(int w) {
        return visited[w];
    }

    public List<Integer> getPath(int w) {
        List<Integer> list = new ArrayList<>();
        if (!hasPath(w)) {
            return list;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int p = w;
        while(p != -1) {
            stack.push(p);
            p = from[p];
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    // print path form s to w.
    public void showPath(int w){

        assert hasPath(w) ;

        List<Integer> list = getPath(w);
        for( int i = 0 ; i < list.size() ; i ++ ){
            System.out.print(list.get(i));
            if( i == list.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }


}
