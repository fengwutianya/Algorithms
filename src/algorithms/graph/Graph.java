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
        adj = (Bag<Integer>[])new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int edge = in.readInt();
//        System.out.println(E);
        for (int i = 0; i < edge; i++) {
//            System.out.println(i);
            int v = in.readInt();
//            System.out.println(v);
            int w = in.readInt();
//            System.out.println(w);
            addEdge(v, w);
        }
//        while (in.hasNextLine()) {
//            System.out.println(in.readLine());
//        }
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
