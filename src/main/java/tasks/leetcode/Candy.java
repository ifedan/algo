package tasks.leetcode;

public class Candy {

    public static int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        int[] result = new int[ratings.length];
        result[0] = ratings[0] > ratings[1] ? 2 : 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            } else {
                result[i] = 1;
            }
        }
        for (int i = ratings.length-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1] && result[i] <= result[i+1]) {
                result[i] = result[i+1]+1;
            }
        }

        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        return sum;
    }

}
