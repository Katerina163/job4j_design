package ru.job4j.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {
    public static Info diff(List<User> previous, List<User> current) {
        Info check = new Info();
        int currSize = current.size();
        Map<Integer, String> users = new HashMap<>();
        for (User u : previous) {
            users.put(u.id, u.name);
        }
        for (User u : current) {
            users.put(u.id, u.name);
        }
        current.removeAll(previous);
        check.added = users.size() - previous.size();
        check.changed = current.size() - check.added;
        int nochanged = current.size() - check.added;
        check.deleted = previous.size() - nochanged - check.changed;
        return check;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        private int added = 0;
        private int changed = 0;
        private int deleted = 0;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
