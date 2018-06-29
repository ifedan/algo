package tasks.leetcode;

public class MirrorReflection {
    public static int mirrorReflection(int p, int q) {
        int gcd = gcd(p, q);
        p = p / gcd;
        q = q / gcd;
        boolean top = q % 2 != 0;
        boolean left = p % 2 == 0;
        return top ? left ? 2 : 1 : 0;
    }

    private static int gcd(int a, int b) {
        return (b==0) ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        mirrorReflection(2, 1);
    }
}
