package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean isBinary() {
        return findByPredicate(c -> c.getChildren().size() > 2).isEmpty();
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> optionalParent = findBy(parent);
        if (optionalParent.isEmpty() || findBy(child).isPresent()) {
            return false;
        }
        optionalParent.get().addChild(child);
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(c -> c.getValue().equals(value));
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}
