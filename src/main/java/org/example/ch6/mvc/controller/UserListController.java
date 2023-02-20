package org.example.ch6.mvc.controller;

import org.example.ch6.mvc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListController implements Controller{

    private static final Logger log = LoggerFactory.getLogger(UserListController.class);
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("[UserListController] handleRequest started");
        request.setAttribute("users", UserRepository.findAll());
        return "/user/list";
    }
}
