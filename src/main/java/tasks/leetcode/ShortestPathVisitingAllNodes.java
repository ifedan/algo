package tasks.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    public static int shortestPathLength(int[][] graph) {
        int mask = (1 << graph.length) - 1;
        Map<Long, Integer> path2len = new HashMap<>();
        Queue<Path> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            queue.offer(new Path(i));
        }
        while(!queue.isEmpty()) {
            Path p = queue.poll();
            Long path = p.key();
            Integer prevLen = path2len.get(path);
            if (prevLen != null && p.len >= prevLen) {
                continue;
            }
            path2len.put(path, p.len);
            if ((p.visited ^ mask) == 0) continue;
            for (int child : graph[p.root]) {
                queue.offer(p.move(child));
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Long, Integer> entry : path2len.entrySet()) {
            int key = (int)entry.getKey().longValue();
            if ((key ^ mask) == 0) {
                min = Math.min(min, entry.getValue());
            }
        }
        return min;
    }

    static class Path {
        int visited;
        int len;
        int root;
        Path(int root) {
            this.root = root;
            visited = 1 << root;
            len = 0;
        }
        Path(int root, int visited, int len) {
            this.root = root;
            this.visited = visited;
            this.len = len;
        }
        Path move(int child) {
            return new Path(child, visited | (1 << child), len+1);
        }
        Long key() {
            return ((long)root << 32) | visited;
        }
        public String toString() {
            return root + "|" + Integer.toBinaryString(visited) + "|" + len;
        }
    }

    public static void main(String[] args) {
        int val = shortestPathLength(new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}});
        System.out.println(val);
        //shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}});
    }
}
