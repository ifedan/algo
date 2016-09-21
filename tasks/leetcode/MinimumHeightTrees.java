package tasks.leetcode;

import java.util.*;

public class MinimumHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> vertex = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            vertex.add(i);
        }

        List<int[]> edgeList = new ArrayList<int[]>();
        for (int[] edge : edges) {
            edgeList.add(edge);
        }

        Map<Integer, Integer> children = null;
        while (edgeList.size() >= 2) {
            children = new HashMap<Integer, Integer>();

            for (int[] edge : edgeList) {
                Integer count1 = children.get(edge[0]);
                if (count1 == null) children.put(edge[0], 1);
                else children.put(edge[0], count1 + 1);

                Integer count2 = children.get(edge[1]);
                if (count2 == null) children.put(edge[1], 1);
                else children.put(edge[1], count2 + 1);
            }

            for (Iterator<int[]> it = edgeList.iterator(); it.hasNext(); ) {
                int[] edge = it.next();
                if (children.get(edge[0]) == 1){
                    vertex.remove(edge[0]);
                    it.remove();
                } else if (children.get(edge[1]) == 1) {
                    vertex.remove(edge[1]);
                    it.remove();
                }
            }
        }

        return new ArrayList<Integer>(vertex);
    }

}
