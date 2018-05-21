package tasks.leetcode;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxSum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxSum += (prices[i] - prices[i-1]);
            }
        }
        return maxSum;
    }

}
