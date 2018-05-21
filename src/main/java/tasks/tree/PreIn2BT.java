package tasks.tree;

public class PreIn2BT {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static Node solve(int[] pre, int preLo, int preHi, int[] in, int inLo, int inHi) {
        if (preLo > preHi || inLo > inHi) return null;
        int val = pre[preLo];
        int idx = findIn(in, inLo, inHi, val);
        if (idx == -1) throw new IllegalStateException();
        int delta = idx - inLo;
        Node node = new Node();
        node.val = val;
        node.left = solve(pre, preLo+1, preLo+delta, in, inLo, idx-1);
        node.right = solve(pre, preLo+delta+1, preHi, in, idx+1, inHi);
        return node;
    }

    private static int findIn(int[] a, int lo, int hi, int val) {
        for (int i = lo; i <= hi; i++) {
            if (a[i]==val) return i;
        }
        return -1;
    }

}
