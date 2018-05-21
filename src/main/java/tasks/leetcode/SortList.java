package tasks.leetcode;

public class SortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        int len = 1;
        while(fast != null) {
            fast = fast.next;
            if (fast != null) {
                len++;
            } else {
                break;
            }
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
                if (fast != null) len++;
            }
        }

        if (len == 1) {
            head.next = null;
            return head;
        }

        if (len == 2) {
            ListNode small = null;
            ListNode large = null;

            if (head.val > head.next.val) {
                small = head.next;
                large = head;
            } else {
                small = head;
                large = head.next;
            }

            small.next = large;
            large.next = null;
            return small;
        }

        ListNode next = slow.next;
        slow.next = null;

        ListNode first = sortList(head);
        ListNode second = sortList(next);
        ListNode current = new ListNode(-1);
        ListNode root = current;
        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
                current.next.next = null;
                current = current.next;
            } else {
                current.next = second;
                second = second.next;
                current.next.next = null;
                current = current.next;
            }
        }
        if (first != null) {
            current.next = first;
        } else if (second != null) {
            current.next = second;
        }
        return root.next;
    }

}
