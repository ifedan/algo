package tasks.leetcode;

public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //revert
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //merge
        ListNode first = head;
        ListNode second = prev;
        ListNode firstNext = null;
        ListNode secondNext = null;
        while (first != null && second != null) {
            firstNext = first.next;
            secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }

        if (first != null) {
            first.next = null;
        }

    }

}
