package com.zjwh.android_wh_physicalfitness.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: LimitQueue */
public class oooOoO<E> implements Queue<E> {
    Queue<E> O000000o = new LinkedList();
    private int O00000Oo;

    public oooOoO(int i) {
        this.O00000Oo = i;
    }

    public Queue<E> O000000o() {
        return this.O000000o;
    }

    public int O00000Oo() {
        return this.O00000Oo;
    }

    public boolean add(E e) {
        return this.O000000o.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return this.O000000o.addAll(collection);
    }

    public void clear() {
        this.O000000o.clear();
    }

    public boolean contains(Object obj) {
        return this.O000000o.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.O000000o.containsAll(collection);
    }

    public E element() {
        return this.O000000o.element();
    }

    public boolean isEmpty() {
        return this.O000000o.size() == 0;
    }

    public Iterator<E> iterator() {
        return this.O000000o.iterator();
    }

    public boolean offer(E e) {
        if (this.O000000o.size() >= this.O00000Oo) {
            this.O000000o.poll();
        }
        return this.O000000o.offer(e);
    }

    public E peek() {
        return this.O000000o.peek();
    }

    public E poll() {
        return this.O000000o.poll();
    }

    public E remove() {
        return this.O000000o.remove();
    }

    public boolean remove(Object obj) {
        return this.O000000o.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.O000000o.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.O000000o.retainAll(collection);
    }

    public int size() {
        return this.O000000o.size();
    }

    public Object[] toArray() {
        return this.O000000o.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.O000000o.toArray(tArr);
    }
}
