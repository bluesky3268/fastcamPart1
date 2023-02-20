package org.example.ch6.mvc.controller;

import org.example.ch6.mvc.DispatcherServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller{

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("[HomeController] handleRequest started");
        return "home";
    }
}
