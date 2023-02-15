package org.example.ch6.controller;

import org.example.ch6.annotation.Controller;
import org.example.ch6.annotation.RequestMapping;
import org.example.ch6.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WorkController {

    @RequestMapping(method = RequestMethod.GET, value = "/work1")
    public String work1(HttpServletRequest request, HttpServletResponse response) {
        return "work1";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/work2")
    public String work2(HttpServletRequest request, HttpServletResponse response) {
        return "work2";
    }
}
