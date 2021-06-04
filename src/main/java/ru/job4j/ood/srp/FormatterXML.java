package ru.job4j.ood.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class FormatterXML implements Formatter {
    private Report report;

    public FormatterXML(Report report) {
        this.report = report;
    }

    @Override
    public String generate() throws Exception {
        JAXBContext context = JAXBContext.newInstance(report.getClass(),
                report.getStore().getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(report, writer);
            xml = writer.getBuffer().toString();
        }
        return xml;
    }
}