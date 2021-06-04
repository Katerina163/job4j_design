package ru.job4j.ood.isp;

import java.util.Map;
import java.util.TreeMap;

public class TaskOne implements Task {
    private String name;
    private Map<String, Task> map;

    public TaskOne(String name) {
        this.name = name;
    }

    public Map<String, Task> getMap() {
        return map;
    }

    @Override
    public Task getTask(String name) {
        return map.get(name);
    }

    @Override
    public void addTask(Task task) {
        if (map == null) {
            map = new TreeMap<>();
        }
        map.put(task.getName(), task);
    }

    @Override
    public void doSomething() {
        System.out.println("Задача " + name + " что-то сделала");
    }

    @Override
    public String getName() {
        return name;
    }
}
