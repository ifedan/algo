package tasks.leetcode;

public class New21Game {
    public static double new21Game(int N, int K, int W) {
        if (K == 0) return 1;
        int maxSum = K - 1 + W; //if we in position K-1 and we got the most value W

        double[] dp = new double[maxSum + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= maxSum; sum++) {
            int card = 1;
            int prevSum = sum - card;
            while (prevSum >= 0 && card <= W) {
                if (prevSum < K) { //prevSum can not be more then K otherwise we had to stop
                    dp[sum] += (dp[prevSum] / W); //probability to get sum using card = previous sum * probability of the card (1/w)
                }
                card++;
                prevSum = sum - card;
            }
        }

        double result = 0;
        for (int i = K; i <= N; i++) {
            result += dp[i];
        }

        return result;

    }

    public static void main(String[] args) {
        new21Game(21, 17, 10);
    }
}
