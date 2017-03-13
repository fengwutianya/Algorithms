package test.graph;

import algorithms.graph.Graph;
import algorithms.graph.SubGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;

/**
 * Created by xuan on 2017/3/13 0013.
 */
public class TestSubGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        SubGraph subGraph = new SubGraph(graph);
        int graphs = subGraph.getCount();
        System.out.println("There are " + graphs + " subgraphs.");
        LinkedList<Integer>[] lists = (LinkedList<Integer>[])new LinkedList[graphs];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
//        System.out.println(lists.length);
        for (int i = 0; i < graph.getVertexNum(); i++) {
            int j = subGraph.getId(i);
//            System.out.println(j);
            lists[j].add(i);
        }
        for (int i = 0; i < graphs; i++) {
            for (int w: lists[i]) {
                StdOut.print(w + " ");
            }
            System.out.println();
        }
    }
}
