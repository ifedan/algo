package tasks.leetcode;

public class MaskingPersonalInformation {
    public static String maskPII(String S) {
        int atIndex = S.indexOf("@");
        return atIndex >= 0 ? maskEmail(S, atIndex) : maskPhone(S);
    }

    private static String maskEmail(String S, int atPos) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(S.charAt(0)));
        sb.append("*****");
        if (atPos > 1) {
            sb.append(Character.toLowerCase(S.charAt(atPos-1)));
        }
        sb.append(S.substring(atPos).toLowerCase());
        return sb.toString();
    }

    private static String maskPhone(String S) {
        char[] last4 = new char[4];
        int last4Inx = 3;
        int totalCount = 0;
        for (int i = S.toCharArray().length - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                if (last4Inx >= 0) {
                    last4[last4Inx] = c;
                    last4Inx--;
                }
                totalCount++;
            }
        }
        if (totalCount == 10) {
            return "***-***-" + new String(last4);
        } else if (totalCount == 11) {
            return "+*-***-***-" + new String(last4);
        } else if (totalCount == 12) {
            return "+**-***-***-" + new String(last4);
        } else {
            return "+***-***-***-" + new String(last4);
        }
    }
}
