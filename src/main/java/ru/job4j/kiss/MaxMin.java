package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return find(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return find(value, comparator.reversed());
    }

    private <T> T find(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            result = comparator.compare(result, value.get(i)) > 0 ? result : value.get(i);
        }
        return result;
    }
}
