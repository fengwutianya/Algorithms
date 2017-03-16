package test.graph.sp;

import algorithms.graph.sp.DijkstraSP;
import algorithms.graph.sp.DirectedEdge;
import algorithms.graph.sp.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

/**
 * Created by xuan on 17-3-17.
 */
public class TestSP {
    public static void main(String[] args) {
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(new In(args[0]));
        int start = Integer.parseInt(args[1]);
        DijkstraSP sp = new DijkstraSP(digraph, start);
        for (int i = 0; i < digraph.getVertextNum(); i++) {
            System.out.print(start + " to " + i +
                    "(" + sp.getDistTo(i) + "): ");
            if (i != start)
            for (DirectedEdge de: sp.pathTo(i)) {
                System.out.print(de + " ");
            }
            System.out.println();
        }
    }
}
