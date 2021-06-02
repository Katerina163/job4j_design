package ru.job4j.ood.lsp.explanation;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorkDays implements Iterable {
    private Map<LocalDate, Integer> workDays = new LinkedHashMap<>();

    public void add(LocalDate date, int hours) {
        workDays.put(date, hours);
    }

    public Map<LocalDate, Integer> getWorkDays() {
        return workDays;
    }

    @Override
    public Iterator<Integer> iterator() {
        return workDays.values().iterator();
    }
}
