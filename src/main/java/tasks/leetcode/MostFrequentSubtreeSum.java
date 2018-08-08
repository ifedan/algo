package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int v) {
            this.val = v;
        }
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        Map<Integer, Integer> counter = new HashMap<>();
        findFrequentTreeSum(root, counter);
        int max = 0;
        for (int count : counter.values()) {
            max = Math.max(max, count);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        int[] output = new int[result.size()];
        for (int i = 0; i <result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }

    public int findFrequentTreeSum(TreeNode root, Map<Integer, Integer> counter) {
        if (root.left == null && root.right == null) {
            counter.merge(root.val, 1, (val, acc) -> val + acc);
            return root.val;
        }
        int left = 0;
        if (root.left != null) {
            left = findFrequentTreeSum(root.left, counter);
        }
        int right = 0;
        if (root.right != null) {
            right = findFrequentTreeSum(root.right, counter);
        }
        counter.merge(root.val + left + right, 1, (val, acc) -> val + acc);
        return root.val + left + right;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(-5);
        t1.left = t2;
        t1.right = t3;

        MostFrequentSubtreeSum t = new MostFrequentSubtreeSum();
        t.findFrequentTreeSum(t1);
    }
}
