package ru.job4j.ood.isp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, Task> map;
    private static final String EXIT = "выход";

    public static void main(String[] args) {
        Menu m = new Menu();
        m.console();
    }

    public void console() {
        Scanner scanner = new Scanner(System.in);
        callMenu();
        String answer = scanner.next();
        while (!answer.equals(EXIT)) {
            if (map.containsKey(answer)) {
                map.get(answer).doSomething();
            } else {
                System.out.println("Введен неправильный номер задачи");
            }
            System.out.println();
            callMenu();
            answer = scanner.next();
        }
    }

    private void callMenu() {
        if (this.map == null) {
            this.map = new LinkedHashMap<>();
            setMap();
        }
        System.out.println("Меню:");
        for (var m : this.map.entrySet()) {
            int i = m.getKey().length();
            switch (i) {
                case 1 ->
                    System.out.println("Задача " + m.getValue().getName());
                case 3 ->
                    System.out.println("--Задача " + m.getValue().getName());
                case 5 ->
                    System.out.println("----Задача " + m.getValue().getName());
                default ->
                    System.out.println("Что-то пошло не так");
            }
        }
        System.out.print("Введите номер задачи: ");
    }

    private void setMap() {
        this.map.put("1", new TaskOne("1"));
        this.map.put("1.1", new TaskOne("1.1"));
        this.map.put("1.1.1", new TaskOne("1.1.1"));
        this.map.put("1.1.2", new TaskOne("1.1.2"));
        this.map.put("1.2", new TaskOne("1.2"));
        this.map.put("2", new TaskOne("2"));
        this.map.put("2.1", new TaskOne("2.1"));
        this.map.put("2.1.1", new TaskOne("2.1.1"));
        this.map.put("3", new TaskOne("3"));
    }
}
