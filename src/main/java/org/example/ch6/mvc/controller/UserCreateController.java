package org.example.ch6.mvc.controller;

import org.example.ch6.model.User;
import org.example.ch6.mvc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserCreateController implements Controller{
    private static final Logger log = LoggerFactory.getLogger(UserCreateController.class);

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("[UserCreateController] handleRequest started");

        String userId = request.getParameter("userId");
        String name = request.getParameter("name");

        log.info("params - userId : {}, name : {}", userId, name);

        UserRepository.save(new User(userId, name));

        return "redirect:/users";
    }
}
