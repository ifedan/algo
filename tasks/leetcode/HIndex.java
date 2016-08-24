package tasks.leetcode;

public class HIndex {

    public static int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len+2];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > len) {
                count[len+1]++;
            } else {
                count[citations[i]]++;
            }
        }
        int total = count[count.length-1];
        for (int i = count.length-2; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }

}
