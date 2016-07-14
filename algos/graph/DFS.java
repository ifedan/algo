package algos.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * O(V+E)
 */
public class DFS {

    private static class Node {
        Collection<Node> children;
        Node(Collection<Node> children) {
            this.children = children;
        }
    }

    private void trace(Node root) {
        if (root == null) return;
        trace(root, new HashSet<>());
    }

    private void trace(Node node, Set<Node> visited) {
        visit(node);
        visited.add(node);
        if (node.children != null) {
            for (Node child : node.children) {
                if (!visited.contains(child)) {
                    trace(child, visited);
                }
            }
        }
    }

    public void visit(Node node) {

    }

}
