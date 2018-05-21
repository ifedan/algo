package tasks.leetcode;

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int val = n%26;
            if (val == 0) {
                val = 26;
            }
            char next = Character.toChars(64 + val)[0];
            sb.insert(0, next);
            n -= val;
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(702));
    }

}
