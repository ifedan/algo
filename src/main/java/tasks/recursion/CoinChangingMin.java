package tasks.recursion;

public class CoinChangingMin {

    public static int solve(int[] coins, int total, int count) {
        if (total < 0) {
            return Integer.MAX_VALUE;
        }
        if (total == 0) {
            return count;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(min, solve(coins, total-coin, count+1));
        }
        return min;
    }

}
