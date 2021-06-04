package ru.job4j.ood.isp;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class TaskTree<K, V> implements Tree<K, V> {
    private final Node<K, V> root;

    public TaskTree(Node<K, V> root) {
        this.root = root;
    }

    @Override
    public boolean add(K parent, K node, V action) {
        Optional<Node<K, V>> optionalParent = findByPredicate(p -> p.getName().equals(parent));
        if (optionalParent.isEmpty() || findByPredicate(p -> p.getName().equals(node)).isPresent()) {
            return false;
        }
        optionalParent.get().addChild(node, action);
        return true;
    }

    @Override
    public V get(K node) {
        return findByPredicate(p -> p.getName().equals(node)).get().getAction();
    }

    @Override
    public boolean contains(K node) {
        return findByPredicate(p -> p.getName().equals(node)).isPresent();
    }

    @Override
    public String ordered() {
        StringBuilder result = new StringBuilder();
        result.append(root.getName());
        result.append(System.lineSeparator());
        List<Node<K, V>> list = root.getChildren();
        for (Node<K, V> n: list) {
            result.append(n.getName());
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    private Optional<Node<K, V>> findByPredicate(Predicate<Node<K, V>> condition) {
        Optional<Node<K, V>> rsl = Optional.empty();
        Queue<Node<K, V>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<K, V> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}
