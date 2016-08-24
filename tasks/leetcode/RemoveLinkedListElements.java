package tasks.leetcode;

public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            if (curr.val == val) {
                prev.next = next;
                curr = next;
            } else {
                prev = curr;
                curr = next;
            }
        }
        return head;
    }


}
