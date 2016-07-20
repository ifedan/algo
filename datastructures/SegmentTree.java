package datastructures;

public class SegmentTree {

    private int[] segments;
    private int[] data;

    public SegmentTree(int[] data) {
        this.data = data;
        int size = 0; //2*2^log2n - 1

    }

    private void createTree(int lo, int hi, int pos) {
        if (lo == hi) {
            segments[pos] = data[lo];
            return;
        }
        int mid = (hi-lo)/2+lo;
        createTree(lo, mid, 2*pos+1);
        createTree(mid+1, hi, 2*pos+2);
        segments[pos] = segments[2*pos+1] + segments[2*pos+2];
    }

    public int rangeQuery(int qlo, int qhi) {
        return rangeQuery(qlo, qhi, 0, data.length-1, 0);
    }

    public void update(int index, int val) {
        int diff = val - data[index];
        data[index] = val;
        update(index, diff, 0, data.length, 0);
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
