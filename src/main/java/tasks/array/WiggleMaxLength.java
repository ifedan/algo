package tasks.array;

public class WiggleMaxLength {

    public static int solve(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 2) return 1;
        int pos[] = new int[nums.length];
        int neg[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pos[i] = 1;
            neg[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    pos[i] = Math.max(pos[i], neg[j] + 1);
                } else if (nums[i] < nums[j]) {
                    neg[i] = Math.max(neg[i], pos[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pos.length; i++) {
            max = Math.max(max, Math.max(pos[i], neg[i]));
        }
        return max;
    }
}
