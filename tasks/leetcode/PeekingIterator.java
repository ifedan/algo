package tasks.leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    private Integer peek = null;
    private boolean hasPeek = false;
    private final Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            peek = iterator.next();
            hasPeek = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeek) throw new IllegalStateException();
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeek) throw new IllegalStateException();
        int val = peek;
        if (iterator.hasNext()) {
            peek = iterator.next();
            hasPeek = true;
        } else {
            hasPeek = false;
        }
        return val;
    }

    @Override
    public boolean hasNext() {
        return hasPeek;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        PeekingIterator itt = new PeekingIterator(list.iterator());
        while (itt.hasNext()) {
            System.out.println(itt.peek());
            System.out.println(itt.next());
        }
    }
}

