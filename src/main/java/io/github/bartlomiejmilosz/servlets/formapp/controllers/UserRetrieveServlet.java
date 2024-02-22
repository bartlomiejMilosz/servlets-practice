package io.github.bartlomiejmilosz.servlets.formapp.controllers;

import com.google.gson.Gson;
import io.github.bartlomiejmilosz.servlets.formapp.model.User;
import io.github.bartlomiejmilosz.servlets.formapp.util.DatabaseSimulator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/getUserData")
public class UserRetrieveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = DatabaseSimulator.getUser(userId);

        String userJson = new Gson().toJson(user);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(userJson);
    }
}