package org.example.ch6.mvc.view.resolver;

import org.example.ch6.mvc.view.View;

public interface ViewResolver {
    View resolveView(String viewName);
}
