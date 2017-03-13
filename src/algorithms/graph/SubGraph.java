package algorithms.graph;

/**
 * Created by xuan on 17-3-13.
 */
public class SubGraph {
    private boolean[] marked;
    private int[] id;
    private int count;

    public SubGraph(Graph graph) {

    }

    private void dfs(Graph graph, int start) {
        marked[start] = true;
        id[start] = count;
        for (int w: graph.getAdj(start)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }
}
