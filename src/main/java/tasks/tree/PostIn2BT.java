package tasks.tree;

public class PostIn2BT {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static Node solve(int[] post, int postLo, int postHi, int[] in, int inLo, int inHi) {
        if (postLo > postHi || inLo > inHi) return null;
        int val = post[postHi];
        int idx = findIn(in, inLo, inHi, val);
        if (idx == -1) throw new IllegalStateException();
        int delta = idx - inLo;
        Node node = new Node();
        node.val = val;
        node.left = solve(post, postLo, postLo+delta, in, inLo, idx-1);
        node.right = solve(post, postLo+delta+1, postHi-1, in, idx+1, inHi);
        return node;
    }

    private static int findIn(int[] a, int lo, int hi, int val) {
        for (int i = lo; i <= hi; i++) {
            if (a[i]==val) return i;
        }
        return -1;
    }

}
