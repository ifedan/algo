package tasks.leetcode;

import java.util.*;

public class CourseScheduleII {

    public static class Node {
        int key;
        List<Node> children = new ArrayList<Node>();
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        for (int[] req : prerequisites) {
            Node start = map.get(req[0]);
            if (start == null) {
                start = new Node();
                start.key = req[0];
                map.put(req[0], start);
            }
            Node end = map.get(req[1]);
            if (end == null) {
                end = new Node();
                end.key = req[1];
                map.put(req[1], end);
            }
            end.children.add(start);
        }

        Set<Node> nodes = new HashSet<Node>();
        nodes.addAll(map.values());
        if (hasCycle(nodes)) {
            return new int[0];
        }

        Set<Node> visited = new HashSet<Node>();
        Stack<Node> sort = new Stack<Node>();

        for (Node node : map.values()) {
            if (!visited.contains(node)) {
                dfs(node, visited, sort);
            }
        }

        Set<Integer> nums = new HashSet<Integer>();
        int[] res = new int[numCourses];
        int i = 0;
        while (!sort.isEmpty()) {
            int v = sort.pop().key;
            res[i++] = v;
            nums.add(v);
        }

        for (int j = 0; j < numCourses; j++) {
            if (nums.contains(j)) continue;
            res[i++] = j;
        }

        return res;
    }

    public static boolean hasCycle(Set<Node> nodes) {
        Set<Node> white = nodes;
        Set<Node> grey = new HashSet<Node>();
        Set<Node> black = new HashSet<Node>();

        while (!white.isEmpty()) {
            Node node = white.iterator().next();
            if (dfs(node, white, grey, black)) return true;
        }

        return false;
    }

    public static boolean dfs(Node node, Set<Node> white, Set<Node> grey, Set<Node> black) {
        move(node, white, grey);

        for (Node child : node.children) {
            if (black.contains(child)) continue;
            if (grey.contains(child)) return true;
            if (dfs(child, white, grey, black)) {
                return true;
            }
        }

        move(node, grey, black);
        return false;
    }

    private static void move(Node n, Set<Node> from, Set<Node> to) {
        from.remove(n);
        to.add(n);
    }

    public static void dfs(Node node, Set<Node> visited, Stack<Node> sort) {
        if (node == null) return;
        visited.add(node);
        for (Node child : node.children) {
            if (visited.contains(child)) continue;
            dfs(child, visited, sort);
        }
        sort.push(node);
    }

}
