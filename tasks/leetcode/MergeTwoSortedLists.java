package tasks.leetcode;

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode root = res;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            res = res.next;
        }
        ListNode notEmpty = l1 != null ? l1 : l2;
        while (notEmpty != null) {
            res.next = new ListNode(notEmpty.val);
            res = res.next;
            notEmpty = notEmpty.next;
        }
        return root.next;
    }
}
