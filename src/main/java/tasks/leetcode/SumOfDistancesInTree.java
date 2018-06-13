package tasks.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfDistancesInTree {

    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 0) return new int[0];
        if (N == 1) {
            int[] a = new int[1];
            a[0] = 0;
            return a;
        }
        int[] count = new int[N];
        traverse(toGraph(edges), edges[0][0], count, new HashSet<>());
        return count;
    }

    public static Set<Integer> traverse(Map<Integer, Set<Integer>> graph, int node, int[] count, Set<Integer> visited) {
        Set<Integer> under = new HashSet<>();
        Set<Integer> children = graph.get(node);
        under.add(node);
        if (children == null) {
            return under;
        }
        for (Integer child : children) {
            if (visited.contains(child)) continue;
            visited.add(child);
            Set<Integer> underChild = traverse(graph, child, count, visited);
            for (int i = 0; i < count.length; i++) {
                if (underChild.contains(i)) {
                    count[i] += count.length - underChild.size();
                } else {
                    count[i] += underChild.size();
                }
            }
            under.addAll(underChild);
        }
        return under;
    }

    private static Map<Integer, Set<Integer>> toGraph(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            final int a = edges[i][0];
            final int b = edges[i][1];
            map.compute(a, (k,v) -> {
                if (v == null) v = new HashSet<>();
                v.add(b);
                return v;
            });
            map.compute(b, (k,v) -> {
                if (v == null) v = new HashSet<>();
                v.add(a);
                return v;
            });
        }
        return map;
    }

    public static void main(String[] args) {
        int edges[][] = new int[][]{{2,0},{1,0}};

        int count[] = sumOfDistancesInTree(3, edges);

        System.out.println();
    }

}

