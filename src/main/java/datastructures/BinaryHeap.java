package datastructures;

public class BinaryHeap {

    private int[] a = new int[100];
    private int size;


    public void insert(int val) {
        size++;
        a[size] = val;
        swim(size);
    }

    public int delete() {
        int val = a[1];
        a[1] = a[size];
        size--;
        sink(1, size);
        return val;
    }

    private void swim(int c) {
        while (c > 1 && operation(a[c], a[c/2])) {
            swap(c, c/2);
            c = c/2;
        }
    }

    private void sink(int p, int n) {
        int left, right, pivot;
        while ((left = 2*p) <= n) {
            right = left+1;
            if (left <= n && operation(a[left], a[p])) pivot = left;
            else pivot = p;
            if (right <= n && operation(a[right], a[pivot])) pivot = right;
            if (pivot == p) break;
            swap(p, pivot);
            p = pivot;
        }
    }

    private boolean operation(int a, int b) {
        return a > b;
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
