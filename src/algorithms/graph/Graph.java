package algorithms.graph;

import algorithms.collections.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by xuan on 2017/3/10 0010.
 */
public class Graph {
    private final int V;    //顶点数
    private int E;          //边数
    private Bag<Integer>[] adj; //邻接们

    public int V() {return V;}
    public int E() {return E;}

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[])new Bag[10];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
