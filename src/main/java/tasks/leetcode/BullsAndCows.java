package tasks.leetcode;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int i = 0;
        int j = 0;
        int[] sec = new int[10];
        int[] gue = new int[10];
        int bulls = 0;
        while (i < secret.length() && j < guess.length()) {
            if (secret.charAt(i) == guess.charAt(j)) bulls++;
            else {
                sec[secret.charAt(i) - '0']++;
                gue[guess.charAt(j) - '0']++;
            }
            i++;
            j++;
        }
        int cows = 0;
        for (i = 0; i < 10; i++) {
            if (sec[i] > 0 && gue[i] > 0) cows += Math.min(sec[i], gue[i]);
        }
        return bulls+"A"+cows+"B";
    }

}
