package datastructures;

public class Queue {

    class Node {
        Node next;
        Object value;
    }

    private Node first;
    private Node last;

    public void enqueue(Object val) {
        Node node = new Node();
        node.value = val;
        Node cur = last;   //TODO: ADD TO LAST
        last = node;
        if (cur != null) {
            cur.next = last;
        } else {
            first = last;
        }
    }

    public Object dequeue() {
        if (first == null) throw new IllegalStateException();
        Object value = first.value;
        first = first.next;
        return value;
    }


}
