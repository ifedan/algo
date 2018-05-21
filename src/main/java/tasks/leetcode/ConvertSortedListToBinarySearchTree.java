package tasks.leetcode;

public class ConvertSortedListToBinarySearchTree {

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

    public static TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode node = head;
        while(node != null) {
            node = node.next;
            size++;
        }
        if (size == 0) return null;
        return sortedListToBST(head, 0, size-1);
    }

    public static TreeNode sortedListToBST(ListNode head, int lo, int hi) {
        if (lo > hi) return null;
        if (head == null) return null;
        if (lo == hi) return new TreeNode(head.val);

        int mid = (hi-lo)/2+lo;
        int i = lo;
        ListNode lnode = head;
        while (i < mid) {
            lnode= lnode.next;
            i++;
        }
        TreeNode node = new TreeNode(lnode.val);
        node.left = sortedListToBST(head, lo, mid-1);
        node.right = sortedListToBST(lnode.next, mid+1, hi);
        return node;
    }
}
