package tasks.leetcode;


public class ReverseNodesinKGroup {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public static ListNode revert(ListNode head, int n) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        if (size < n) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int i = 0;
        while (curr != null && i < n) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        head.next = revert(curr, n);
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        //l1.next = new ListNode(2);
        //l1.next.next = new ListNode(3);
        //l1.next.next.next = new ListNode(4);
        ListNode ln = revert(l1, 1);
        System.out.println();
    }

}
