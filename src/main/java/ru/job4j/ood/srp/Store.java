package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    void add(Employer em);

    List<Employer> findBy(Predicate<Employer> filter);
}
