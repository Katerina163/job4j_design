package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    public static void main(String[] args) {
        Library lib = new Library(5800);
        String[] array = {"Трехэтажное", "Кирпичное"};
        final School school = new School(true, 25, "Школа №3", lib, array);
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(school));
        final String schoolJson = "{" + "\"medicalRoom\":true,"
                + "\"numberOfTeachers\":25,"
                + "\"nameSchool\":\"Школа №3\","
                + "\"library\":"
                    + "{"
                        + "\"books\":\"5800\""
                        + "},"
                + "\"buildingType\":"
                    + "[\"Трехэтажное\",\"Кирпичное\"]"
                + "}";
        final School schoolMod = gson.fromJson(schoolJson, School.class);
        System.out.println(schoolMod);
    }
}
