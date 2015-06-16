package algos;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class QuickUF {

    int[] tree;
    int[] weights;

    public QuickUF(int size) {
        tree = new int[size];
        weights = new int[size];
        for (int i = 0; i < size; i++) {
            tree[i] = i;
            weights[i] = 1;
        }
    }

    public boolean connected(int i, int j) {
        return findRoot(i) == findRoot(j);
    }

    public void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);

        if (rootI == rootJ) {
            return;
        }

        if (weights[rootI] > weights[rootJ]) {   //TODO: ADD SMALL TO LARGE
            tree[rootJ] = rootI;
            weights[rootI] = weights[rootJ] + weights[rootI];
        } else {
            tree[rootI] = rootJ;
            weights[rootJ] = weights[rootJ] + weights[rootI];
        }
    }

    private int findRoot(int x) {
        while (tree[x] != x) {
            x = tree[x];
        }
        return x;
    }


}
