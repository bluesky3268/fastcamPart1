package org.example.ch6.mvc;

import org.example.ch6.annotation.RequestMethod;
import org.example.ch6.mvc.controller.Controller;
import org.example.ch6.mvc.view.ModelAndView;
import org.example.ch6.mvc.view.resolver.JspViewResolver;
import org.example.ch6.mvc.view.View;
import org.example.ch6.mvc.view.resolver.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 톰캣이 사용할 수 있도록 HttpServlet을 상속받아준다.

@WebServlet("/") // /경로(모든 경로)에 대해서 DispatcherServlet이 실행되도록 어노테이션 설정
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandler requestMappingHandler;

    private List<ViewResolver> viewResolvers;

    private List<HandlerAdapter> handlerAdapters;

    @Override
    public void init() throws ServletException {
        requestMappingHandler = new RequestMappingHandler();
        requestMappingHandler.init();

        viewResolvers = Collections.singletonList(new JspViewResolver());
        handlerAdapters = List.of(new SimpleControllerHandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started");

        try {
            Controller handler = requestMappingHandler.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI()));

            HandlerAdapter handlerAdapter = handlerAdapters.stream().filter(h -> h.supports(handler))
                    .findFirst().orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"));

            ModelAndView mv = handlerAdapter.handle(request, response, handler);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveView(mv.getView());
                view.render(mv.getModel(), request, response);
            }

        } catch (Exception e) {
            log.error("exception occurred : [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }
}
