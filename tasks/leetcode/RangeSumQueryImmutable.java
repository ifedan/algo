package tasks.leetcode;

public class RangeSumQueryImmutable {

    public static class NumArray {

        int[] nums;
        int[] segements;

        public NumArray(int[] nums) {
            this.nums = nums;
            int size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) nums.length) / Math.log(2.0)) + 1)));
            this.segements = new int[size];
            if (nums.length > 0) {
                createTree(0, nums.length - 1, 0);
            }
        }

        private int createTree(int lo, int hi, int pos) {
            if (lo == hi) {
                segements[pos] = nums[lo];
                return segements[pos];
            }
            int mid = (hi-lo)/2 + lo;
            segements[pos] = createTree(lo, mid, 2*pos+1) + createTree(mid+1, hi, 2*pos+2);

            return segements[pos];
        }

        public int sumRange(int i, int j) {
            return query(i, j, 0, nums.length-1, 0);
        }

        private int query(int qlo, int qhi, int lo, int hi, int pos) {
            if (qlo <= lo && qhi >= hi) {
                return segements[pos];
            }
            if (qlo > hi || qhi < lo) {
                return 0;
            }
            int mid = (hi-lo)/2 + lo;
            return query(qlo, qhi, lo, mid, 2*pos+1) + query(qlo, qhi, mid+1, hi, 2*pos+2);
        }
    }

    public static void main(String[] args) {
        NumArray arr = new NumArray(new int[]{-2,0,3,-5,2,-1});
        arr.sumRange(2, 5);
        System.out.println();
    }

}
