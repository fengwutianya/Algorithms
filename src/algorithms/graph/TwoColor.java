package algorithms.graph;

/**
 * Created by xuan on 2017/3/13 0013.
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColor;

    public TwoColor(Graph graph) {
        isTwoColor = true;
        int vertexNumber = graph.getVertexNum();
        marked = new boolean[vertexNumber];
        color = new boolean[vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            if (!marked[i]) {
                dfs(graph, i);
            }
        }
    }

    private void dfs(Graph graph, int whoVisistedMe) {
        marked[whoVisistedMe] = true;
        for (int w: graph.getAdj(whoVisistedMe)) {
            if (!marked[w]) {
                dfs(graph, w);
                color[w] = !color[whoVisistedMe];
            }
            else if (color[w] == color[whoVisistedMe]) isTwoColor = false;
        }
    }

    public boolean isTwoColor() {
        return isTwoColor;
    }
}
