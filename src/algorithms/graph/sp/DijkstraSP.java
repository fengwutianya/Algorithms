package algorithms.graph.sp;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by xuan on 2017/3/16 0016.
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph digraph, int s) {
        int vertexNum = digraph.getVertextNum();
        edgeTo = new DirectedEdge[vertexNum];
        distTo = new double[vertexNum];
        pq = new IndexMinPQ<>(vertexNum);
        for (int i = 0; i < vertexNum; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty())
            relax(digraph, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph digraph, int vertex) {
        for (DirectedEdge de: digraph.getAdj(vertex)) {
            int to = de.getTo();
            if (distTo[to] > distTo[vertex] + de.getWeight()) {
                edgeTo[to] = de;
                distTo[to] = distTo[vertex] + de.getWeight();
                if (pq.contains(to)) pq.changeKey(to, distTo[to]);
                else pq.insert(to, distTo[to]);
            }
        }
    }

    public double getDistTo(int vertex) {
        return distTo[vertex];
    }

    public boolean hasPathTo(int vertex) {
        return distTo[vertex] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int vertex) {
        if (!hasPathTo(vertex)) return null;
        Stack<DirectedEdge> paths = new Stack<>();
        for (int end = vertex; distTo[end] != 0.0; end = edgeTo[end].getFrom()) {
            paths.push(edgeTo[end]);
        }
        return paths;
    }
}
