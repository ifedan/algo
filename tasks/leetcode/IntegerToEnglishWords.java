package tasks.leetcode;

public class IntegerToEnglishWords {

    private static String toString(int i) {
        if (i == 0) return "Zero";
        return intToString(i);
    }

    private static String intToString(int i) {
        if (i < 10) return digitToString(i);
        else if (i >= 10 && i < 20) return teenToString(i);
        else if (i >= 20 && i < 100) {
            int mod = i % 10;
            String v = tyToString(i - mod);
            if (mod > 0) {
                v = v + (" " + digitToString(i % 10));
            }
            return v;
        }
        else if (i >= 100 && i < 1000) {
            int p1 = i / 100;
            int p2 = i % 100;

            String v = digitToString(p1) + " Hundred";
            if (p2 > 0) {
                v = v + (" " + intToString(p2));
            }
            return v;
        } else if (i >= 1000 && i < 1000000) {
            int p1 = i / 1000;
            int p2 = i % 1000;

            String v = intToString(p1) + " Thousand";
            if (p2 > 0) {
                v = v + (" " + intToString(p2));
            }
            return v;
        } else if (i >= 1000000 && i < 1000000000) {
            int p1 = i / 1000000;
            int p2 = i % 1000000;

            String v = intToString(p1) + " Million";
            if (p2 > 0) {
                v = v + (" " + intToString(p2));
            }
            return v;
        } else if (i >= 1000000000) {
            int p1 = i / 1000000000;
            int p2 = i % 1000000000;

            String v = intToString(p1) + " Billion";
            if (p2 > 0) {
                v = v + (" " + intToString(p2));
            }
            return v;
        }

        throw new IllegalArgumentException();
    }

    private static String tyToString(int i) {
        switch (i) {
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
        }
        throw new IllegalArgumentException();
    }

    private static String teenToString(int i) {
        switch (i) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        throw new IllegalArgumentException();
    }

    private static String digitToString(int i) {
        switch (i) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        throw new IllegalArgumentException();
    }

}
