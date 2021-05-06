package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        /* преобразовывание json-строки в объект и наоборот с библиотекой Gson */
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
        System.out.println();
        /* преобразование POJO объект в JSONObject и json-строку */
        JSONObject jsonLibrary = new JSONObject("{\"books\":\"5800\"}");
        /* JSONArray из ArrayList */
        List<String> buildingType = new ArrayList<>();
        buildingType.add("Трехэтажное");
        buildingType.add("Кирпичное");
        JSONArray jsonBuild = new JSONArray(buildingType);
        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("medicalRoom", school.isMedicalRoom());
        jsonObject.put("numberOfTeachers", school.getNumberOfTeachers());
        jsonObject.put("nameSchool", school.getNameSchool());
        jsonObject.put("library", jsonLibrary);
        jsonObject.put("buildingTypes", jsonBuild);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(school));


    }
}
