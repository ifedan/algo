package datastructures;

public class Stack {

    class Node {
        Node next;
        Object value;
    }

    private Node first;

    public void push(Object val) {
        Node node = new Node();
        node.value = val;
        Node cur = first;
        first = node;
        first.next = cur;
    }

    public Object peek() {
        if (first == null) return null;
        return first.value;
    }

    public Object pop() {
        if (first == null) return null;
        Object val = first.value;
        first = first.next;
        return val;
    }


}
