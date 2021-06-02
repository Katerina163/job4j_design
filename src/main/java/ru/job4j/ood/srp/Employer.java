package ru.job4j.ood.srp;

import javax.xml.bind.annotation.*;
import java.util.Calendar;
import java.util.Objects;
@XmlRootElement(name = "employer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employer {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private Calendar hired;
    @XmlAttribute
    private Calendar fired;
    @XmlAttribute
    private double salary;

    public Employer() {
    }

    public Employer(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employer employee = (Employer) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employer{"
                + "name=" + name
                + ", hired=" + hired
                + ", fired=" + fired
                + ", salary=" + salary
                + '}';
    }
}
