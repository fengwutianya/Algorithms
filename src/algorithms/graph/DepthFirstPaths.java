package algorithms.graph;


import edu.princeton.cs.algs4.Stack;

/**
 * Created by xuan on 2017/3/10 0010.
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int start;

    public DepthFirstPaths(Graph graph, int start) {
        marked = new boolean[graph.getVertexNum()];
        edgeTo = new int[graph.getVertexNum()];
        this.start = start;
        dfs(graph, start);
    }

    private void dfs(Graph graph, int start) {
        marked[start] = true;
        for (int w: graph.getAdj(start)) {
            if (!marked[w]) {
                edgeTo[w] = start;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int currentPoint) {
        return marked[currentPoint];
    }

    public Stack<Integer> pathTo(int currentPoint) {
        if (!hasPathTo(currentPoint)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = currentPoint; x != start; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(start);
        return path;
    }
}
