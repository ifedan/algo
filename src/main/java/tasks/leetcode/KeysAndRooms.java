package tasks.leetcode;

import java.util.*;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return bfs(rooms).size() == rooms.size();
    }

    private static Set<Integer> bfs(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer room : rooms.get(0)) {
            queue.offer(room);
        }
        visited.add(0);
        while (!queue.isEmpty()) {
            Integer room = queue.poll();
            visited.add(room);
            for (Integer next : rooms.get(room)) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                }
            }
        }
        return visited;
    }
}
