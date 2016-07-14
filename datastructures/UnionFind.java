package algos;

public class QuickUF {

    private int[] tree;
    private int[] weights;
    private int count;

    public QuickUF(int size) {
        tree = new int[size];
        weights = new int[size];
        for (int i = 0; i < size; i++) {
            tree[i] = i;
            weights[i] = 1;
        }
        count = size;
    }

    public boolean connected(int i, int j) {
        return (i == j) || (findRoot(i) == findRoot(j));
    }
    
    public int count() {
        return count;
    }

    public void union(int i, int j) {
        if (i == j) {
            return;
        }
        
        int rootI = findRoot(i);
        int rootJ = findRoot(j);

        if (rootI == rootJ) {
            return;
        }

        if (weights[rootI] > weights[rootJ]) {   //TODO: ADD SMALL TO LARGE
            tree[rootJ] = rootI;
            weights[rootI] += weights[rootJ];
            compress(j, rootI);
        } else {
            tree[rootI] = rootJ;
            weights[rootJ] += weights[rootI];
            compress(i, rootJ);
        }
        count--;
    }

    private int findRoot(int x) {
        while (tree[x] != x) {
            x = tree[x];
        }
        return x;
    }

    private void compress(int i, int newParent) {
        while (i != data[i]) {
            int parent = data[i];
            data[i] = newParent;
            i = parent;
        }
    }

}
