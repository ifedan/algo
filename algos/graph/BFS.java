package algos.graph;

import java.util.*;

/**
 * O(V+E)
 */
public class BFS {

    private class Node {
        Collection<Node> children;
        Node(Collection<Node> children) {
            this.children = children;
        }
    }

    private void trace(Node root) {
        if (root == null) return;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit(node);
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

    public void visit(Node node) {

    }

}
