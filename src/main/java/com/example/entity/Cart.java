package com.example.entity;

import java.util.*;

public class Cart implements List<Watch> {
    private  List<Watch> items;

    public Cart(){
        items = new ArrayList<>();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return items.contains(o);
    }

    @Override
    public Iterator<Watch> iterator() {
        return items.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Watch calc) {
        return items.add(calc);
    }

    @Override
    public boolean remove(Object o) {
        return items.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Watch> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Watch> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return items.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public Watch get(int index) {
        return items.get(index);
    }

    @Override
    public Watch set(int index, Watch element) {
        return null;
    }

    @Override
    public void add(int index, Watch element) {

    }

    @Override
    public Watch remove(int index) {
        return items.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Watch> listIterator() {
        return items.listIterator();
    }

    @Override
    public ListIterator<Watch> listIterator(int index) {
        return null;
    }

    @Override
    public List<Watch> subList(int fromIndex, int toIndex) {
        return null;
    }
}
