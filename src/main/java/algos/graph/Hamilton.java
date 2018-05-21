package algos.graph;

import java.util.*;

public class Hamilton {

    static class Node {
        Collection<Node> children;
    }

    public static List<Node> getPath(Collection<Node> nodes) {
        Set<Node> visited = new HashSet<>();
        List<Node> path = new LinkedList<>();
        Node start = nodes.iterator().next();
        if (dfs(start, start, visited, path, nodes.size())) {
            return path;
        }
        return null;
    }

    private static boolean dfs(Node start, Node current, Set<Node> visited, List<Node> path, int size) {
        visited.add(current);
        path.add(current);

        if (current.children != null) {
            for (Node child : current.children) {
                if (start.equals(child) && path.size() == size) {
                    return true;
                }
                if (!visited.contains(child)) {
                    if (dfs(start, current, visited, path, size)) {
                        return true;
                    }
                }
            }
        }

        visited.remove(current);
        path.remove(current);
        return false;
    }

}
