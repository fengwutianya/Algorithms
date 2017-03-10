package algorithms.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by xuan on 2017/3/10 0010.
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;   //链表头节点
    private int n;              //length

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current != null; //照顾第一个，当前current已经是next后的了
                                    //所以next要做调整
        }

        @Override
        public Item next() {
            if (hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }
}
