package tasks.leetcode;

public class ConvertSortedArrayToBinarySearchTree {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        if (lo == hi) return new TreeNode(nums[lo]);

        int mid = (hi-lo)/2+lo;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, lo, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, hi);
        return node;

    }

}
