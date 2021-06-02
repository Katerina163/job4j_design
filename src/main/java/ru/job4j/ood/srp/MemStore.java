package ru.job4j.ood.srp;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
@XmlRootElement(name = "store")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemStore implements Store {
    @XmlElementWrapper(name = "employers")
    @XmlElement(name = "employer")
    private List<Employer> employers = new ArrayList<>();

    public MemStore() {
    }

    @Override
    public void add(Employer em) {
        employers.add(em);
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    @Override
    public List<Employer> findBy(Predicate<Employer> filter) {
        return employers.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "MemStore{" + "employers=" + employers + '}';
    }
}
