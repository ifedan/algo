package tasks.leetcode;


import java.util.*;

public class CourseSchedule {

    private class Node {
        int va;
        List<Node> children = new ArrayList<>();
    }

    public boolean isValid(int num, int req[][]) {
        Map<Integer, Node> map = new HashMap<>();
        for (int[] time : req) {
            Node start = map.get(time[0]);
            if (start == null) {
                start = new Node();
                map.put(time[0], start);
            }
            Node end = map.get(time[1]);
            if (end == null) {
                end = new Node();
                map.put(time[1], end);
            }
            start.children.add(end);
        }
        return !hasCycle(map.values());
    }

    public boolean hasCycle(Collection<Node> nodes) {
        if (nodes == null) return false;

        Set<Node> white = new HashSet<>();
        Set<Node> grey = new HashSet<>();
        Set<Node> black = new HashSet<>();

        white.addAll(nodes);

        while (!white.isEmpty()) {
            Node node = white.iterator().next();
            if (hasCycle(node, white, grey, black)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> white, Set<Node> grey, Set<Node> black) {
        if (node == null) return false;
        move(node, white, grey);

        for (Node child : node.children) {
            if (black.contains(child)) {
                continue;
            }
            if (grey.contains(child)) {
                return true;
            }
            if (hasCycle(child, white, grey, black)) {
                return true;
            }
        }

        move(node, grey, black);
        return false;
    }

    private void move(Node node, Set<Node> from, Set<Node> to) {
        from.remove(node);
        to.add(node);
    }

    public static void main(String[] args) {
        CourseSchedule t = new CourseSchedule();
        t.isValid(2, new int[][]{{1, 0}});
    }

}
