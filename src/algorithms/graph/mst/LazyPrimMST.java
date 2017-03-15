package algorithms.graph.mst;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by xuan on 2017/3/15 0015.
 */
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph graph) {
        marked = new boolean[graph.getVertexNum()];
        mst = new Queue<>();
        pq = new MinPQ<>();

        visit(graph, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.delMin();
            int from = edge.either();
            int to = edge.other(from);
            if (!(marked[from]&&marked[to])) {
                mst.enqueue(edge);
                if (!marked[from]) visit(graph, from);
                if (!marked[to]) visit(graph, to);
            }
        }
    }

    private void visit(EdgeWeightedGraph graph, int vertex) {
        marked[vertex] = true;
        for (Edge edge: graph.getAdj(vertex)) {
            pq.insert(edge);
        }
    }

    public Iterable<Edge>  getEdges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for (Edge edge: mst) {
            weight += edge.getWeight();
        }
        return weight;
    }
}
