package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());
        List<Employer> list = store.findBy(filter);
        list.sort(new Comparator<Employer>() {
            @Override
            public int compare(Employer o1, Employer o2) {
                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        });
        for (Employer employer : list) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary() * 0.8).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
