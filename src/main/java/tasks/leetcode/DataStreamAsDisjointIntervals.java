package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataStreamAsDisjointIntervals {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
   }

    TreeMap<Integer, Interval> startEnd = new TreeMap<>();

    public DataStreamAsDisjointIntervals() {

    }

    public void addNum(int val) {
        if (startEnd.containsKey(val)) {
            return;
        }
        Map.Entry<Integer, Interval> left = startEnd.lowerEntry(val);
        if (left != null && left.getValue().end >= val) {
            return;
        }

        int start = val;
        if (left != null && val - left.getValue().end == 1) {
            start = left.getKey();
            startEnd.remove(left.getKey());
        }
        Map.Entry<Integer, Interval> right = startEnd.higherEntry(val);
        int end = val;
        if (right != null && right.getKey() - val == 1) {
            end = right.getValue().end;
            startEnd.remove(right.getKey());

        }
        startEnd.put(start, new Interval(start, end));
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(startEnd.values());
    }

    public static void main(String[] args) {
        DataStreamAsDisjointIntervals test = new DataStreamAsDisjointIntervals();
        test.addNum(1);
        test.addNum(3);
        test.addNum(7);
        test.addNum(2);
        test.addNum(6);

    }
}
