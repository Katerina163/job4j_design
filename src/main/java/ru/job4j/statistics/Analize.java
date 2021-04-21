package ru.job4j.statistics;

import java.util.List;
import java.util.Objects;

public class Analize {
    public static Info diff(List<User> previous, List<User> current) {
        Info check = new Info();
        int sizeCurr = current.size();
        current.removeAll(previous);
        for (User uc : current) {
            for (User up : previous) {
                if (uc.id == up.id && !uc.name.equals(up.name)) {
                    check.changed++;
                    current.remove(uc);
                }
            }
        }
        check.added = current.size();
        check.deleted = previous.size() + check.added - sizeCurr;
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
        private int added;
        private int changed;
        private int deleted;

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
