package ru.job4j.ood.isp;

public class Server implements Calculator, Internet {
    @Override
    public void calculate() {
        System.out.println("Do work!");
    }

    @Override
    public void connect() {
        System.out.println("Try connect ...");
    }
}
