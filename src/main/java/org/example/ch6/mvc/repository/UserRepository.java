package org.example.ch6.mvc.repository;

import org.example.ch6.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);

    private static Map<String, User> users = new HashMap<>();

    public static void save(User user) {
        users.put(user.getId(), user);
        log.info("saved user {}", user);
    }

    public static Collection<User> findAll() {
        return users.values();
    }
}
