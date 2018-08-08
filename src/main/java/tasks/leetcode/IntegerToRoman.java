package tasks.leetcode;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();

        if (num >= 1000) {
            append(sb, 'M', num/1000);
        }

        num = num % 1000;

        if (num >= 900) {
            sb.append("CM");
        } else if (num >= 500) {
            sb.append('D');
            append(sb, 'C', num/100 - 5);
        } else if (num >= 400) {
            sb.append("CD");
        } else if (num >= 100) {
            append(sb, 'C', num/100);
        }

        num = num % 100;

        if (num >= 90) {
            sb.append("XC");
        } else if (num >= 50) {
            sb.append('L');
            append(sb, 'X', num/10 - 5);
        } else if (num >= 40) {
            sb.append("XL");
        } else if (num >= 10) {
            append(sb, 'X', num/10);
        }

        num = num % 10;

        if (num >= 9) {
            sb.append("IX");
        } else if (num >= 5) {
            sb.append('V');
            append(sb, 'I', num - 5);
        } else if (num >= 4) {
            sb.append("IV");
        } else {
            append(sb, 'I', num);
        }

        return sb.toString();
    }

    private static void append(StringBuffer sb, char c, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
