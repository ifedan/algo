package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Entry> map = new HashMap<>();
    Entry head = new Entry();
    Entry tail = new Entry();

    int capacity;

    class Entry {
        int key;
        int val;
        Entry next;
        Entry prev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void deleteEntry(Entry e) {
        Entry prev = e.prev;
        Entry next = e.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToHead(Entry e) {
        Entry prevHead = head.next;
        head.next = e;
        e.prev = head;
        e.next = prevHead;
        prevHead.prev = e;
    }

    public int get(int key) {
        Entry e = map.get(key);
        if (e == null) return -1;
        deleteEntry(e);
        addToHead(e);
        return e.val;
    }

    public void set(int key, int value) {
        Entry e = map.get(key);
        if (e != null) {
            deleteEntry(e);
            addToHead(e);
            e.val = value;
        } else {
            if (map.size() == capacity) {
                Entry toRemove = tail.prev;
                map.remove(toRemove.key);
                deleteEntry(toRemove);
            }
            Entry newEntry = new Entry();
            newEntry.val = value;
            newEntry.key = key;
            addToHead(newEntry);
            map.put(key, newEntry);
        }
    }

}
