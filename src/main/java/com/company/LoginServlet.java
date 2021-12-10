package com.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginDao loginDao = new LoginDao();
        if (loginDao.validateAdmin(email, password)) {
            request.getSession().setAttribute("username", email);
            Cookie cookie = new Cookie("UID", email);
            cookie.setPath("/contactus");
            response.addCookie(cookie);
            response.sendRedirect("./dashboard");
        } else {
            request.setAttribute("error", "Invalid username or password");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}