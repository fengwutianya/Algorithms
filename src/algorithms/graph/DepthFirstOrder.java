package algorithms.graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by xuan on 2017/3/17 0017.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; //前序访问
    private Queue<Integer> post;    //后续访问
    private Stack<Integer> reversePost; //逆后续访问

    public DepthFirstOrder(Digraph digraph) {
        marked = new boolean[digraph.getVertexNum()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        for (int i = 0; i < digraph.getVertexNum(); i++) {
            dfs(digraph, i);
        }
    }

    private void dfs(Digraph digraph, int start) {
        marked[start] = true;
        pre.enqueue(start);

        for (int w: digraph.getAdj(start)) {
            if (!marked[w]) dfs(digraph, w);
        }

        post.enqueue(start);
        reversePost.push(start);
    }

    public Iterable<Integer> getPre() {
        return pre;
    }

    public Iterable<Integer> getPost() {
        return post;
    }

    public Iterable<Integer> getReversePost() {
        return reversePost;
    }
}
