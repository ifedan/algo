package datastructures;

public class SegmentTree {

    private int[] segments;
    private int[] data;

    public SegmentTree(int[] data) {
        this.data = data;

        //2*2^log2n - 1
        int size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) data.length) / Math.log(2.0)) + 1)));

        this.segments = new int[size];
        if (data.length > 0) {
            createTree(0, data.length-1, 0);
        }
    }

    private int createTree(int lo, int hi, int pos) {
        if (lo == hi) {
            segments[pos] = data[lo];
            return segments[pos];
        }
        int mid = (hi-lo)/2 + lo;
        segments[pos] = createTree(lo, mid, 2*pos+1) + createTree(mid+1, hi, 2*pos+2);

        return segments[pos];
    }

    public int rangeQuery(int qlo, int qhi) {
        return rangeQuery(qlo, qhi, 0, data.length-1, 0);
    }

    public void update(int index, int val) {
        int diff = val - data[index];
        data[index] = val;
        update(index, diff, 0, data.length-1, 0);
    }

    private int rangeQuery(int qlo, int qhi, int lo, int hi, int pos) {
        if (qhi >= hi && qlo <= lo) {
            return segments[pos];
        }
        if(qhi < lo || qlo > hi) {
            return 0;
        }
        int mid = (hi-lo)/2+lo;
        return rangeQuery(lo, mid, qlo, qhi, 2*pos+1) + rangeQuery(mid+1, hi, qlo, qhi, 2*pos+2);
    }

    private void update(int index, int diff, int lo, int hi, int pos) {
        if (index < lo || index > hi) {
            return;
        }
        segments[pos] += diff;
        if (lo >= hi) {
            return;
        }
        int mid = (hi-lo)/2 + lo;
        update(index, diff, lo, mid, 2*pos+1);
        update(index, diff, mid+1, hi, 2*pos+2);
    }


}
