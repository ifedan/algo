package tasks.leetcode;

public class ShiftingLetters {
    public static String shiftingLetters(String S, int[] shifts) {
        long total = 0;
        for (int shift : shifts) {
            total += shift;
        }
        char[] result = new char[S.length()];
        for (int i = 0; i < S.length(); i++) {
            result[i] = (char)('a' + (int)((total + S.charAt(i) - 'a') % 26));
            total -= shifts[i];
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String res = shiftingLetters("abc", new int[]{3,5,9});
        System.out.println(res);
    }
}
