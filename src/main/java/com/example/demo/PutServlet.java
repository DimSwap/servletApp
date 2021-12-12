package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/putServlet")
public class PutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        int status = 0;
        try {
            status = EmployeeRepository.update(Methods_For_Implementation.getParameterPut(request,"name","email","id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Methods_For_Implementation.statusPut(response,status);
    }
}