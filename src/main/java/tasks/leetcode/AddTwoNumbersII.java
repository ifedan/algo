package tasks.leetcode;

import java.util.Stack;

public class AddTwoNumbersII {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode result = new ListNode(1);
        boolean extra = false;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int i1 = s1.isEmpty() ? 0 : s1.pop();
            int i2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = i1+i2;
            if (extra) {
                sum += 1;
                extra = false;
            }
            if (sum >= 10) {
                sum -= 10;
                extra = true;
            }
            ListNode root = result.next;
            result.next = new ListNode(sum);
            result.next.next = root;

        }
        return extra ? result : result.next;

    }

    public static void main(String[] args) {
        //(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(4);
        l2.next = l3;
        ListNode l4 = new ListNode(3);
        l3.next = l4;

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l5.next = l6;
        ListNode l7 = new ListNode(4);
        l6.next = l7;

        addTwoNumbers(l1, l5);

    }
}
