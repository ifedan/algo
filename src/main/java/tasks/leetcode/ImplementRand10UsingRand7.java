package tasks.leetcode;

public class ImplementRand10UsingRand7 {
    public int rand10() {
        int i = 7*rand7() + rand7() - 7;
        if (i <= 40) {
            return i%10 + 1;
        }
        return rand10();
    }

    public int rand7() {
        return 0;
    }
}
