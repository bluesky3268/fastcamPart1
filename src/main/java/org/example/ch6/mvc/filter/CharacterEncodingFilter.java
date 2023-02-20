package org.example.ch6.mvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {


    public static final String DEFAULT_CHARACTER_SET = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(DEFAULT_CHARACTER_SET);
        response.setCharacterEncoding(DEFAULT_CHARACTER_SET);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
