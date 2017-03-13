package algorithms.graph;


/**
 * 如果我访问了一个marked=true的节点，他不
 * 是刚刚访问我的那个节点，之前已经被访问过，
 * 我又访问它，那么他在一个环里面，当然前提
 * 是这是一个连通分量，dfs能保证是一个联通分量
 * 也可以利用边和树的关系，每个连通分量都
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
