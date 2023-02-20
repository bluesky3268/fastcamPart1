package org.example.ch6.mvc;

import org.example.ch6.mvc.controller.Controller;
import org.example.ch6.mvc.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandler {
    private Map<String, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put("/", new HomeController());
    }

    public Controller findHandler(String urlPath) {
        return mappings.get(urlPath);
    }
}
