package algorithms.graph;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by xuan on 17-3-17.
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph digraph) {
        int verNum = digraph.getVertexNum();
        marked = new boolean[verNum];
        edgeTo = new int[verNum];
        onStack = new boolean[verNum];
        for (int i = 0; i < verNum; i++) {
            if (!marked[i]) dfs(digraph, i);
        }
    }

    private void dfs(Digraph digraph, int start) {
        marked[start] = true;
        onStack[start] = true;
        for (int w: digraph.getAdj(start)) {
            if (this.hasCycle()) return; //因为构造函数里面要遍历整个图，可能有多个cycle，找到一个cycle之后，循环之中再次找另外一个cycle时直接退出
            else if (!marked[w]) {
                edgeTo[w] = start;
                dfs(digraph, w);
            }
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = start; x != w; x = edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(start);
            }
        }
        onStack[start] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> getCycle() {
        return cycle;
    }
}
