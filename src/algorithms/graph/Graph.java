package algorithms.graph;

import algorithms.collections.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by xuan on 2017/3/10 0010.
 */
public class Graph {
    private final int vertexNum;    //顶点数
    private int edgeNum;          //边数
    private Bag<Integer>[] adjs; //邻接们

    public int getVertexNum() {return vertexNum;}

    public int getEdgeNum() {
        return edgeNum;
    }

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        adjs = (Bag<Integer>[])new Bag[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            adjs[i] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int numOfEdge = in.readInt();
//        System.out.println(E);
        for (int i = 0; i < numOfEdge; i++) {
//            System.out.println(i);
            int from = in.readInt();
//            System.out.println(v);
            int to = in.readInt();
//            System.out.println(w);
            addEdge(from, to);
        }
//        while (in.hasNextLine()) {
//            System.out.println(in.readLine());
//        }
    }

    private void addEdge(int from, int to) {
        adjs[from].add(to);
        adjs[to].add(from);
        edgeNum++;
    }

    public Iterable<Integer> getAdj(int num) {
        return adjs[num];
    }
}
