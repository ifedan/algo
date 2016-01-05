package algos.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

    static class Node {
        int val;
        Node[] children;

        Node(int val) {
            this.val = val;
        }
    }

    public void traverse(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Set<Node> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("visited: " + node.val);
            visited.add(node);
            if (node.children != null) {
                for (Node child : node.children) {
                    if (!visited.contains(child)) {
                        queue.offer(child);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new Node[]{new Node(2), new Node(3)};
        root.children[1].children = new Node[]{new Node(4)};
        BFS t = new BFS();
        t.traverse(root);
    }

}
