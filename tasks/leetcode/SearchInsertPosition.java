package tasks.leetcode;

public class SearchInsertPosition {

    public static int searchInsert(int[] a, int val) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (hi-lo)/2 + lo;
            if (a[mid] == val) {
                return mid;
            } else if (a[mid] > val){
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }

        return lo;
    }

}
