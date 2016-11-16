package tasks.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> stack = new Stack<>();

    private Integer val;
    private boolean next = false;

    NestedIterator(List<NestedInteger> list) {
        if (list.isEmpty()) return;
        stack.push(list.iterator());
        next = move();
    }

    @Override
    public boolean hasNext() {
        return next;
    }

    private boolean move() {
        if (stack.isEmpty()) {
            return false;
        }
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> itt = stack.peek();

            if (!itt.hasNext()) {
                stack.pop();
                continue;
            }
            NestedInteger ni = itt.next();
            if (!itt.hasNext()) {
                stack.pop();
            }
            if (ni.isInteger()) {
                val = ni.getInteger();
                return true;
            } else {
                stack.push(ni.getList().iterator());
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!next) {
            throw new IndexOutOfBoundsException();
        }
        Integer t = val;
        next = move();
        return t;
    }
}

interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}
