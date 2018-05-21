package algos.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * O(V+E)
 */
public class TopologicalSort {

    static class Node {
        Collection<Node> children;
    }

    public static Stack<Node> sort(Collection<Node> nodes) {
        Stack<Node> result = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : nodes) {
            if (!visited.contains(node)) {
                dfs(node, result, visited);
            }
        }
        return result;
    }

    private static void dfs(Node node, Stack<Node> sort, Set<Node> visited) {
        if (node == null) return;
        visited.add(node);
        if (node.children != null) {
            for (Node child : node.children) {
                if (!visited.contains(child)) {
                    dfs(node, sort, visited);
                }
            }
        }
        sort.push(node);
    }

}
