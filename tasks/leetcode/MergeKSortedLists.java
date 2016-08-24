package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null) {
                queue.add(list.val);
                list = list.next;
            }
        }
        ListNode node = new ListNode(-1);
        ListNode root = node;
        while (!queue.isEmpty()) {
            node.next = new ListNode(queue.poll());
            node = node.next;
        }
        return root.next;

    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        List<ListNode> itt = new ArrayList<ListNode>();
    	for (int i = 0; i < lists.length; i++) {
    		if (lists[i] != null) {
    			itt.add(lists[i]);
    		}
    	}

        ListNode node = new ListNode(-1);
        ListNode root = node;


        while (itt.isEmpty()) {
        	int index = 0;
            int min = Integer.MAX_VALUE;
        	for (int i = 0; i < itt.size(); i++) {
        		if (itt.get(i).val < min) {
        			index = i;
        			min = itt.get(i).val;
        		}
        	}
        	node.next = new ListNode(min);
        	node = node.next;
        	if (itt.get(index).next != null) {
        		itt.set(index, itt.get(index).next);
        	} else {
        		itt.remove(index);
        	}
        }
        return root.next;
    }

}
