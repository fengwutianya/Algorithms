package test.graph;

import algorithms.graph.Cycle;
import algorithms.graph.Graph;
import edu.princeton.cs.algs4.In;

/**
 * Created by xuan on 2017/3/13 0013.
 */
public class TestCycle {
    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        Cycle cycle = new Cycle(graph);
        System.out.println("has cycle: " + cycle.getHasCycle());
    }
}
