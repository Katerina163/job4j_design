package ru.job4j.ood.isp;

public interface Task {
    String getName();

    void doSomething();

    void addTask(Task task);

    Task getTask(String name);
}
