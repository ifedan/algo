package algos.graph;

import java.util.*;

/**
 * A vertex in an undirected connected graph is an articulation point (or cut vertex) if removing it (and edges through it) disconnects the graph.
 * O(E+V)
 */
public class ArticulationPoints {

    private static int time = 0;

    static class Node {
        Collection<Node> children;
    }

    public static Collection<Node> get(Collection<Node> nodes) {
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parent = new HashMap<>();
        Map<Node, Integer> current = new HashMap<>();
        Map<Node, Integer> min = new HashMap<>();

        Set<Node> result = new HashSet<>();

        for (Node node : nodes) {
            if (!visited.contains(node)) {
                dfs(node, visited, parent, current, min, result);
            }
        }

        return result;
    }

    private static void dfs(Node node, Set<Node> visited,
                            Map<Node, Node> parent, Map<Node, Integer> current, Map<Node, Integer> min,
                            Set<Node> result) {
        visited.add(node);

        current.put(node, time);
        min.put(node, time);
        time++;

        int childrenCount = 0;

        if (node.children != null) {
            for (Node child : node.children) {
                if (!visited.contains(child)) {
                    parent.put(child, node);
                    childrenCount++;

                    dfs(child, visited, parent, current, min, result);

                    min.put(node, Math.min(min.get(node), min.get(child)));

                    if (parent.get(node) == null && childrenCount > 1) {
                        result.add(node);
                    }

                    if (parent.get(node) != null && min.get(child) >= current.get(node)) {
                        result.add(node);
                    }
                } else if (child != parent.get(node)) {
                    min.put(node, Math.min(min.get(node), current.get(child)));
                }
            }
        }
    }

}
