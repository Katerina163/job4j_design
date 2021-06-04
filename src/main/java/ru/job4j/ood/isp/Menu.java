package ru.job4j.ood.isp;

import java.util.Scanner;

public class Menu {
    private static final String EXIT = "выход";
    private Tree<String, String> tree;

    public static void main(String[] args) {
        Menu m = new Menu();
        m.console();
    }

    public void console() {
        Scanner scanner = new Scanner(System.in);
        callMenu();
        String answer = scanner.next();
        while (!answer.equals(EXIT)) {
            if (tree.contains(answer)) {
                tree.get(answer);
            } else {
                System.out.println("Введен неправильный номер задачи");
            }
            System.out.println();
            callMenu();
            answer = scanner.next();
        }
    }

    private void callMenu() {
        if (tree == null) {
            tree = new TaskTree(new Tree.Node("root", ""));
            setTree();
        }
        System.out.println("Меню:");
        tree.ordered();
        System.out.print("Введите номер задачи: ");
    }

    private void setTree() {
        tree.add(tree.get("root"), "Задача 1", "Задача 1 что-то делает");
        tree.add(tree.get("root"), "Задача 1.1", "Задача 1.1 что-то делает");
        tree.add(tree.get("root"), "Задача 1.1.1", "Задача 1.1.1 что-то делает");
        tree.add(tree.get("root"), "Задача 1.1.2", "Задача 1.1.2 что-то делает");
        tree.add(tree.get("root"), "Задача 1.2", "Задача 1.2 что-то делает");
        tree.add(tree.get("root"), "Задача 2", "Задача 2 что-то делает");
        tree.add(tree.get("root"), "Задача 2.1", "Задача 2.1 что-то делает");
    }
}
