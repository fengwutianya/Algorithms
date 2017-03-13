package test.graph;

import algorithms.graph.BreadthFirstPaths;
import algorithms.graph.DepthFirstPaths;
import algorithms.graph.DepthFirstSearch;
import algorithms.graph.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by xuan on 17-3-13.
 */
public class TestPaths {
    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        int start = Integer.parseInt(args[1]);
//        BreadthFirstPaths search = new BreadthFirstPaths(graph, start);
        DepthFirstPaths search = new DepthFirstPaths(graph, start);
        for (int i = 0; i < graph.getVertexNum(); i++) {
            StdOut.print(start + " to " + i + ": ");
            if (search.hasPathTo(i)) {
                for (int j: search.pathTo(i)) {
                    if (j == start) StdOut.print(j);
                    else StdOut.print("-" + j);
                }
            }
            System.out.println();
        }
    }
}
