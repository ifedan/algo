package tasks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

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

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        Collections.sort(intervals, new IntervalComparator());

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        boolean startMerging = false;
        boolean wasInserted = false;
        boolean wasMerged = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval in = intervals.get(i);
            min = Math.min(min, in.start);
            max = Math.max(max, in.end);
            if (newInterval.start <= in.end && newInterval.end >= in.start) {
                startMerging = true;
                start = Math.min(start, Math.min(newInterval.start, in.start));
                end = Math.max(end, Math.max(newInterval.end, in.end));
            }
            else {
                if (startMerging) {
                    startMerging = false;
                    wasMerged = true;
                    result.add(new Interval(start, end));
                } else if (!wasInserted && !startMerging && !wasMerged
                        && in.start > newInterval.end) {
                    wasInserted = true;
                    result.add(newInterval);
                }
                result.add(in);
            }

        }
        if (startMerging) {
            result.add(new Interval(start, end));
        }

        if (max < newInterval.start) result.add(newInterval);

        return result;
    }
}
