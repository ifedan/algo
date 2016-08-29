package tasks.leetcode;

public class RangeSumQueryMutable {

    public static class NumArray {

        int[] nums;
        int[] segments;

        public NumArray(int[] nums) {
            this.nums = nums;
            int size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) nums.length) / Math.log(2.0)) + 1)));
            this.segments = new int[size];
            if (nums.length > 0) {
                createTree(0, nums.length - 1, 0);
            }
        }

        private int createTree(int lo, int hi, int pos) {
            if (lo == hi) {
                segments[pos] = nums[lo];
                return segments[pos];
            }
            int mid = (hi-lo)/2+lo;
            segments[pos] = createTree(lo, mid, 2*pos+1) + createTree(mid+1, hi, 2*pos+2);
            return segments[pos];
        }

        void update(int i, int val) {
            int diff = val - nums[i];
            update(0, nums.length-1, i, 0, diff);
            nums[i] = val;
        }

        private void update(int lo, int hi, int index, int pos, int diff) {
            if (lo > index || hi < index)  {
                return;
            }
            segments[pos] += diff;
            if (lo >= hi) {
                return;
            }

            int mid = (hi-lo)/2+lo;
            update(lo, mid, index, 2*pos+1, diff);
            update(mid+1, hi, index, 2*pos+2, diff);
        }

        public int sumRange(int i, int j) {
            return query(i, j, 0, nums.length-1, 0);
        }

        private int query(int qlo, int qhi, int lo, int hi, int pos) {
            if (qlo <= lo && qhi >= hi) {
                return segments[pos];
            }
            if (qlo > hi || qhi < lo) {
                return 0;
            }
            int mid = (hi-lo)/2+lo;
            return query(qlo, qhi, lo, mid, 2*pos+1) + query(qlo, qhi, mid+1, hi, 2*pos+2);
        }
    }

    public static void main(String[] args) {
        NumArray arr = new NumArray(new int[]{1, 3, 5});
        arr.sumRange(0, 2);
        arr.update(1, 2);
        arr.sumRange(0, 2);
    }

}
