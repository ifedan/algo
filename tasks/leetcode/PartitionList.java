package tasks.leetcode;

public class PartitionList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode moreRoot = more;
        ListNode lessRoot = less;

        while (head != null) {
            if (head.val >= x) {
                more.next = head;
                head = head.next;
                more.next.next = null;
                more = more.next;
            } else {
                less.next = head;
                head = head.next;
                less.next.next = null;
                less = less.next;
            }
        }

        less.next = moreRoot.next;
        return lessRoot.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(1);
        partition(l1, 1);
    }

}
