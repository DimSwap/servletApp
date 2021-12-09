package com.example.demo.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Это название 2-х параметров, которые мы передаем
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginStructure.InitMap();
        LoginStructure.InitList();
//        if (LoginStructure.checkInList(login, password)) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", "user");
//            //setting session to expiry in 30 mins
//            session.setMaxInactiveInterval(30 * 60);
//            Cookie userName = new Cookie("user", login);
//            userName.setMaxAge(30 * 60);
//            response.addCookie(userName);
//            PrintWriter out = response.getWriter();
//            out.println("Welcome back to the team, " + login + "!");
//        } else {
//            PrintWriter out = response.getWriter();
//            out.println("Either user name or password is wrong!");
//        }
//    }
        if (LoginStructure.checkInMap(login, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "user");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie("user", login);
            userName.setMaxAge(30 * 60);
            response.addCookie(userName);
            PrintWriter out = response.getWriter();
            out.println("Welcome back to the team, " + login + "!");
        } else {
            PrintWriter out = response.getWriter();
            out.println("Either user name or password is wrong!");
        }
    }
}
