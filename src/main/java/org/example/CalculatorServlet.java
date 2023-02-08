package org.example;

import org.example.ch3.calculator.Calculator2;
import org.example.ch3.calculator.operator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    /**
     * Servlet을 구현할 때는 내가 필요하지 않은 모든 메서드들을 다 오버라이드 해야 하지만
     * GenericServlet을 상속받으면 내가 필요한 메서드만 구현해주면 된다.
     * HttpServlet을 상속받으면 doGet(), doPost() 등 요청 메서드에 맞춰서 구현해주면 된다.
     */

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    private ServletConfig servletConfig;

    /**
     * HttpServlet 상속 후 오버라이드
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        log.info("operator : " + operator); // +는 URL예약어 -> 인코딩해줘야 한다.

        int result = Calculator2.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        response.getWriter().println(result);
    }



    /**
     * Servlet 구현 시
     */
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        log.info("init");
//        this.servletConfig = config;
//    }
//
//    @Override
//    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//        log.info("service");
//        int operand1 = Integer.parseInt(request.getParameter("operand1"));
//        String operator = request.getParameter("operator");
//        int operand2 = Integer.parseInt(request.getParameter("operand2"));
//
//        int result = Calculator2.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
//
//        response.getWriter().println(result);
//    }
//
//    @Override
//    public void destroy() {
//        log.info("destroy");
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return null;
//    }
//
//    @Override
//    public String getServletInfo() {
//        return null;
//    }

}
