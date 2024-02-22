package io.github.bartlomiejmilosz.servlets.divisors;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/divisors")
public class DivisorsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nParam = request.getParameter("n");
        if (nParam == null || nParam.isEmpty()) {
            response.sendError(400, "Brak parametru N");
        } else {
            int number = Integer.parseInt(nParam);
            String responseBody = createHtmlResponse(number);
            response.setContentType("text/html");
            response.getWriter().println(responseBody);
        }
    }

    private String createHtmlResponse(int number) {
        List<Integer> divisors = DivisorsFinder.getDivisors(number);
        String divisorsList;
        if (number == 0)
            divisorsList = "<li>Liczba 0 ma nieskończenie wiele dzielników</li>";
        else {
            divisorsList = divisors.stream()
                    .map(divisor -> "<li>" + divisor + "</li>")
                    .collect(Collectors.joining());
        }
        String htmlTemplate =
                """
                        <html>
                            <body>
                                <h1>Podzieliniki liczby %d</h1>
                                <ul>
                                    %s
                                </ul>
                            </body>
                        </html>
                        """;
        return String.format(htmlTemplate, number, divisorsList);
    }
}