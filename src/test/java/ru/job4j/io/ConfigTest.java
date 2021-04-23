package ru.job4j.io;

import org.junit.Test;
import java.lang.IllegalArgumentException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = ".\\data\\pair_without_comment.properties.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }

    @Test
    public void whenComment() {
        String path = ".\\data\\pair_with_comment_properties.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBreaking() {
        String path = ".\\data\\pair_with_comment_breaking.txt";
        Config config = new Config(path);
        config.load();
    }
}