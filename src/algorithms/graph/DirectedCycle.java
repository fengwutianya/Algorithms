package algorithms.graph;

/**
 * Created by xuan on 17-3-17.
 */
public class DirectedCycle {
    private boolean[] marked;

    public DirectedCycle(Digraph digraph) {
        marked = new boolean[digraph.getVertexNum()];
        for (int i = 0; i < digraph.getVertexNum(); i++) {
            if (!marked[i]) dfs(digraph, i);
        }
    }

    private void dfs(Digraph digraph, int start) {

    }
}
