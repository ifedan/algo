package tasks.leetcode;

public class CountingBits {

    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if (num < 1) return res;
        res[1] = 1;
        if (num < 2) return res;

        int pow = 1;
        for (int i = 2; i <= num; i++) {
            if ((i&(i-1)) == 0) {
                pow = pow << 1;
                res[i] = 1;
            } else {
                res[i] = res[i - pow] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        countBits(6);
    }

}
