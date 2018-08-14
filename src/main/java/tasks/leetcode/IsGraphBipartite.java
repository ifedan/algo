package tasks.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsGraphBipartite {

    public static void main(String[] args) {
        //[[1,3],[0,2],[1,3],[0,2]]
        IsGraphBipartite test = new IsGraphBipartite();
        test.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}});
    }

    public boolean isBipartite(int[][] graph) {
        Map<Integer, Set<Integer>> adjMap = generateGraph(graph);
        Set<Integer> red = new HashSet<>();
        Set<Integer> blue = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (!red.contains(i) && !blue.contains(i)) {
                if (!bfs(adjMap, i, red, blue, true)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Map<Integer, Set<Integer>> generateGraph(int[][] graph) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            int[] adjVertex = graph[i];
            for (int j : adjVertex) {
                int v1 = i;
                int v2 = j;
                result.compute(v1, (k, v) -> {
                    if (v == null) v = new HashSet<>();
                    v.add(v2);
                    return v;
                });
                result.compute(v2, (k, v) -> {
                    if (v == null) v = new HashSet<>();
                    v.add(v1);
                    return v;
                });
            }
        }
        return result;
    }

    private boolean bfs(Map<Integer, Set<Integer>> graph, int node, Set<Integer> red, Set<Integer> blue, boolean wasRed) {
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
        if (graph.containsKey(node)) {
            for (Integer child : graph.get(node)) {
                if (!bfs(graph,child, red, blue, !wasRed)) {
                    return false;
                }
            }

        }

        return true;
    }
}
