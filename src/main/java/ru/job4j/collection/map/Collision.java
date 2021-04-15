package ru.job4j.collection.map;

import java.util.*;

public class Collision {
    public static void main(String[] args) {
        Calendar data = new GregorianCalendar(2000, 10, 10);
        User user1 = new User("user", 1, data);
        User user2 = new User("user", 1, data);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (var v : map.entrySet()) {
            System.out.println(v.getKey() + " " + v.getValue());
        }
    }
}
