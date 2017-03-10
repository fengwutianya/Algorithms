package algorithms.graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by xuan on 2017/3/10 0010.
 */
public class BreadthFirstPaths {
    private boolean[] marked;   //记录着当前结点是否已经被访问了
    private int[] edgeTo;   //广度优先遍历，结果为生成树，edgeTo记录着当前结点的父节点是谁
    private final int s;    //以此节点为根节点，接着访问生成树的子树

    public BreadthFirstPaths(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int v) {
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int node = queue.dequeue();
            for (int w: g.adj(node)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null; //这句落下了，没路找个大头鬼啊
        Stack<Integer> stack = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);  //这句也落下了，完整的路径要有起点
        return stack;
    }
}
