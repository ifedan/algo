package tasks.leetcode;

public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode node = root;

        while (head != null) {
            if (node != root && node.val == head.val) {
                head = head.next;
            } else {
                node.next = head;
                head = head.next;
                node.next.next = null;
                node = node.next;
            }
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1= new ListNode(1);
        ListNode l2= new ListNode(2);
        l1.next = l2;
        ListNode l3= new ListNode(3);
        l2.next = l3;
        ListNode l4= new ListNode(3);
        l3.next = l4;
        ListNode l5= new ListNode(4);
        l4.next = l5;
        ListNode l6= new ListNode(4);
        l5.next = l6;
        ListNode l7= new ListNode(5);
        l6.next = l7;

        deleteDuplicates(l1);
    }

}
