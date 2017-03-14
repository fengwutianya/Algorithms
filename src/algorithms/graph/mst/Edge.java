package algorithms.graph.mst;

/**
 * Created by xuan on 17-3-14.
 */
public class Edge implements Comparable<Edge> {
    private final int from;
    private final int to;
    private final double weight;

    @Override
    public int compareTo(Edge edge) {
        if (this.weight < edge.weight) return -1;
        else if (this.weight > edge.weight) return 1;
        else return 0;
    }

    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int other(int vertex) {
        if (vertex == from) return to;
        if (vertex == to) return from;
        else throw new RuntimeException("Inconsistent edge");
    }

    public int either() {
        return from;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", from, to, weight);
    }
}
