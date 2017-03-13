package algorithms.graph;

/**
 * Created by xuan on 17-3-13.
 */
public class SubGraph {
    private boolean[] marked;
    private int[] id;
    private int count;

    public SubGraph(Graph graph) {
        marked = new boolean[graph.getVertexNum()];
        id = new int[graph.getVertexNum()];
        count = 0;
        for (int i = 0; i < graph.getVertexNum(); i++) {
            if (!marked[i]) {
                dfs(graph, i);
                count++;
            }
        }
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

    public int getId(int vertex) {
        return id[vertex];
    }

    public boolean connected(int from, int to) {
        return id[from] == id[to];
    }

    public int getCount() {
        return count;
    }
}
