package tasks.string;

public class KMP {

    private static int[] getPrefixMatrix(String prefix) {
        int[] m = new int[prefix.length()];
        int i = 1;
        int j = 0;
        while (i < prefix.length()) {
            if (prefix.charAt(i) == prefix.charAt(j)) {
                m[i] = j+1;
                i++;
                j++;
            } else {
                if (j!=0) {
                    j = m[j-1];
                } else {
                    m[i]=0;
                    i++;
                }
            }
        }
        return m;
    }

    public static int substring(String str, String prefix) {
        int[] m = getPrefixMatrix(prefix);
        int i = 0;
        int j = 0;
        while (i < str.length() && j < prefix.length()) {
            if (str.charAt(i) == prefix.charAt(j)) {
                i++;
                j++;
            } else {
                if (j!=0) {
                    j = m[j-1];
                } else {
                    i++;
                }
            }
        }

        if (j != prefix.length()) {
            return -1;
        }
        return i - prefix.length();
    }
}
