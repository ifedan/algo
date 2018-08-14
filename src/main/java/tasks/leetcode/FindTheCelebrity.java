package tasks.leetcode;

public class FindTheCelebrity {

    public static int findCelebrity(int n) {
        boolean[] vertical = new boolean[n];
        boolean[] horizontal = new boolean[n];
        for (int i = 0; i< n; i++) {
            horizontal[i] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                boolean iKnowsJ = knows(i, j);
                vertical[i] = vertical[i] | iKnowsJ;
                horizontal[j] = horizontal[j] & iKnowsJ;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vertical[i] && horizontal[i]) {
                return i;
            }
        }
        return -1;
    }

    public int findCelebrity2(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }

    private static boolean knows(int a, int b) {
        return false;
    }
}
