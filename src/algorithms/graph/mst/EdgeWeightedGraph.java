package algorithms.graph.mst;

import algorithms.collections.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Iterator;

/**
 * Created by xuan on 17-3-14.
 */
public class EdgeWeightedGraph {
    private final int vertexNum;
    private int edgeNum;
    private Bag<Edge>[] adjs;

    public EdgeWeightedGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        adjs = (Bag<Edge>[])new Bag[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            adjs[i] = new Bag<Edge>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int num_of_edge = in.readInt();
        for (int i = 0; i < num_of_edge; i++) {
            int from = in.readInt();
            int to = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(from, to, weight));
        }
    }

    private void addEdge(Edge edge) {
        int from = edge.either();
        adjs[from].add(edge);
        int to = edge.other(from);
        adjs[to].add(edge);
        edgeNum++;
    }

    public Iterable<Edge> getAdj(int vertex) {
        return adjs[vertex];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int i = 0; i < vertexNum; i++) {
            for (Edge edge: adjs[i]) {
                if (edge.other(i) > i) //non-directed graph half edges
                    edges.add(edge);
            }
        }
        return edges;
    }
}
