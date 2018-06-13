package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNumbersSum {
    public static int consecutiveNumbersSum(int N) {
        if (N == 1) return 1;
        if (N == 2) return 1;
        int total = 0;
        for (int a = 1; a <= N/2+1; a++) {
            if (arithmeticSumSize(N, a) > 0) total++;
        }
        return total+1;
    }

    public static int consecutiveNumbersSum2(int N) {
        if (N == 1) return 1;
        if (N == 2) return 1;
        int total = 0;
        int a = 1;
        List<Integer> values = new ArrayList<>();
        while (a <= N/2+1) {
            int size = arithmeticSumSize(N, a);
            if (size > 0) {
                values.add(a + size - 1);
                total++;

                int num = a + size;
                int s = 0;
                while (s < N) {
                    s += num;
                    if (s >= N) break;
                    if (arithmeticSumSize(s, a) > 0) {
                        total++;
                    }
                    num++;
                }

                a += size;
            } else {
                a++;
            }
        }
        System.out.println(values);
        return total+1;
    }

    //We want to solve equation that N = Sum of arithmetic progression starting with arr
    public static int arithmeticSumSize(int sum, int base) {
        long d = 4L * base * (base - 1) + 8 * sum + 1;
        double sqrt = Math.sqrt(d);
        double n = (1.0 - 2.0 * base + sqrt) / 2;
        return Math.floor(n) == n ? (int)n : 0;
    }

    public static int test(int N) {
        if (N == 1) return 1;
        if (N == 2) return 1;
        int total = 0;
        List<Integer> values = new ArrayList<>();
        for (int i = N/2+1; i >= 1; i--) {
            int sum = 0;
            for (int j = i; j >= 1; j--) {
                sum += j;
                if (sum >= N) {
                    if (sum == N) {
                        values.add(i);
                        total++;
                    }
                    break;
                }
            }
        }
        System.out.println(values);
        return total+1;
    }

    public static void main(String[] args) {
        //93003
        //System.out.println(solve(68188380));
        //System.out.println(solve(75));
        System.out.println(consecutiveNumbersSum2(72316829));
        //System.out.println(arithmeticSumSize(15, 1));
    }
}
