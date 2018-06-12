package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListComponents {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int numComponents(ListNode head, int[] G) {
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            pos.put(G[i], i);
        }
        UF uf = new UF(pos.size());
        while (head != null) {
            ListNode next = head.next;
            if (next != null && pos.containsKey(head.val) && pos.containsKey(next.val)) {
                uf.union(pos.get(head.val), pos.get(next.val));
            }
            head = next;
        }
        return uf.count;
    }

    private static class UF {
        int arr[];
        int weight[];
        int count;
        UF(int size) {
            arr = new int[size];
            weight = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i;
                weight[i] = 1;
            }
            count = size;
        }
        int parent(int child) {
            while (arr[child] != child) {
                child = arr[child];
            }
            return child;
        }
        void union(int a, int b) {
            if (a==b) return;
            int parentA = parent(a);
            int parentB = parent(b);
            if (parentA == parentB) return;
            if (weight[parentA] > weight[parentB]) {
                arr[parentB] = parentA;
                weight[parentA] += weight[parentB];
            } else {
                arr[parentA] = parentB;
                weight[parentB] += weight[parentA];
            }
            count--;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        int res = numComponents(l1, new int[]{0,3,1,4});
        System.out.println(res);
    }
}
