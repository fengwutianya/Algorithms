package algorithms.sort;

import edu.princeton.cs.algs4.In;

/**
 * Created by xuan on 17-3-19.
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j>0&&less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i+1], a[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert(isSorted(a));
        show(a);
    }
}
