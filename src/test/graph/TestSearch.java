package test.graph;

import algorithms.graph.DepthFirstSearch;
import algorithms.graph.Graph;
import edu.princeton.cs.algs4.In;

/**
 * Created by xuan on 17-3-12.
 */
public class TestSearch {
    public static void main(String[] args) {
//        System.out.println(args[0]);
//        System.out.println(args[1]);
        Graph graph = new Graph(new In(args[0]));
        int start = Integer.parseInt(args[1]);
        DepthFirstSearch dfs = new DepthFirstSearch(graph, start);

        for (int i = 0; i < graph.getVertexNum(); i++) {
            if (dfs.marked(i)) {
                System.out.print(i + " ");
            }
//            System.out.println();
        }

        if (dfs.count() < graph.getVertexNum()) {
            System.out.print("Not ");
        }
        System.out.println("Connected");
    }
}
