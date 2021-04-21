package ru.job4j.statistics;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    @Test
    public void test() {
        Analize.User user1 = new Analize.User(1, "a");
        Analize.User user2 = new Analize.User(2, "a");
        Analize.User user3 = new Analize.User(2, "b");
        Analize.User user4 = new Analize.User(3, "c");
        Analize.User user5 = new Analize.User(5, "e");
        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        previous.add(user5);
        List<Analize.User> current = new ArrayList<>();
        current.add(user3);
        current.add(user4);
        current.add(user5);
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.getAdded(), is(1));
        assertThat(result.getChanged(), is(1));
        assertThat(result.getDeleted(), is(1));
    }
}