package algos.string;

public class Manacher {

    public static int[] solve(String str) {
        //@#a#a#b#b#$
        char[] input = new char[2*str.length() + 3];
        int k = 0;
        for (int j = 1; j < input.length-1; j++) {
            if (j % 2 == 0) {
                input[j] = str.charAt(k++);
            } else {
                input[j] = '#';
            }
        }
        input[0] = '@';
        input[input.length-1] = '$';

        int[] t = new int[input.length];
        int center = 0;
        int right = 0;

        for (int i = 1; i < t.length-1; i++) {
            int mirror = center - (i-center); //...mirror...center...i.....right
            if (right > i) {
                t[i] = Math.min(right-i, t[mirror]);
            }

            while(input[i+(1+t[i])] == input[i-(1+t[i])]) {
                t[i]++;
            }

            if (i + t[i] > right) {
                center = i;
                right = t[i] + i;
            }
        }

        return t;
    }

}
