package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportProgrammers implements Report {
    private Store store;

    public ReportProgrammers(Store store) {
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
