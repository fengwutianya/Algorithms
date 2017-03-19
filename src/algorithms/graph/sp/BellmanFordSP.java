package algorithms.graph.sp;

import algorithms.graph.sp.DirectedEdge;
import algorithms.graph.sp.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by xuan on 2017/3/19 0019.
 */
public class BellmanFordSP {
    private Queue<Integer> queue;
    private boolean[] onQueue;
    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public BellmanFordSP(EdgeWeightedDigraph digraph, int start) {
        int verNum = digraph.getVertextNum();
        onQueue = new boolean[verNum];
        distTo = new double[verNum];
        edgeTo = new DirectedEdge[verNum];
        for (int i = 0; i < verNum; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0;
        onQueue[start] = true;
        queue.enqueue(start);
        while (!queue.isEmpty()) {
            int w = queue.dequeue();
            relax(digraph, w);
        }
    }

    private void relax(EdgeWeightedDigraph digraph, int from) {
        for (DirectedEdge de: digraph.getAdj(from)) {
            int to = de.getTo();
            if (distTo[to] > distTo[from] + de.getWeight()) {
                edgeTo[to] = de;
                distTo[to] = distTo[from] + de.getWeight();

                if (!onQueue[to]) {
                    queue.enqueue(to);
                    onQueue[to] = true;
                }
            }
        }
    }


}
