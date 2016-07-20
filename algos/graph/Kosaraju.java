package algos.graph;

import java.util.*;

public class Kosaraju {

    static class Node {
        Collection<Node> children;
    }

    public static Collection<Stack<Node>> getScc(Collection<Node> nodes) {
        Stack<Node> sortedStack = getTopologicalSort(nodes);
        revertGraph(sortedStack);

        Set<Node> visited = new HashSet<>();
        List<Stack<Node>> result = new ArrayList<>();
        while (!sortedStack.isEmpty()) {
            Node node = sortedStack.pop();
            Stack<Node> stack = new Stack<>();
            dfs(node, visited, stack);
            result.add(stack);
        }
        return result;
    }

    private static Stack<Node> getTopologicalSort(Collection<Node> nodes) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        for (Node node : nodes) {
            if (!visited.contains(node)) {
                dfs(node, visited, stack);
            }
        }
        return stack;
    }

    private static void dfs(Node node, Set<Node> visited, Stack<Node> stack) {
        visited.add(node);
        if (node.children != null) {
            for (Node child : node.children) {
                if (!visited.contains(child)) {
                    dfs(child, visited, stack);
                }
            }
        }
        stack.push(node);
    }

    //TODO
    private static void revertGraph(Stack<Node> graph) {

    }
}
