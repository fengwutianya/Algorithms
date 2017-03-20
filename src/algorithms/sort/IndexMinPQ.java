package algorithms.sort;

import java.util.Iterator;

/**
 * Created by xuan on 17-3-20.
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Key>{
    private int[] pq;
    private int[] qp;
    private int index;
    private Key[] keys;
    private int maxIndex;

    public IndexMinPQ(int maxIndex) {
        if (maxIndex < 0) throw new IllegalArgumentException("< 0");
        this.maxIndex = maxIndex;
        pq = new int[maxIndex + 1];
        qp = new int[maxIndex + 1];
        keys = (Key[]) new Object[maxIndex + 1];
        for (int i = 1; i < maxIndex + 1; i++) {
            qp[i] = -1;
        }
    }

    public void insert(int i, Key key) {
        if (i < 1 || i > maxIndex) throw new IndexOutOfBoundsException();
        if (contains(i)) throw new IllegalArgumentException("i already in heap");
        keys[i] = key;
        index ++;
        qp[i] = index;
        pq[index] = i;
        swim(index);
    }

    private void swim(int k) {
        for (int i = k; i > 1; i = i / 2) {
            if (greater(i/2, i))
                exch(i/2, i);
        }
    }

    private void sink(int k) {
        for (;k*2 <= maxIndex; k = k * 2) {
            int j = k*2;
            if (k*2 < maxIndex && greater(j, j+1)) j++;
            if (pq[j] > pq[k]) break;
            exch(j, k);
        }
    }

    private void exch(int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private boolean contains(int i) {
        if (i < 1 && i > maxIndex) throw new IndexOutOfBoundsException();
        return qp[i] != -1;
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    public boolean isEmpty() {
        return maxIndex == 0;
    }

    private class HeapIterator implements Iterator<Key> {
        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public Key next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();
            return delMin();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    private Key delMin() {
        int min = pq[1];
        exch(1, maxIndex);
        qp[pq[maxIndex]] = -1;
        maxIndex--;
        keys[min] = null;
        sink(1);
        return keys[min];
    }
}
