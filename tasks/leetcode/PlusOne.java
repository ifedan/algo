package tasks.leetcode;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        int[] result = new int[digits.length];

        boolean extra = false;
        for (int i = digits.length-1; i >= 0; i--) {
            if (i == digits.length-1 || extra) {
                int sum = digits[i] + 1;
                if (sum >= 10) {
                    result[i] = sum % 10;
                    extra = true;
                } else {
                    result[i] = sum;
                    extra = false;
                }
            } else {
                result[i] = digits[i];
            }
        }

        int largeResult[] = null;
        if (extra) {
            largeResult = new int[digits.length+1];
            System.arraycopy(result, 0, largeResult, 1, result.length);
            largeResult[0] = 1;
        }
        return extra ? largeResult : result;
    }

    public static void main(String[] args) {
        plusOne(new int[]{9});
    }

}
