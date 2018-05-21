package tasks.leetcode;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int[] a = new int[height.length];

        a[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            a[i] = Math.max(a[i-1], height[i]);
        }

        a[a.length-1] = height[height.length - 1];
        for (int i = height.length-2; i>=0; i--) {
            a[i] = Math.min(a[i], Math.max(height[i], a[i+1]));
        }

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - height[i]);
        }
        return sum;
    }

}
