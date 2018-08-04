package tasks.leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] a, int target) {
        if (a.length == 0) return -1;
        if (a[0] < a[a.length - 1]) return binarySearch(a, 0, a.length-1, target);
        int pivot = findPivot(a, 0, a.length-1);
        if (a[pivot] == target) return pivot;
        int x1 = binarySearch(a, 0, pivot-1, target);
        if (x1 >= 0) return x1;
        return binarySearch(a, pivot + 1, a.length-1, target);
    }

    public int findPivot(int[] a, int l, int r) {
        if (l > r) return -1;
        if (l == r) return l;
        int mid = (r - l) / 2 + l;
        if (mid > l && a[mid] < a[mid-1]) return mid-1;
        if (mid < r && a[mid] > a[mid+1]) return mid;
        if (a[l] >= a[mid]) return findPivot(a, l, mid-1);
        else return findPivot(a, mid+1, r);
    }

    public int binarySearch(int[] a, int l, int r, int target) {
        while (l <= r) {
            int mid = (r-l)/2 + l;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
