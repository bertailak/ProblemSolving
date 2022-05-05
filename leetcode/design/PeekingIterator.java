package leetcode.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    List<Integer> list;
    int index;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        index = 0;
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(index);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int next = list.get(index);
        index++;
        return next;
    }

    @Override
    public boolean hasNext() {
        if (list == null)
            return false;
        return index < list.size();
    }
}
