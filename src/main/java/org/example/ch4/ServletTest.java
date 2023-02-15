package org.example.ch4;

import org.example.CalculatorServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet("/test")
public class ServletTest extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(ServletTest.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[GET] /test {}", getNowTime());



        Enumeration<String> headerNames = request.getHeaderNames();
        Iterator<String> headerIter = headerNames.asIterator();
        while (headerIter.hasNext()) {
            String next = headerIter.next();
            log.info("{} : {}", next, request.getHeader(next));
        }

        response.getWriter().write("200");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[POST] /test {}", getNowTime());

        Enumeration<String> headerNames = request.getHeaderNames();
        Iterator<String> headerIter = headerNames.asIterator();
        while (headerIter.hasNext()) {
            String next = headerIter.next();
            log.info("{} : {}", next, request.getHeader(next));
        }

        System.out.println(request.getParameter("grant_type"));
        System.out.println("=======================================");
        System.out.println(request.getAttribute("grant_type"));
        System.out.println(request.getAttribute("client_id"));
        System.out.println(request.getAttribute("client_secret"));
        System.out.println(request.getAttribute("scope"));

        response.getWriter().write("200");
    }

    private String getNowTime() {
        long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        return sdf.format(new Date(now));
    }
}
