package tasks.misc;

public class StaircaseProblem {

    public static int solve(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        return solve(n-1) + solve(n-2);
    }

}
