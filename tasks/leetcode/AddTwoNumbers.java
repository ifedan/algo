package tasks.leetcode;

public class AddTwoNumbers {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode sum(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode root = result;
        boolean extra = false;
        while (l1 != null && l2 != null) {
            result.next = new ListNode(l1.val + l2.val + (extra ? 1 : 0));
            extra = false;
            if (result.next.val >= 10) {
                result.next.val = result.next.val - 10;
                extra = true;
            }
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l = l1 != null ? l1 : l2;
        while (l != null) {
            result.next = new ListNode(l.val + (extra ? 1 : 0));
            extra = false;
            if (result.next.val >= 10) {
                result.next.val = result.next.val - 10;
                extra = true;
            }
            result = result.next;
            l = l.next;
        }
        if (extra) {
            result.next = new ListNode(1);
        }
        return root.next;
    }

}
