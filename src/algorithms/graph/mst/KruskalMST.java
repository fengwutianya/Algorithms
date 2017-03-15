package algorithms.graph.mst;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Created by xuan on 17-3-15.
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph graph) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge edge: graph.edges()) pq.insert(edge);
        UF uf = new UF(graph.getVertexNum());

        while (!pq.isEmpty() && mst.size()<graph.getVertexNum()-1) {
            Edge edge = pq.delMin();
            int from = edge.either();
            int to = edge.other(from);
            if (uf.connected(from, to)) continue;
            uf.union(from, to);
            mst.enqueue(edge);
        }
    }

    public Iterable<Edge> getEdges() {
        return mst;
    }

    public double getWeight() {
        double weight = 0;
        for (Edge edge: mst)
            weight += edge.getWeight();
        return weight;
    }
}
