package tasks.leetcode;

import java.util.*;

public class MeetingRoomsII {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
   }

   public static class Point {
        int x;
        boolean start;
        long interval;
        public String toString() {
            return "" + x + " " + start;
        }
   }

   public static void addPoints(Interval i, List<Point> points) {
        long interval = (((long)i.start)<<32)|i.end;
        Point s = new Point();
        s.x = i.start;
        s.start = true;
        s.interval = interval;

        Point e = new Point();
        e.x = i.end;
        e.start = false;
        e.interval = interval;

        points.add(s);
        points.add(e);
   }

   //[[0, 30],[5, 10],[15, 20]]
    public static void main(String[] args) {
        minMeetingRooms(new Interval[]{
                new Interval(1, 5),
                new Interval(8, 9),
                new Interval(8, 9)
        });
    }

    public static int minMeetingRooms(Interval[] intervals) {
        List<Point> points = new ArrayList<>();
        for (Interval i : intervals) {
            addPoints(i, points);
        }
        Collections.sort(points, (a, b) -> {
            if (a.x != b.x) {
                return a.x - b.x;
            } else {
                if (a.start == b.start) return 0;
                else if (a.start) return 1;
                else return -1;
            }
        });

        Map<Long, Integer> inuse = new HashMap<>();
        int max = 0;
        int current = 0;
        for (Point p : points) {
            if (p.start) {
                inuse.merge(p.interval, 1, (val, acc) -> val + acc);
                current++;
                max = Math.max(max, current);
            } else {
                inuse.compute(p.interval, (k, v) -> v == 1 ? null : v -1);
                current--;
            }
        }
        return max;
    }

    /*

    \--------|
      \---------|
         \----------|

     */
}
