package algorithms.graph.sp;

import algorithms.collections.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by xuan on 2017/3/16 0016.
 */
public class EdgeWeightedDigraph {
    private final int vertextNum;
    private int edgeNum;
    private Bag<DirectedEdge>[] adj;

    public int getVertextNum() {
        return vertextNum;
    }

    public EdgeWeightedDigraph(int vertextNum) {
        this.vertextNum = vertextNum;
        edgeNum = 0;
        adj = (Bag<DirectedEdge>[])new Bag[vertextNum];
        for (int i = 0; i < vertextNum; i++) {
            adj[i] = new Bag<DirectedEdge>();
        }
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int num_of_edge = in.readInt();
        for (int i = 0; i < num_of_edge; i++) {
            DirectedEdge de = new DirectedEdge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(de);
        }
    }

    private void addEdge(DirectedEdge de) {
        adj[de.getFrom()].add(de);
        edgeNum++;
    }

    public Iterable<DirectedEdge> getAdj(int vertextNum) {
        return adj[vertextNum];
    }

    public Iterable<DirectedEdge> getEdges() {
        Bag<DirectedEdge> edges = new Bag<>();
        for (int i = 0; i < vertextNum; i++) {
            for (DirectedEdge de: adj[i]) {
                edges.add(de);
            }
        }
        return edges;
    }
}
