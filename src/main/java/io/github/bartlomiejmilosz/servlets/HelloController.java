package io.github.bartlomiejmilosz.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/headers")
public class HelloController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        printUserAgent(request);
        System.out.println("----------------------");
        printAllHeaders(request);
    }

    private static void printAllHeaders(HttpServletRequest request) {
        System.out.println("All Headers:");
        Enumeration<String> headersNames = request.getHeaderNames();
        /*while (headersNames.hasMoreElements()) {
            String nextHeaderName = headersNames.nextElement();
            System.out.println(nextHeaderName + " " + request.getHeader(nextHeaderName));
        }*/
        Collections.list(headersNames).stream()
                .map(name -> name + " " + request.getHeader(name))
                .forEach(System.out::println);
    }

    private static void printUserAgent(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        System.out.println("Client Browser: " + userAgent);
    }
}
