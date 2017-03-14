package algorithms.graph;

/**
 * directed graph dfs can be used in GC Roots to find
 * useless objects in java JVM, just assign it true to
 * avoid gc
 * Created by xuan on 17-3-13.
 */
public class DirectedDFS {
    private boolean[] marked;

    public boolean getMarked(int vertex) {
        return marked[vertex];
    }

    public DirectedDFS(Digraph digraph, int start) {
        marked = new boolean[digraph.getVertexNum()];
        dfs(digraph, start);
    }

    private void dfs(Digraph digraph, int start) {
        marked[start] = true;
        for (int w: digraph.getAdj(start)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }
}
