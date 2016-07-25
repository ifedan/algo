package tasks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SpiralOrderTraversal {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static void solve(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean left = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                System.out.println(node.val);
                if (left) {
                    if (node.right != null) queue.add(node.right);
                    if (node.left != null) queue.add(node.left);
                } else {
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            left = !left;
        }
    }


    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;

        root.left = new Node();
        root.left.val = 2;
        root.right = new Node();
        root.right.val = 20;

        root.left.left = new Node();
        root.left.left.val = 3;
        root.left.right = new Node();
        root.left.right.val = 4;

        solve(root);
    }


}
