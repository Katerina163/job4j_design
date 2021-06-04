package ru.job4j.ood.isp;

import java.util.ArrayList;
import java.util.List;

public interface Tree<K, V> {
    boolean add(K parent, K node, V action);

    V get(K node);

    String ordered();

    boolean contains(K node);

    class Node<K, V> {
        private final K name;
        private V action;
        private final List<Node<K, V>> children = new ArrayList<>();

        public Node(K name, V action) {
            this.name = name;
            this.action = action;
        }

        public void addChild(K child, V action) {
            children.add(new Node<>(child, action));
        }

        public K getName() {
            return name;
        }

        public V getAction() {
            return action;
        }

        public List<Node<K, V>> getChildren() {
            return children;
        }
    }
}
