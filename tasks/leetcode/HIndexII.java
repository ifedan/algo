package tasks.leetcode;

public class HIndexII {

    public static int hIndexII(int[] citations) {
        if (citations.length == 0) return 0;
        if (citations.length == 1) {
            return citations[0] == 0 ? 0 : 1;
        }
        int lo = 0;
        int hi = citations.length - 1;
        int res = Integer.MIN_VALUE;
        while (lo <= hi) {
            int mid = (hi-lo)/2 + lo;
            int val = citations.length - mid;
            if (citations[mid] == val) {
                return citations[mid];
            } else if (citations[mid] < val) {
                lo = mid + 1;
                res = Math.max(res, citations[mid]);
            } else {
                hi = mid - 1;
                res = Math.max(res, val);
            }
        }
        return res;
    }


}
