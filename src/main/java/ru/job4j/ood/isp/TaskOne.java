package ru.job4j.ood.isp;

public class TaskOne implements Task {
    private String name;

    public TaskOne(String name) {
        this.name = name;
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
