package tasks.leetcode;

public class PushDominoes {
    public static String pushDominoes(String dominoes) {
        String str = 'L' + dominoes + 'R';
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str.length()) {
            if (str.charAt(i) == 'L' || str.charAt(i) == 'R') {
                sb.append(str.charAt(i));
                i++;
            } else { //char == '.'
                int j = i;
                while (j < str.length() && str.charAt(j) != 'L' && str.charAt(j) != 'R') {
                    j++;
                }
                if (str.charAt(i - 1) == str.charAt(j)) {
                    for (; i<j; i++) {
                        sb.append(str.charAt(j));
                    }
                } else if (str.charAt(i - 1) == 'L' && str.charAt(j) == 'R') {
                    for (; i<j; i++) {
                        sb.append('.');
                    }
                } else {
                    int len = j - i;
                    for (int k = 0; k < len/2; k++) {
                        sb.append('R');
                    }
                    if (len % 2 == 1) sb.append('.');
                    for (int k = 0; k < len/2; k++) {
                        sb.append('L');
                    }
                    i = j;
                }
            }
        }

        return sb.toString().substring(1, sb.length()-1);
    }

    public static void main(String[] args) {
        pushDominoes(".L.R...LR..L..");
    }
}
