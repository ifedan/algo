package tasks.leetcode;

public abstract class FirstBadVersion {

    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int min = n;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (isBadVersion(mid)){
                min = Math.min(min, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return min;
    }

    public abstract boolean isBadVersion(int v);

}
