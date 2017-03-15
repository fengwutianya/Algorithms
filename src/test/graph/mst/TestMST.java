package test.graph.mst;

import algorithms.graph.mst.Edge;
import algorithms.graph.mst.EdgeWeightedGraph;
import algorithms.graph.mst.LazyPrimMST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by xuan on 2017/3/15 0015.
 */
public class TestMST {
    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(args[0]));
        LazyPrimMST mst = new LazyPrimMST(graph);
        for (Edge edge: mst.getEdges()) {
            System.out.println(edge);
        }
        System.out.println(mst.weight());

    }
}
