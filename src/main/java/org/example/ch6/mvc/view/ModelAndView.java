package org.example.ch6.mvc.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private Object view;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(String viewName) {
        this.view = viewName;
    }

    public String getView() {
        return this.view instanceof String ? (String) this.view : null;
    }

    public Map<String, ?> getModel() {
        return Collections.unmodifiableMap(model);
    }
}
