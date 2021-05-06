package ru.job4j.mail;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MailTest {
    @Test
    public void test() {
        Set<String> set1 = new TreeSet<>();
        set1.add("xxx@ya.ru");
        set1.add("foo@gmail.com");
        set1.add("lol@mail.ru");
        Set<String> set2 = new TreeSet<>();
        set2.add("foo@gmail.com");
        set2.add("ups@pisem.net");
        Set<String> set3 = new TreeSet<>();
        set3.add("xyz@pisem.net");
        set3.add("vasya@pupkin.com");
        Set<String> set4 = new TreeSet<>();
        set4.add("ups@pisem.net");
        set4.add("aaa@bbb.ru");
        Set<String> set5 = new TreeSet<>();
        set5.add("xxx@ya.ru");
        List<User> u = List.of(
                new User("user1", set1),
                new User("user2", set2),
                new User("user3", set3),
                new User("user4", set4),
                new User("user5", set5)
        );
        Map<String, Set<String>> result = new HashMap<>();
        result.put("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru",
                "ups@pisem.net", "aaa@bbb.ru"));
        result.put("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        assertThat(Mail.merger(u), is(result));
    }

}