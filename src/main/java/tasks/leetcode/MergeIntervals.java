package tasks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                Interval interval = new Interval(start, end);
                result.add(interval);
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        Interval interval = new Interval(start, end);
        result.add(interval);
        return result;
    }
}
