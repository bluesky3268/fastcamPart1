package org.example.ch6.mvc;

import org.example.ch6.annotation.RequestMethod;
import org.example.ch6.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandler {
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/home"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form"));
//        mappings.put(new HandlerKey(RequestMethod.POST, "/user/form"), new ForwardController("/users"));
    }

    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
