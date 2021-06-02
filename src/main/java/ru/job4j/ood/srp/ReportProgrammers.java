package ru.job4j.ood.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.function.Predicate;
@XmlRootElement(name = "reportprogrammers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportProgrammers implements Report {
    @XmlAnyElement
    private Store store;

    public ReportProgrammers() {
    }

    public ReportProgrammers(Store store) {
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
        text.append("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n"
                + "<meta charset=\"utf-8\"/>\n" + "<title>HTML Document</title>\n"
                + "</head>\n" + "<body>\n");

        for (Employer employer : store.findBy(filter)) {
            text.append("</employer " + "name=\"");
            text.append(employer.getName()).append("\" hired=\"")
                    .append(employer.getHired()).append("\" fired=\"")
                    .append(employer.getFired()).append("\" salary=\"")
                    .append(employer.getSalary()).append("\"/>")
                    .append(System.lineSeparator());
        }
        text.append("</body>\n" + "</html>");
        return text.toString();
    }
}
