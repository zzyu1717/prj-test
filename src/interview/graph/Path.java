package interview.graph;

import java.util.*;

public class Path {
    private Graph g;

    private int s; // start pointer.

    private boolean[] visited;

    private int[] from; // from[i] represent i's previous node in path.

    public Path(Graph g, int s) {
        this.g = g;
        this.s = s;
        visited = new boolean[g.getV()];
        from = new int[g.getV()];
        for (int i = 0; i < from.length; i++) {
            from[i] = -1;
        }

        dfs(s);
    }

    public void dfs(int v) {
        visited[v] = true;
        for (int i : g.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
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
