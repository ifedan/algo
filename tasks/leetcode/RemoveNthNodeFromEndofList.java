package tasks.leetcode;

public class RemoveNthNodeFromEndofList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNode(ListNode head, int n) {
        int i = 1;
        ListNode node = head;
        while (i < n && node.next != null) {
            node = node.next;
            i++;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (node.next != null) {
            node = node.next;
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) return curr.next;
        prev.next = curr.next;
        return prev;
    }

}
