package tasks.leetcode;

public class UglyNumber {

    public boolean isUgly(int num) {
        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }
            if (num % 3 == 0) {
                num = num / 3;
                continue;
            }
            if (num % 5 == 0) {
                num = num / 5;
                continue;
            }
            break;
        }
        return num == 1;
    }

}
