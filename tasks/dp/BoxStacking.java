package tasks.dp;

import java.util.Arrays;

public class BoxStacking {

    static class Box implements Comparable<Box> {
        int l, w, h;
        int area;
        Box(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
            this.area = l*w;
        }

        @Override
        public int compareTo(Box o) {
            return o.area - area;
        }

        boolean canStackOnTop(Box box) {
            return l < box.l && w < box.w;
        }
    }

    public static int solve(Box[] boxes) {
        Arrays.sort(boxes);
        int[] dp = new int[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            dp[i] = boxes[i].h;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[i].canStackOnTop(boxes[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i].h);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int val : dp) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solve(new Box[]{
                new Box(5, 3, 2),
                new Box(5, 2, 3),
                new Box(4, 2, 1),
                new Box(3, 2, 5),
                new Box(4, 1, 2),
                new Box(2, 1, 4)
        }));
    }

}
