package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private final int numberOfLines;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        numberOfLines = numberOfLines();
    }

    public void run() {
        try (BufferedWriter out = new BufferedWriter(
                                     new FileWriter(path, Charset.forName("UTF-8"))
        )) {
            Scanner input = new Scanner(System.in);
            System.out.println("Здравствуй. Задавай вопрос");
            out.write("Здравствуй. Задавай вопрос" + System.lineSeparator());
            String answer = input.nextLine();
            out.write(answer + System.lineSeparator());
            while (!answer.equals(OUT)) {
                if (answer.equals(STOP)) {
                    while (!answer.equals(CONTINUE)) {
                        answer = input.nextLine();
                        out.write(answer + System.lineSeparator());
                    }
                    System.out.println("Задавай вопрос");
                    out.write("Задавай вопрос" + System.lineSeparator());
                    answer = input.nextLine();
                    out.write(answer + System.lineSeparator());
                    continue;
                }
                String answerBot = botAns();
                System.out.println(answerBot);
                out.write(answerBot + System.lineSeparator());
                System.out.println("Задавай следующий вопрос");
                out.write("Задавай следующий вопрос" + System.lineSeparator());
                answer = input.nextLine();
                out.write(answer + System.lineSeparator());
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String botAns() {
        int index = new Random().nextInt(numberOfLines);
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, Charset.forName("UTF-8")))) {
            for (int i = 0; i < index; i++) {
                in.readLine();
            }
            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int numberOfLines() {
        int i = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            i = in.lines().filter(a -> a.length() != 0).mapToInt(s -> 1).sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return i;
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/dialog.txt", "./data/answer.txt");
        cc.run();
    }
}
