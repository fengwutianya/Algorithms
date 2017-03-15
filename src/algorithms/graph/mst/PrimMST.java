package algorithms.graph.mst;

import algorithms.collections.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Created by xuan on 17-3-15.
 */
public class PrimMST {
    private Edge[] edgeMinToTree;
    private double[] distMinToTree;
    private boolean[] inTree;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph graph) {
        int vertexNum = graph.getVertexNum();
        edgeMinToTree = new Edge[vertexNum];
        distMinToTree = new double[vertexNum];
        inTree = new boolean[vertexNum];
        pq = new IndexMinPQ<>(vertexNum);
        for (int i = 0; i < vertexNum; i++) {
            distMinToTree[i] = Double.POSITIVE_INFINITY;
        }

        distMinToTree[0] = 0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(graph, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph graph, int from) {
        inTree[from] = true;
        for (Edge edge: graph.getAdj(from)) {
            int to = edge.other(from);
            if (inTree[to]) continue;
            if (edge.getWeight() < distMinToTree[to]) {
                edgeMinToTree[to] = edge;
                distMinToTree[to] = edge.getWeight();

                if (pq.contains(to)) pq.change(to, distMinToTree[to]);  //after swimming or sinking, it's hard to find where the edge is
                                                                        //but there is no problem because it's a indexed pq
                else pq.insert(to, distMinToTree[to]);
            }
        }
    }

    public Iterable<Edge> getEdges() {
        Bag<Edge> list = new Bag<>();
        for (int i = 0; i < edgeMinToTree.length; i++) {
            if (edgeMinToTree[i] != null)
                list.add(edgeMinToTree[i]);
        }

        return list;
    }

    public double getWeight() {
        double weight = 0.0D;
        for (Edge edge: getEdges()) {
            weight += edge.getWeight();
        }

        return weight;
    }
}
