package algorithms.graph.sp;

/**
 * Created by xuan on 2017/3/16 0016.
 */
public class DirectedEdge {
    private int from;
    private int to;
    private double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", from, to, weight);
    }
}
