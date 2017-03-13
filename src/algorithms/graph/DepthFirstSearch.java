package algorithms.graph;

/**
 * Created by xuan on 2017/3/10 0010.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int start) {
        marked = new boolean[graph.getVertexNum()];
        dfs(graph, start);
    }

    private void dfs(Graph graph, int start) {
        marked[start] = true;
        count++;
        for (int w: graph.getAdj(start)) {
            if (!marked[w]) dfs(graph, w);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
