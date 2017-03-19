package algorithms.graph.sp;

import algorithms.graph.Topological;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by xuan on 2017/3/18 0018.
 */
public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph digraph, int start) {
        int verNum = digraph.getVertextNum();
        edgeTo = new DirectedEdge[verNum];
        distTo = new double[verNum];
        for (int i = 0; i < verNum; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0.0;
        Topological topo = new Topological(digraph);
        for (int w: topo.getOrder()) {
            relax(digraph, w);
        }
    }

    private void relax(EdgeWeightedDigraph digraph, int currNode) {
        for (DirectedEdge de: digraph.getAdj(currNode)) {
            int to = de.getTo();
            if (distTo[to] > distTo[currNode] + de.getWeight()) {
                edgeTo[to] = de;
                distTo[to] = distTo[currNode] + de.getWeight();
            }
        }
    }

    public double getDistTo(int vertex) {
        return distTo[vertex];
    }

    public boolean hasPathTo(int vertex) {
        return distTo[vertex] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> getPathTo(int vertex) {
        if (!hasPathTo(vertex)) return null;
        Stack<DirectedEdge> paths = new Stack<>();
        for (int w = vertex; distTo[w] != 0; w = edgeTo[w].getFrom())
            paths.push(edgeTo[w]);
        return paths;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedDigraph edw = new EdgeWeightedDigraph(in);
        int start = Integer.parseInt(args[1]);
        AcyclicSP asp = new AcyclicSP(edw, start);
        for (int i = 0; i < edw.getVertextNum(); i++) {
            System.out.print(start + " to " + i + "(" + asp.getDistTo(i) + ")" + ": ");
            if (i == start || asp.getDistTo(i) == Double.POSITIVE_INFINITY) {
                System.out.println();
                continue;
            }
            for (DirectedEdge de: asp.getPathTo(i)) System.out.print(de + " ");
            System.out.println();
        }
    }
}
