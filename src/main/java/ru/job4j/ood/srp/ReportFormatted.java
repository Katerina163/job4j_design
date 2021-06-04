package ru.job4j.ood.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Formatter;
import java.util.function.Predicate;
@XmlRootElement(name = "reportformatted")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportFormatted implements Report {
    @XmlAnyElement
    private Store store;
    @XmlAnyElement
    private Formatter formatter;

    public ReportFormatted() {
    }

    public ReportFormatted(Store store, Formatter formatter) {
        this.store = store;
        this.formatter = formatter;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        for (Employer employer : store.findBy(filter)) {
            text.append(formatter.format(
                    "Employer: Name %s; Hired %s; Fired %s; Salary %s;\n",
                    employer.getName(), employer.getHired(),
                    employer.getFired(), employer.getSalary()));
        }

        return text.toString();
    }

    @Override
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }
}
