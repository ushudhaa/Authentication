package com.authentication.user.controller;

import com.authentication.user.DAO.UserDAO;
import com.authentication.user.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserModel user = userDAO.getUserDetail(email);

        if (user == null) {
            req.setAttribute("error", "User not found!!");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("error", "Invalid  credentials");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
        }
            req.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
