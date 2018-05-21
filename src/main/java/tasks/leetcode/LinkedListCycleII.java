package tasks.leetcode;

public class LinkedListCycleII {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //find circle
        while (fast != null && slow != null) {
            if (fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null) return null;

        //find circle len
        fast = fast.next;
        int len = 0;
        while (fast != slow) {
            fast = fast.next;
            len++;
        }
        if (len == 0) return fast;

        //start fast and wait it will go len steps then start slow
        fast = head;
        while (len >= 0) {
            fast = fast.next;
            len--;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
