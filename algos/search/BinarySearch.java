package algos.search;

public class BinarySearch {

    public static int search(int a[], int val) {
        int start = 0;
        int end = a.length - 1;

        while (start >= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == val) {
                return a[mid];
            } else if (a[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
