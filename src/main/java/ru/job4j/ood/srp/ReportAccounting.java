package ru.job4j.ood.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.function.Predicate;
@XmlRootElement(name = "reportaccounting")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportAccounting implements Report {
    @XmlAnyElement
    private Store store;

    public ReportAccounting() {
    }

    public ReportAccounting(Store store) {
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
        text.append("Name; Hired; Fired; Salary");
        for (Employer employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * 0.8).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
