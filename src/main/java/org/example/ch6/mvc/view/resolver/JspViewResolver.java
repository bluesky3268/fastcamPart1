package org.example.ch6.mvc.view.resolver;

import org.example.ch6.mvc.view.JspView;
import org.example.ch6.mvc.view.RedirectView;
import org.example.ch6.mvc.view.View;

import static org.example.ch6.mvc.view.RedirectView.DEFAULT_REDIRECT_PREFIX;

public class JspViewResolver implements ViewResolver{
    @Override
    public View resolveView(String viewName) {
        if(viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) return new RedirectView(viewName);
        else return new JspView(viewName + ".jsp");
    }
}
