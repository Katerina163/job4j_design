package ru.job4j.mail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mail {
    public static Map<String, Set<String>> merger(List<User> users) {
        Map<String, Set<String>> result = new HashMap<>();
        Map<String, User> mailUser = new HashMap<>(); //ключ почта, значение имя юзера
        for (User user : users) {
            User name = new User();
            for (String mail : user.getMails()) {
                if (mailUser.containsKey(mail)) { //если почта встречается
                    name = mailUser.get(mail);
                }
            }
            if (name.getName() != null) {
                for (String mail : user.getMails()) {
                    name.addMail(mail);
                    mailUser.put(mail, name);
                }
            } else {
                result.put(user.getName(), user.getMails());
                for (String mail : user.getMails()) {
                    mailUser.put(mail, user);
                }
            }
        }
        return result;
    }
}
