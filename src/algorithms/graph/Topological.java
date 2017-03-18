package algorithms.graph;

import algorithms.graph.sp.EdgeWeightedDigraph;

/**
 * Created by xuan on 17-3-17.
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph digraph) {
        DirectedCycle cycleFinder = new DirectedCycle(digraph);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(digraph);
            order = dfo.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph digraph) {
        EdgeWeightedDirectedCycle cycleFinder = new EdgeWeightedDirectedCycle(digraph);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(digraph);
            order = dfo.reversePost();
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
