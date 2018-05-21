package tasks.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorOfIterators<T> {

    private final List<Iterator<T>> itt;
    private int i;

    public IteratorOfIterators(List<Iterator<T>> itt) {
        this.itt = itt;
    }

    public boolean hasNext() {
        return !itt.isEmpty();
    }

    public T next() {
        if (itt.isEmpty()) {
            throw new IllegalStateException();
        }
        if (i >= itt.size()) {
            i = 0;
        }
        Iterator<T> it = itt.get(i);
        T obj = it.next();
        if (!it.hasNext()) {
            itt.remove(it);
            i--;
        }
        i++;
        return obj;
    }

    public static void main(String[] args) {
        List<Iterator<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        List<Integer> c = new ArrayList<>();
        c.add(4);
        c.add(5);
        c.add(6);

        list.add(a.iterator());
        list.add(b.iterator());
        list.add(c.iterator());

        IteratorOfIterators<Integer> ii = new IteratorOfIterators<Integer>(list);
        while (ii.hasNext()) {
            System.out.println(ii.next());
        }
    }

}
