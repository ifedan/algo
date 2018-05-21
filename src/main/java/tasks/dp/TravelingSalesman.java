package tasks.dp;

import java.util.*;

public class TravelingSalesman {



    private static void generateWays(int point, Set<Integer> ways, int[] points, int start, List<List<Integer>> result) {
        if (points.length == start) {
            return;
        }
        if (points[start] != point) {
            ways.add(points[start]);
        }
        result.add(new ArrayList<>(ways));
        generateWays(point, ways, points, start+1, result);
        ways.remove(points[start]);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] points = new int[]{1, 2, 3};
        for (int i = 0; i < points.length; i++) {
            generateWays(points[i], new HashSet<>(), points, 0, result);
        }
        System.out.println(result);
    }

}
