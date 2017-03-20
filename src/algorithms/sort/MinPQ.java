package algorithms.sort;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by xuan on 2017/3/20 0020.
 */
public class MinPQ<Key> implements Iterator<Key> {
    private Key[] pq;
    private int len;
    private Comparator<Key> comparator;

    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity];
        len = 0;
    }

    public MinPQ() {
        this(1);
    }

    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        this(initCapacity);
        this.comparator = comparator;
    }

    public MinPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public MinPQ(Key[] keys) {
        this(keys.length);
        len = keys.length;
        System.arraycopy(keys, 0, pq, 1, keys.length);
        //建堆，采用先建底部小堆再下沉的方法
        for (int i = len/2; i >= 1; i--) {
            sink(i);
        }
    }

    private void sink(int k) {
        while (k*2 <= len) {
            int j = k*2;
            if (j < len && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        //i不能等于1，否则i/2=0 0元素是废的
        for (int i = k; i > 1 && greater(i/2, i); i = i/2) {
            exch(i/2, i);
        }
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>)pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    @Override
    public boolean hasNext() {
        return len > 0;
    }

    @Override
    public Key next() {
        return this.delMin();
    }

    public Key delMin() {
        if (!hasNext()) throw new NoSuchElementException("underflow");
        exch(1, len);
        Key min = pq[len--];
        sink(1);
        pq[len+1] = null;

        //resize
        if (len > 0 && len == (pq.length - 1)/4) resize(pq.length/2);

        return min;
    }

    public void insert(Key value) {
        if (len == pq.length-1) resize(pq.length*2);
        len++;
        pq[len] = value;
        swim(len);
    }

    private void resize(int capacity) {
        Key[] newPQ = (Key[]) new Object[capacity];
        System.arraycopy(pq, 1, newPQ, 1, len);
        pq = newPQ;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("do not support remove");
    }
}
