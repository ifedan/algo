package tasks.leetcode;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        s = s.toLowerCase();
        int res = 0;
        int mult = 1;
        for (int i = s.length()-1; i>=0; i--) {
            res += mult * (s.charAt(i)-'a'+1);
            mult *= 26;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(titleToNumber("zz"));
    }
}
