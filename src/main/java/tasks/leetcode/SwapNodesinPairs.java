package tasks.leetcode;

public class SwapNodesinPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode next = head.next.next;

        second.next = first;
        first.next = swapPairs(next);
        return second;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        //l1.next.next.next = new ListNode(4);
        ListNode r = swapPairs(l1);
        System.out.println();
    }

}
