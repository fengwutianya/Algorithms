package algorithms.search;

/**
 * Created by xuan on 2017/3/21 0021.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private boolean color;
        private Key key;
        private Value value;
        private Node left, right;
        private int subTreeCount;

        public Node(Key key, Value value, boolean color, int subTreeCount) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.subTreeCount = subTreeCount;
        }
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        x.color = h.color;  //新的头节点保留原来头节点的颜色
        h.color = RED;      //原来的头节点变红
        x.subTreeCount = h.subTreeCount;    //修正记录的子节点个数
        h.subTreeCount = 1 + size(h.left) + size(h.right);

        return x;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.subTreeCount;
    }

    private boolean isRed(Node h) {
        return h.color;
    }

    //向上传递红节点
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = h.color;
        h.color = RED;
        x.subTreeCount = h.subTreeCount;
        h.subTreeCount = 1 + size(h.left) + size(h.right);

        return x;
    }
}
