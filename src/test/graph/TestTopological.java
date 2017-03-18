package test.graph;

import algorithms.graph.SymbolDigraph;
import algorithms.graph.Topological;

/**
 * Created by xuan on 2017/3/18 0018.
 */
public class TestTopological {
    public static void main(String[] args) {
        String filename = args[0];
        String separator = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, separator);
        Topological topo = new Topological(sg.G());

        for (int i: topo.getOrder()) {
            System.out.println(sg.name(i));
        }
    }
}
