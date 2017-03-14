package algorithms.graph;

import algorithms.collections.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Iterator;

/**
 * Created by xuan on 17-3-13.
 */
public class Digraph {
    private final int vertexNum;
    private int edgeNum;
    private Bag<Integer>[] adjs;

    public Digraph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        adjs = (Bag<Integer>[])new Bag[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            adjs[i] = new Bag<Integer>();
        }
    }

    public Digraph(In in) {
        this(in.readInt());
        edgeNum = in.readInt();
        for (int i = 0; i < edgeNum; i++) {
            int from = in.readInt();
            int to = in.readInt();
            addEdge(from, to);
        }
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public Iterable<Integer> getAdj(int vertex) {
        return adjs[vertex];
    }

    public void addEdge(int from, int to) {
        adjs[from].add(to);
        edgeNum++;
    }

    public Digraph reverse() {
        Digraph digraph  = new Digraph(vertexNum);
        for (int i = 0; i < vertexNum; i++) {
            for (int w: adjs[vertexNum]) {
                digraph.addEdge(w, i);
            }
        }
        return digraph;
    }
}
