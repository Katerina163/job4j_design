package ru.job4j.ood.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
@XmlRootElement(name = "reporthr")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportHR implements Report {
    @XmlAnyElement
    private Store store;

    public ReportHR() {
    }

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary");
        List<Employer> list = store.findBy(filter);
        list.sort(new Comparator<Employer>() {
            @Override
            public int compare(Employer o1, Employer o2) {
                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        });
        for (Employer employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
