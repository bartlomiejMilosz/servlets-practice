package io.github.bartlomiejmilosz.servlets.formapp.controllers;

import io.github.bartlomiejmilosz.servlets.formapp.model.User;
import io.github.bartlomiejmilosz.servlets.formapp.util.DatabaseSimulator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userdata")
public class UserDataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setGender(request.getParameter("gender"));
        user.setHobbies(request.getParameterValues("hobbies"));

        int userId = DatabaseSimulator.saveUser(user);

        // Ustawienie ID użytkownika w sesji
        request.getSession().setAttribute("userId", userId);

        // Przekierowanie do userinfo.html z dodaniem ID użytkownika jako parametru
        response.sendRedirect(request.getContextPath() + "/formappresources/userinfo.html?userId=" + userId);
    }
}
