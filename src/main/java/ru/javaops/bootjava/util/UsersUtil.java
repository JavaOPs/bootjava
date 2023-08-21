package ru.javaops.bootjava.util;

import lombok.experimental.UtilityClass;
import ru.javaops.bootjava.model.Role;
import ru.javaops.bootjava.model.User;
import ru.javaops.bootjava.to.UserTo;

@UtilityClass
public class UsersUtil {

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.USER);
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }
}