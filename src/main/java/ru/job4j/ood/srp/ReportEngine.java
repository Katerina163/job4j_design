package ru.job4j.ood.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.function.Predicate;
@XmlRootElement(name = "reportengine")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportEngine implements Report {
    @XmlAnyElement
    private Store store;

    public ReportEngine() {
    }

    public ReportEngine(Store store) {
        this.store = store;
    }

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
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    @Override
    public String toString() {
        return "ReportEngine{" + "store=" + store + '}';
    }
}
