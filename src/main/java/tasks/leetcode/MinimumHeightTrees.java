package tasks.leetcode;

import java.util.*;

public class MinimumHeightTrees {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        findMinHeightTrees(6, graph);
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.compute(edge[0], (k, v) -> {
                if (v == null) v = new HashSet<>();
                v.add(edge[1]);
                return v;
            });
            graph.compute(edge[1], (k, v) -> {
                if (v == null) v = new HashSet<>();
                v.add(edge[0]);
                return v;
            });
        }

        while (graph.size() > 2) {
            Set<Integer> nodesWithOneChild = new HashSet<>();
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                if (entry.getValue().size() == 1) {
                    nodesWithOneChild.add(entry.getKey());
                }
            }
            for (Integer toRemove : nodesWithOneChild) {
                Set<Integer> children = graph.get(toRemove);
                for (Integer child : children) {
                    graph.get(child).remove(toRemove);
                }
                graph.remove(toRemove);
            }
        }

        return new ArrayList<>(graph.keySet());
    }

}
