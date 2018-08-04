package tasks.leetcode;

public class ZigZagConversion {

    public static String zigzag(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                sb[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j >= 1 && i < s.length(); j--) {
                sb[j].append(s.charAt(i++));
            }
        }

        for (int j = 1; j < numRows; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        zigzag("PAYPALISHIRING", 4);
    }

}
