package algorithms.graph;


/**
 * 利用深度优先搜索来判断图中是否有环
 * 有环的话深度优先搜索会深入到起点
 * 但是是对于每个子图来说的，dfs要加
 * 参数start
 * 也可以利用边和树的关系，每个分支都
 * 是无环图就是森林
 * Created by xuan on 2017/3/13 0013.
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public boolean getHasCycle() {
        return hasCycle;
    }

    public Cycle(Graph graph) {
        hasCycle = false;
        marked = new boolean[graph.getVertexNum()];
        for (int i = 0; i < graph.getVertexNum(); i++) {
            if (!marked[i]) {
                dfs(graph, i, i);
            }
        }
    }

    private void dfs(Graph graph, int curr, int whoVisistedMe) {
        marked[curr] = true;
        for (int w: graph.getAdj(curr)) {
            if (!marked[w]) dfs(graph, w, curr);
            else if (w != whoVisistedMe) hasCycle = true;
        }
    }
}
