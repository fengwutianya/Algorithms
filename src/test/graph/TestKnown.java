package test.graph;

/**
 * Created by xuan on 17-3-15.
 */
public class TestKnown {
    private double i;

    public double getI() {
        return i;
    }

    public static void main(String[] args) {
//        System.out.println(1.0D/0);
//        System.out.println(new TestKnown().getI());
        int[] a = new int[0];
        System.out.println(a == null);
        System.out.println(a.length);
    }
}
