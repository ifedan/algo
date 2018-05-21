package tasks.leetcode;

import java.util.Arrays;

public class MostProfitAssigningWork {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] diffAndProfit = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            diffAndProfit[i][0] = difficulty[i];
            diffAndProfit[i][1] = profit[i];
        }
        Arrays.sort(diffAndProfit, (a,b) -> a[0]-b[0]);
        for (int i = 1; i < diffAndProfit.length; i++) {
            if (diffAndProfit[i][1] < diffAndProfit[i-1][1]) {
                diffAndProfit[i][1] = diffAndProfit[i-1][1];
            }
        }
        for (int i = diffAndProfit.length - 1; i >0; i--) {
            if (diffAndProfit[i][0] == diffAndProfit[i-1][0]) {
                diffAndProfit[i-1][1] = diffAndProfit[i][1];
            }
        }
        int sum = 0;
        for (int i = 0; i < profit.length; i++) {
            sum += binarySearch(diffAndProfit, worker[i]);
        }
        return sum;
    }

    private static int binarySearch(int[][] arr, int val) {
        int l = 0;
        int r = arr.length - 1;
        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid][0] > val) {
                r = mid - 1;
            } else if (arr[mid][0] < val) {
                l = mid + 1;
            } else if (arr[mid][0] == val){
                return arr[mid][1];
            }
        }
        return (r >= 0) ? arr[r][1] : 0;
    }

    public static void main(String[] args) {
        int[] difficulty = new int[]{23,30,35,35,43,46,47,81,83,98};
        int[] profit =     new int[]{8, 11,11,20,33,37,60,72,87,95};
        int[] worker = new int[]{95,46,47,97,11,35,99,56,41,92};
        maxProfitAssignment(difficulty, profit, worker);
    }
}
