package algos.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static algos.graph.Euler.RESULT.HAS_EULER_CYCLE;
import static algos.graph.Euler.RESULT.HAS_EULER_PATH;
import static algos.graph.Euler.RESULT.NOT_EULER;

public class Euler {

    enum RESULT {NOT_EULER, HAS_EULER_PATH, HAS_EULER_CYCLE}

    static class Node {
        Collection<Node> children;
    }

    private static RESULT inspect(Collection<Node> nodes) {
        if (!isConnected(nodes)) return NOT_EULER;

        int odd = 0;
        for (Node node : nodes) {
            if (node.children != null && node.children.size() % 2 != 0) {
                odd++;
            }
        }

        if (odd > 2) return NOT_EULER;

        return odd == 0 ? HAS_EULER_PATH : HAS_EULER_CYCLE;
    }

    private static boolean isConnected(Collection<Node> nodes) {
        Node start = null;
        for (Node node : nodes) {
            if (node.children != null || !node.children.isEmpty()) {
                start = node;
                break;
            }
        }
        if (start == null) return true;

        Set<Node> visited = new HashSet<>();
        dfs(start, visited);

        for (Node node : nodes) {
            if (node.children != null && !node.children.isEmpty() && !visited.contains(node)) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(Node node, Set<Node> visited) {
        visited.add(node);
        if (node.children != null) {
            for (Node child : node.children) {
                if (!visited.contains(child)) {
                    dfs(child, visited);
                }
            }
        }
    }

}
