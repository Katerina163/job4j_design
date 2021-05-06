package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "school")
@XmlAccessorType(XmlAccessType.FIELD)
public class School {
    @XmlAttribute
    private boolean medicalRoom;
    @XmlAttribute
    private int numberOfTeachers;
    @XmlAttribute
    private String nameSchool;
    @XmlElement(name = "library")
    private Library library;
    @XmlElementWrapper(name = "buildingTypes")
    @XmlElement(name = "buildingType")
    private String[] buildingType;

    public School() {
    }

    public School(boolean medicalRoom, int numberOfTeachers,
                  String nameSchool, Library library, String[] buildingType) {
        this.medicalRoom = medicalRoom;
        this.numberOfTeachers = numberOfTeachers;
        this.nameSchool = nameSchool;
        this.library = library;
        this.buildingType = buildingType;
    }

    @Override
    public String toString() {
        return "School{" + "medicalRoom=" + medicalRoom
                + ", numberOfTeachers=" + numberOfTeachers
                + ", nameSchool='" + nameSchool + '\''
                + ", library=" + library
                + ", buildingType=" + Arrays.toString(buildingType)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        Library lib = new Library(5800);
        String[] array = {"Трехэтажное", "Кирпичное"};
        School school = new School(true, 25, "Школа №3", lib, array);
        JAXBContext context = JAXBContext.newInstance(School.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(school, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            School result = (School) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
