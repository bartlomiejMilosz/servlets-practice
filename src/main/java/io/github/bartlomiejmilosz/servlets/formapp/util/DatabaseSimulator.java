package io.github.bartlomiejmilosz.servlets.formapp.util;

import io.github.bartlomiejmilosz.servlets.formapp.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DatabaseSimulator {
    private static final Map<Integer, User> users = new HashMap<>();
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    public static int saveUser(User user) {
        int userId = ID_GENERATOR.incrementAndGet();
        users.put(userId, user);
        return userId;
    }

    public static User getUser(int userId) {
        return users.get(userId);
    }
}
