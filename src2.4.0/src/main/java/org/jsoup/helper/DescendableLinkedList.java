package org.jsoup.helper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DescendableLinkedList<E> extends LinkedList<E> {

    private class DescendingIterator<E> implements Iterator<E> {
        private final ListIterator<E> O00000Oo;

        private DescendingIterator(int i) {
            this.O00000Oo = DescendableLinkedList.this.listIterator(i);
        }

        public boolean hasNext() {
            return this.O00000Oo.hasPrevious();
        }

        public E next() {
            return this.O00000Oo.previous();
        }

        public void remove() {
            this.O00000Oo.remove();
        }
    }

    public Iterator<E> descendingIterator() {
        return new DescendingIterator(size());
    }

    public E peekLast() {
        return size() == 0 ? null : getLast();
    }

    public E pollLast() {
        return size() == 0 ? null : removeLast();
    }

    public void push(E e) {
        addFirst(e);
    }
}
