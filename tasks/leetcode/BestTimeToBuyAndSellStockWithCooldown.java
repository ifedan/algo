package tasks.leetcode;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static int maxProfit(int[] prices) {
        int maxProfitIfSell = 0;
        int maxProfitIfNotSell = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = maxProfitIfSell;
            maxProfitIfSell = Math.max(maxProfitIfNotSell, maxProfitIfSell + (prices[i] - prices[i-1]));
            maxProfitIfNotSell = Math.max(maxProfitIfNotSell, temp);
        }
        return Math.max(maxProfitIfSell, maxProfitIfNotSell);
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1,2,3,0,2});
    }

}
