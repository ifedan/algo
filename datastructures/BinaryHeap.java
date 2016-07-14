package datastructures;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class BinaryHeap {

    private int[] a;
    private int size;

    public BinaryHeap() {
        a = new int[100];
        size = 0;
    }

    public void add(int key) {
        //resize
        a[size++] = key;
        swim(size);
    }

    public int remove() {
        int val = a[0];
        size--;
        a[0] = a[size];
        sink(1);
        //resize
        return val;
    }

    private void swim(int p) {
        while (p > 1 && a[p-1] > a[p/2-1]) {
            int tmp = a[p-1];
            a[p-1] = a[(p/2)-1];
            a[(p/2)-1] = tmp;
            p = p/2;
        }
    }

    private void sink(int p) {
        while (2*p <= size) {
            int c = 2*p;
            if (c < size && a[c-1] < a[c]) c++;
            if (!(a[p-1] < a[c-1])) break;
            a[c-1] = a[c-1]^a[p-1];
            a[p-1] = a[c-1]^a[p-1];
            a[c-1] = a[c-1]^a[p-1];
            p = c;
        }
    }

}
