package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {
    @Test
    public void produce() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        Generator g = new GeneratorOne();
        assertThat(g.produce("I am a ${name}, Who are ${subject}?", map),
                is("I am a Petr Arsentev, Who are you?"));
    }

    @Test
    public void produceNullKeys() {
        Generator g = new GeneratorOne();
        assertThat(g.produce(
                "Привет!", new HashMap<String, String>()),
                is("Привет!"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFewKeys() {
        Generator g = new GeneratorOne();
        g.produce("${one}", new HashMap<String, String>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenManyKeys() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("one", "one");
        map.put("two", "two");
        Generator g = new GeneratorOne();
        g.produce("${one}", map);
    }
}