package tasks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelByLevelBT {

    static class Node {
        Node left;
        Node right;
        int val;
        Node(int v){val = v;}
    }

    public static void solve(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    System.out.println();
                    queue.add(null);
                    continue;
                } else {
                    break;
                }
            }
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.right.right = new Node(20);
        root.right.left = new Node(12);
        solve(root);
    }

}
