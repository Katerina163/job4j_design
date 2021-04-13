package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;
    private int count = 0;

    @Override
    public void add(E value) {
        if (count == 0) {
            first = new Node<>(null, value, null);
        } else if (count == 1) {
            last = new Node<>(first, value, null);
            first.setNext(last);
        } else {
            Node<E> n = new Node<>(last, value, null);
            last = n;
        }
        count++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, count);
        Node<E> n;
        if (index == 0) {
            return first.getItem();
        } else if (index == count) {
            return last.getItem();
        } else {
            n = first;
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
        }
        return n.getItem();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final int expectedModCount = modCount;
            private Node<E> node = first;
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                point++;
                if (point - 1 == 0) {
                    return first.getItem();
                } else {
                    node = first.getNext();
                    return node.getItem();
                }
            }
        };
    }
}
