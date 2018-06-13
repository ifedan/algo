package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoudAndRich {
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < richer.length; i++) {
            Integer more = richer[i][0];
            Integer less = richer[i][1];
            map.compute(less, (k, v) -> {
                if (v == null) v = new ArrayList<>();
                v.add(more);
                return v;
            });
        }
        int[] answer = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < quiet.length; i++) {
            dfs(i, quiet, map, answer);
        }
        return answer;
    }

    public static int dfs(int child, int[] quiet, Map<Integer, List<Integer>> graph, int[] answer) {
        if (answer[child] >= 0) return answer[child];
        answer[child] = child;
        List<Integer> parents = graph.get(child);
        if (parents != null) {
            for (int parent : graph.get(child)) {
                if (quiet[answer[child]] > quiet[dfs(parent, quiet, graph, answer)]) {
                    answer[child] = Math.min(answer[child], answer[parent]);
                }
            }
        }
        return answer[child];
    }

    public static void main(String[] args) {
        //loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[]{3,2,5,4,6,1,7,0});
        loudAndRich(new int[][]{{0,2},{1,2}}, new int[]{0,1,2});
    }
}
