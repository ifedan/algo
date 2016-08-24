package tasks.leetcode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxSum = 0;
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[index]) {
                index = i;
            }
            maxSum = Math.max(maxSum, prices[i] - prices[index]);
        }
        return maxSum;
    }

}
