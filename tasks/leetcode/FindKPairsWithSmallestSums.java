package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKPairsWithSmallestSums {

    class Pair implements Comparable<Pair> {
        int i;
        int j;
        int sum;

        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        @Override
        public int compareTo(Pair p) {
            return sum - p.sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            return j == pair.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return list;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0, nums1[0] + nums2[0]));
        Set<Pair> visited = new HashSet<>();
        while (!queue.isEmpty() && list.size() < k) {
            Pair pair = queue.poll();
            list.add(new int[]{nums1[pair.i], nums2[pair.j]});
            if (pair.i < nums1.length - 1) {
                Pair next = new Pair(pair.i + 1, pair.j, nums1[pair.i+1] + nums2[pair.j]);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
            if (pair.j < nums2.length - 1) {
                Pair next = new Pair(pair.i, pair.j + 1, nums1[pair.i] + nums2[pair.j + 1]);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums t = new FindKPairsWithSmallestSums();
        t.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
    }


}
