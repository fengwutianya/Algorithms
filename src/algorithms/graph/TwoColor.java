package algorithms.graph;

/**
 * Created by xuan on 17-3-13.
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;

    public boolean isTwoColor() {
        return isTwoColor;
    }

    private boolean isTwoColor = true;

    public TwoColor(Graph graph) {
        int vertexNum = graph.getVertexNum();
        marked = new boolean[vertexNum];
        color = new boolean[vertexNum];

        for (int i = 0; i < vertexNum; i++) {
            if (!marked[i]) {
                dfs(graph, i);
            }
        }
    }

    private void dfs(Graph graph, int start) {
        marked[start] = true;
        for (int w: graph.getAdj(start)) {
            if (!marked[w]) {
                color[w] = !color[start];
                dfs(graph, w);
            } else if (color[w] == color[start])
                isTwoColor = false;
        }
    }
}
