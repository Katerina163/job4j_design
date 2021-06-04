package ru.job4j.ood.isp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static final String EXIT = "выход";
    private Map<String, Task> map;

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
            System.out.println("Задача " + m.getKey());
        }
        System.out.print("Введите номер задачи: ");
    }

    private void setMap() {
        Task one = new TaskOne("1");
        this.map.put("1", one);
        one.addTask(new TaskOne("1.1"));
        this.map.put(one.getTask("1.1").getName(), one.getTask("1.1"));
        one.addTask(new TaskOne("1.1.1"));
        this.map.put(one.getTask("1.1.1").getName(), one.getTask("1.1.1"));
        one.addTask(new TaskOne("1.1.2"));
        this.map.put(one.getTask("1.1.2").getName(), one.getTask("1.1.2"));
        one.addTask(new TaskOne("1.2"));
        this.map.put(one.getTask("1.2").getName(), one.getTask("1.2"));
        Task two = new TaskOne("2");
        this.map.put("2", two);
        two.addTask(new TaskOne("2.1"));
        this.map.put(two.getTask("2.1").getName(), two.getTask("2.1"));
        two.addTask(new TaskOne("2.2"));
        this.map.put(two.getTask("2.2").getName(), two.getTask("2.2"));
        two.addTask(new TaskOne("2.2.1"));
        this.map.put(two.getTask("2.2.1").getName(), two.getTask("2.2.1"));
    }
}
