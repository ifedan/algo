package tasks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        boolean start;
        Point(int x, int y, boolean start) {
            this.x = x;
            this.y = y;
            this.start = start;
        }

        @Override
        public int compareTo(Point o) {
            if (x != o.x) {
                return x - o.x;
            } else {
                //larger should be first in the begging (two starts)
                //smaller should be first in the end (two ends)
                //other: start should be first
                return (start ? -y : y) - (o.start ? -o.y : o.y);
            }
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<Point> points = new ArrayList<Point>();
        for (int[] building : buildings) {
            points.add(new Point(building[0], building[2], true));
            points.add(new Point(building[1], building[2], false));
        }
        Collections.sort(points);

        List<int[]> result = new ArrayList<>();
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);

        int prevMax = 0;
        for (Point p : points) {
            if (p.start) {
                Integer val = queue.get(p.y);
                if (val == null) {
                    queue.put(p.y, 1);
                } else {
                    queue.put(p.y, val+1);
                }
            } else {
                Integer val = queue.get(p.y);
                if (val == 1) {
                    queue.remove(p.y);
                } else {
                    queue.put(p.y, val-1);
                }
            }
            int currMax = queue.lastKey();
            if (prevMax != currMax) {
                result.add(new int[]{p.x, currMax});
                prevMax = currMax;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
    }

}
