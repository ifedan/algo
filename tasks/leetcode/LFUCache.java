package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        void remove() {
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
            prev = null;
            next = null;
        }

        void insertAfter(Node<T> node) {
            next = node.next;
            prev = node;
            node.next = this;
            if (next != null) next.prev = this;
        }

        void insertBefore(Node<T> node) {
            prev = node.prev;
            next = node;
            node.prev = this;
            if (prev != null) prev.next = this;
        }

        public String toString() {
            return "" + value;
        }
    }

    class Entry {
        int count;
        int key;
        int value;
        void touch() {
            count++;
        }
        public String toString() {
            return "("+key+":"+count+")";
        }
    }

    class LinkedList<T> {
        final Node<T> head = new Node<>();
        final Node<T> tail = new Node<>();

        LinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        int size = 0;

        void insert(Node<T> node) {
            node.insertBefore(tail);
            size++;
        }

        void remove(Node node) {
            node.remove();
            size--;
        }

        boolean isEmpty() {
            return size <= 0;
        }

        Node<T> first() {
            if (isEmpty()) throw new IndexOutOfBoundsException();
            return head.next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node node = head.next;
            sb.append("[");
            while (node != tail) {
                sb.append(node).append(",");
                node = node.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    final Node<LinkedList<Entry>> head = new Node<>();
    final Node<LinkedList<Entry>> tail = new Node<>();

    public LFUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        buckets.put(0, head);
        this.capacity = capacity;
    }

    int size = 0;
    int capacity;


    Map<Integer, Node<LinkedList<Entry>>> buckets = new HashMap<>();
    Map<Integer, Node<Entry>> map = new HashMap<>();

    public int get(int key) {
        Node<Entry> node = map.get(key);
        if (node == null) return -1;
        touch(node);
        return node.value.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node<Entry> node = map.get(key);
        if (node != null) {
            touch(node);
            node.value.value = value;
        } else {
            node = insert();
            node.value.key = key;
            node.value.value = value;
            map.put(key, node);
        }
    }

    private void delete() {
        if (size <= 0) return;
        Node<Entry> node = head.next.value.first();
        deleteFromCurrBucket(node);
        map.remove(node.value.key);
        size--;
    }

    private Node<Entry> insert() {
        if (size >= capacity) {
            delete();
        }
        Node<Entry> node = new Node<>();
        node.value = new Entry();
        touch(node);
        size++;
        return node;
    }

    private void touch(Node<Entry> node) {
        moveToNextBucket(node);
        node.value.touch();
    }

    private void moveToNextBucket(Node<Entry> entry) {
        int bucket = entry.value.count;
        Node<LinkedList<Entry>> currBucket = buckets.get(bucket);
        Node<LinkedList<Entry>> nextBucket = buckets.get(bucket + 1);
        if (nextBucket == null) {
            nextBucket = new Node<>();
            nextBucket.value = new LinkedList<>();
            nextBucket.insertAfter(currBucket);
            buckets.put(bucket + 1, nextBucket);
        }
        deleteFromCurrBucket(entry);
        nextBucket.value.insert(entry);
    }

    private void deleteFromCurrBucket(Node<Entry> entry) {
        int bucket = entry.value.count;
        if (bucket == 0) return;
        Node<LinkedList<Entry>> list = buckets.get(bucket);
        list.value.remove(entry);
        if (list.value.isEmpty()) {
            buckets.remove(bucket);
            list.remove();
        }
    }
}
