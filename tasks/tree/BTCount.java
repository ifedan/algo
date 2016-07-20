package tasks.tree;

public class BTCount {

    public static int solve(int n) {
        int[] t = new int[n+1];
        t[0] = 1;
        t[1] = 1;

        for (int i = 2; i < t.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += t[i]*t[i-j-1];
            }
            t[i] = sum;
        }
        return t[n];
    }

}
