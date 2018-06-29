package tasks.leetcode;

import java.util.*;

public class MinimumCostToHireKWorkers {
    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if (K == 1) {
            return Arrays.stream(wage).min().getAsInt();
        }
        double[][] wperq = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            wperq[i][0] = (double) wage[i] / quality[i];
            wperq[i][1] = quality[i];
        }
        Arrays.sort(wperq, Comparator.comparing(a -> a[0]));

        int sum = 0;
        double min = Double.MAX_VALUE;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < wperq.length; i++) {
            if (pq.size() < K) {
                pq.offer(wperq[i][1]);
                sum += wperq[i][1];
                if (pq.size() == K) {
                    min = Math.min(min, sum * wperq[i][0]);
                }
            } else {
                if (pq.peek() > wperq[i][1]) {
                    sum -= pq.poll();
                    sum += wperq[i][1];
                    pq.offer(wperq[i][1]);
                }
                min = Math.min(min, sum * wperq[i][0]);
            }
        }


        test(wperq, 0, K, new ArrayList<>(), Double.MIN_VALUE);
        System.out.println("======>" + minResult);
        System.out.println("------>" + min);

        return min;
    }

    static double minResult = Double.MAX_VALUE;
    public static void test(double[][] arr, int start, int k, List<Integer> result, double max) {
        if (k == 0) {
            double sum = 0;
            for (int index : result) {
                sum += arr[index][1]*max;
            }
            if (minResult > sum) {
                minResult = sum;
                System.out.println(sum + " --> " + result + " -> " + max);
            }
            return;
        }
        for (int i = start; i <= arr.length - k; i++) {
            result.add(i);
            test(arr, i+1, k-1, result, Math.max(max, arr[i][0]));
            result.remove(result.size() - 1);
        }
    }



    public static void main(String[] args) {
        //mincostToHireWorkers(new int[]{3,1,10,10,1}, new int[]{4,8,2,2,7}, 3);
        //mincostToHireWorkers(new int[]{10,20,5}, new int[]{70,50,30}, 2);
        //mincostToHireWorkers(new int[]{1,2}, new int[]{14,16}, 1);
        //mincostToHireWorkers(new int[]{14,56,59,89,39,26,86,76,3,36}, new int[]{90,217,301,202,294,445,473,245,415,487}, 2);
        //mincostToHireWorkers(new int[]{25,68,35,62,52,57,35,83,40,51}, new int[]{147,97,251,129,438,443,120,366,362,343}, 6);
        mincostToHireWorkers(new int[]{40, 20, 10, 10}, new int[]{20, 10, 5, 10}, 2);
    }


}
