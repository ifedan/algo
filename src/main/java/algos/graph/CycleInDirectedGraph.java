package algos.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * O(V+E)
 */
public class CycleInDirectedGraph {

    static class Node {
        Collection<Node> children;
    }

    public static boolean hasCycle(Collection<Node> nodes) {
        Set<Node> white = new HashSet<>();
        Set<Node> grey = new HashSet<>();
        Set<Node> black = new HashSet<>();

        white.addAll(nodes);

        while (!white.isEmpty()) {
            Node node = white.iterator().next();
            if (dfs(node, white, grey, black)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(Node node, Set<Node> white, Set<Node> grey, Set<Node> black) {
        move(node, white, grey);

        if (node.children != null) {
            for (Node child : node.children) {
                if (black.contains(child)) {
                    continue;
                }
                if (grey.contains(child)) {
                    return true;
                }
                if (dfs(node, white, grey, black)) {
                    return true;
                }
            }
        }

        move(node, grey, black);
        return false;
    }

    private static void move(Node node, Set<Node> first, Set<Node> second) {
        first.remove(node);
        second.add(node);
    }

}
