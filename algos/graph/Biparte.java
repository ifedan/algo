package algos.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * O(E+V)
 */
public class Biparte {

    static class Node {
        Collection<Node> children;
    }

    public static boolean isBiparte(Collection<Node> nodes) {
        Set<Node> red = new HashSet<>();
        Set<Node> blue = new HashSet<>();
        for (Node node : nodes) {
            if (!red.contains(node) && !blue.contains(node)) {
                if (!dfs(node, red, blue, true)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(Node node, Set<Node> red, Set<Node> blue, boolean wasRed) {
        if (wasRed) {
            if (red.contains(node)) {
                return false;
            }
            if (blue.contains(node)) {
                return true;
            }
            blue.add(node);
        } else {
            if (blue.contains(node)) {
                return false;
            }
            if (red.contains(node)) {
                return true;
            }
            red.add(node);
        }
        if (node.children != null) {
            for (Node child : node.children) {
                if (!dfs(child, red, blue, !wasRed)) {
                    return false;
                }
            }
        }
        return true;
    }

}