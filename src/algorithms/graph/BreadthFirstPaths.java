package algorithms.graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by xuan on 2017/3/10 0010.
 */
public class BreadthFirstPaths {
    private boolean[] marked;   //记录着当前结点是否connected to start
    private int[] edgeTo;   //广度优先遍历，结果为生成树，edgeTo记录着当前结点的父节点是谁
    private final int start;    //以此节点为根节点，接着访问生成树的子树

    public BreadthFirstPaths(Graph graph, int start) {
        this.start = start;
        marked = new boolean[graph.getVertexNum()];
        edgeTo = new int[graph.getVertexNum()];
        bfs(graph, start);
    }

    private void bfs(Graph graph, int start) {
        Queue<Integer> queue = new Queue<>();
        marked[start] = true;
        queue.enqueue(start);
        while (!queue.isEmpty()) {
            int node = queue.dequeue();
            for (int w: graph.getAdj(node)) {
                if (!marked[w]) {
                    edgeTo[w] = node;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int currentPoint) {
        return marked[currentPoint];
    }

    public Stack<Integer> pathTo(int currentPoint) {
        if (!hasPathTo(currentPoint)) return null; //这句落下了，没路找个大头鬼啊
        Stack<Integer> stack = new Stack<>();
        for (int w = currentPoint; w != start; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(start);  //这句也落下了，完整的路径要有起点
        return stack;
    }
}
