package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
        /*TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t3.left = t5;
        t3.right = t1;
        t1.left = t0;
        t1.right = t8;
        t5.left = t6;
        t5.right = t2;
        t2.left = t7;
        t2.right = t4;*/

        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t0.left = t1;
        t1.right = t2;
        t2.right = t3;
        t3.right = t4;

        distanceK(t0, t3, 0);
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Set<Integer> set = new HashSet<>();
        find(root, target.val, K, set);
        return new ArrayList<>(set);
    }

    static void bfs(TreeNode root, int path, int maxPath, Set<Integer> nodes) {
        if (root == null) return;
        if (path == maxPath) {
            nodes.add(root.val);
            return;
        }
        if (path > maxPath) {
            return;
        }
        bfs(root.left, path+1, maxPath, nodes);
        bfs(root.right, path+1, maxPath, nodes);
    }

    static int find(TreeNode root, int target, int maxPath, Set<Integer> nodes) {
        if (root == null) return -1;
        if (root.val == target) {
            bfs(root, 0, maxPath, nodes);
            return 1;
        }

        int left = find(root.left, target, maxPath, nodes);
        if (left > 0 && left < maxPath) {
            bfs(root.right, 1, maxPath-left, nodes);
        }
        int right = find(root.right, target, maxPath, nodes);
        if (right > 0 && right < maxPath) {
            bfs(root.left, 1, maxPath-right, nodes);
        }
        if (left == maxPath || right == maxPath) {
            nodes.add(root.val);
        }
        return left > 0 ? left + 1 : (right > 0 ? right + 1 : -1);
    }
}
