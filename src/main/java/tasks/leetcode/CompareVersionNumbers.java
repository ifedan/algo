package tasks.leetcode;

public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        java.util.StringTokenizer st1 = new java.util.StringTokenizer(version1, ".");
        java.util.StringTokenizer st2 = new java.util.StringTokenizer(version2, ".");

        while (st1.hasMoreTokens() && st2.hasMoreTokens()) {
            String s1 = st1.nextToken();
            String s2 = st2.nextToken();
            long i1 = Long.parseLong(s1);
            long i2 = Long.parseLong(s2);
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
        }

        if (!st1.hasMoreTokens() && !st2.hasMoreTokens()) return 0;

        if (st1.hasMoreTokens()) return checkIfAllZero(st1) ? 0 : 1;

        return checkIfAllZero(st2) ? 0 : -1;
    }

    public static boolean checkIfAllZero(java.util.StringTokenizer st) {
        while (st.hasMoreTokens()) {
            if (Long.parseLong(st.nextToken()) != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        compareVersion("1", "1.1");
    }
}
