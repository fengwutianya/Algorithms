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

    public void put(Key key, Value value) {
        if (key == null) throw new NullPointerException("key cannot be null");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        //插入一定是红节点，也就是说2-3树里不往叶子结点插，叶子结点只是装饰
        if (node == null) return new Node(key, value, RED, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node = put(node.left, key, value);
        else if (cmp > 0) node = put(node.right, key, value);
        else node.value = value;

        //插入黑节点的右边或者红节点的右边
        if (node.right.color == RED && node.left.color != RED) node = rotateLeft(node);
        //4节点 全左
        if (node.left.color == RED && node.left.left.color == RED) node = rotateRight(node);
        //4节点，左右
        if (node.left.color == RED && node.right.color == RED) flipColors(node);
        //插入黑节点的左边，do nothing
    }

    private void delete(Key key) {
        return 1;
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
