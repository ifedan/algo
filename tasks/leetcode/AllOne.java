package tasks.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AllOne {

    class Node {
        Node prev;
        Node next;

        int val;
        Node(int val){
            this.val = val;
        }

        Node dec() {
            if (prev != null && prev.val == val - 1) return prev;
            else {
                Node newNode = new Node(val - 1);
                newNode.prev = prev;
                newNode.next = this;

                if (prev != null) {
                    prev.next = newNode;
                }
                prev = newNode;
                return newNode;
            }
        }

        Node inc() {
            if (next != null && next.val == val + 1) return next;
            else {
                Node newNode = new Node(val + 1);
                newNode.prev = this;
                newNode.next = next;

                if (next != null) {
                    next.prev = newNode;
                }
                next = newNode;
                return newNode;
            }
        }

        void del() {
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
            prev = null;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            return val == ((Node)o).val;
        }

        @Override
        public int hashCode() {
            return val;
        }
    }

    /** Initialize your data structure here. */
    AllOne() {
        index.put(zero, new HashSet<>());
    }

    final Node zero = new Node(0);

    Map<Node, Set<String>> index = new HashMap<>();
    Map<String, Node> count = new HashMap<>();

    Node max = zero;

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node newValue = count.compute(key, (k, v) -> v == null ? zero.inc() : v.inc());
        if (newValue.val > max.val) {
            max = newValue;
        }
        process(newValue.prev, newValue, key);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!count.containsKey(key)) return;
        Node newValue = count.compute(key, (k, v) -> v.dec());
        if (newValue.val == 0) {
            count.remove(key);
        }
        process(newValue.next, newValue, key);
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Iterator<String> it = index.get(zero.next != null ? zero.next : zero).iterator();
        return it.hasNext() ? it.next() : "";
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Iterator<String> it = index.get(max).iterator();
        return it.hasNext() ? it.next() : "";
    }

    private void process(Node oldValue, Node newValue, String key) {
        //remove value from old set
        Set<String> setWithOldValue = index.get(oldValue);
        setWithOldValue.remove(key);
        //remove old set if there is no value
        if (setWithOldValue.isEmpty() && oldValue.val != 0) {
            index.remove(oldValue);
            if (oldValue == max) {
                max = max.prev;
            }
            oldValue.del();
        }
        if (newValue.val != 0) {
            //add key to new set
            index.compute(newValue, (k, v) -> {
                Set<String> s = (v == null ? new HashSet<>() : v);
                s.add(key);
                return s;
            });
        }
    }

}
