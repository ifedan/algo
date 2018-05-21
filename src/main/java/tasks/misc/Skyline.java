package tasks.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Skyline {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        boolean start;

        @Override
        public int compareTo(Point o) {
            if (start && o.start && x == o.x) {
                return y - o.y;
            }
            if (!start && !o.start && x == o.x) {
                return o.y - y;
            }
            if (!start && o.start && x == o.x) {
                return x;
            }
            return x - o.x;
        }
    }



    public static List<Point> solve(Point[] points) {
        List<Point> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);

        for (Point p : points) {
            Integer currMax = map.lastKey();
            if (p.start) {
                map.merge(p.y, 1, (k, v) -> v+1);
            } else {
                map.compute(p.y, (k, v) -> v>1 ? v-1 : null);
            }
            if (map.lastKey() != currMax) {
                Point point = new Point();
                point.x = p.x;
                point.y = currMax;
                result.add(point);
            }
        }
        return result;
    }

}
