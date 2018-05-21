package datastructures;

public class IntervalTree {

    class Node {
        Node left;
        Node right;
        int lo;
        int hi;
        int max;
    }

    private Node insert(Node node, int lo, int hi) {
        if (node == null) {
            node = new Node();
            node.lo = lo;
            node.hi = hi;
            node.max = hi;
            return node;
        }
        if (node.lo > lo) {
            node.left = insert(node.left, lo, hi);
        } else if (node.lo < lo) {
            node.right = insert(node.right, lo, hi);
        }

        node.max = Math.max(node.max, hi);
        return node;
    }

    private boolean isOverlap(Node node, int lo, int hi) {
        if (node == null) return false;
        if (node.lo <= hi && node.hi >= lo) return true;

        if (node.left != null && node.left.max > lo) {
            return isOverlap(node.left, lo, hi);
        } else {
            return isOverlap(node.right, lo, hi);
        }
    }

}
