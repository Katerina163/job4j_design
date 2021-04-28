package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private final List<String> listOfBotAnswer = new ArrayList<>();
    private final List<String> listOfDialog = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        botAns();
    }

    public void run() {
        try (BufferedWriter out = new BufferedWriter(
                                     new FileWriter(path, Charset.forName("UTF-8"))
        )) {
            Scanner input = new Scanner(System.in);
            System.out.println("Здравствуй. Задавай вопрос");
            listOfDialog.add("Здравствуй. Задавай вопрос");
            String answer = input.nextLine();
            listOfDialog.add(answer);
            while (!answer.equals(OUT)) {
                if (answer.equals(STOP)) {
                    while (!answer.equals(CONTINUE)) {
                        answer = input.nextLine();
                        listOfDialog.add(answer);
                    }
                    System.out.println("Задавай вопрос");
                    listOfDialog.add("Задавай вопрос");
                    answer = input.nextLine();
                    listOfDialog.add(answer);
                    continue;
                }
                String answerBot = listOfBotAnswer.get(new Random().nextInt(listOfBotAnswer.size()));
                System.out.println(answerBot);
                listOfDialog.add(answerBot);
                System.out.println("Задавай следующий вопрос");
                listOfDialog.add("Задавай следующий вопрос");
                answer = input.nextLine();
                listOfDialog.add(answer);
                }
            for (String s : listOfDialog) {
                out.write(s + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void botAns() {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, Charset.forName("UTF-8")))) {
            String s = in.readLine();
            while (s != null) {
                listOfBotAnswer.add(s);
                s = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/dialog.txt", "./data/answer.txt");
        cc.run();
    }
}
