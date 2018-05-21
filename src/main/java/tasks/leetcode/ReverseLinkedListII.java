package tasks.leetcode;

import java.util.List;

public class ReverseLinkedListII {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head;
        ListNode h = null;
        ListNode t = null;
        int i = 1;
        while (node != null) {
            if (i == m-1) {
                h = node;
            }
            if (i == n+1) {
                t = node;
            }
            node = node.next;
            i++;
        }

        /*if (h == null || t == null) {
            return head;
        }*/

        ListNode prev = t;
        ListNode curr = h != null ? h.next : head;
        ListNode next = null;

        while (curr != t) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (h == null) return prev;
        h.next = prev;

        return head;
    }

    public static void main(String[] args) {
        ListNode l1= new ListNode(1);
        ListNode l2= new ListNode(2);
        l1.next = l2;
        /*ListNode l3= new ListNode(3);
        l2.next = l3;
        ListNode l4= new ListNode(4);
        l3.next = l4;
        ListNode l5= new ListNode(5);
        l4.next = l5;
        ListNode l6= new ListNode(6);
        l5.next = l6;
        ListNode l7= new ListNode(7);
        l6.next = l7;*/

        reverseBetween(l1, 1, 2);
    }

}
