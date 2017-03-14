package test.graph;

import algorithms.graph.Graph;
import algorithms.graph.TwoColor;
import edu.princeton.cs.algs4.In;

/**
 * Created by xuan on 17-3-13.
 */
public class TestTwoColor {
    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        TwoColor twoColor = new TwoColor(graph);
        System.out.println("is two color: " + twoColor.isTwoColor());
    }
}
