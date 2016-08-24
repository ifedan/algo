package tasks.leetcode;

public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    public static boolean isPrime(int k) {
        if (k <= 1) return false;
        for (int i = 2; i*i <= k; i++) {
            if (k%i == 0) return false;
        }
        return true;
    }

}
