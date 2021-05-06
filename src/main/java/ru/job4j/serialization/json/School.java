package ru.job4j.serialization.json;

import java.util.Arrays;

public class School {
    private final boolean medicalRoom;
    private final int numberOfTeachers;
    private final String nameSchool;
    private final Library library;
    private final String[] buildingType;

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

    public boolean isMedicalRoom() {
        return medicalRoom;
    }

    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public Library getLibrary() {
        return library;
    }

    public String[] getBuildingType() {
        return buildingType;
    }
}
