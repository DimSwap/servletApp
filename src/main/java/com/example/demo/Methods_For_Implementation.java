package com.example.demo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Methods_For_Implementation {
   public static PreparedStatement connectionSql(String sql) throws SQLException {
      Connection connection = EmployeeRepository.getConnection();
      return connection.prepareStatement(sql);
   }



   public static Employee columnIndex(ResultSet rs) throws SQLException {
      Employee employee = new Employee();
      employee.setId(rs.getInt(1));
      employee.setName(rs.getString(2));
      employee.setEmail(rs.getString(3));
      employee.setCountry(rs.getString(4));
      return employee;
   }

   public static Employee getParameterSave(HttpServletRequest request,String name, String email, String country) throws IOException {
      String name1 = request.getParameter(name);
      String email1 = request.getParameter(email);
      String country1 = request.getParameter(country);
      Employee employee = new Employee();
      employee.setName(name1);
      employee.setEmail(email1);
      employee.setCountry(country1);
      return employee;
   }

   public static void status(HttpServletResponse response,int status) throws IOException {
      PrintWriter out = response.getWriter();
      if (status > 0) {
         out.println("Record saved successfully!");
      } else {
         out.println("Sorry! unable to save record");
      }
      out.close();
   }

   public static void statusPut(HttpServletResponse response,int status) throws IOException {
      PrintWriter out = response.getWriter();
      if (status > 0) {
         response.sendRedirect("viewServlet");
      } else {
         out.println("Sorry! unable to update record");
      }
      out.close();
   }

   public static Employee getParameterPut(HttpServletRequest request,String name, String email, String id) {
      String sid = request.getParameter(id);
      int id1 = Integer.parseInt(sid);
      String name1 = request.getParameter(name);
      String email1 = request.getParameter(email);

      Employee employee = new Employee();
      employee.setId(id1);
      employee.setName(name1);
      employee.setEmail(email1);
      employee.setCountry(request.getParameter("country"));
      return employee;
   }
   public static void forList(HttpServletResponse response,List<Employee> list) throws IOException {
      PrintWriter out = response.getWriter();
      for (Employee employee : list) {

         out.print(employee);
      }
      out.close();
   }
}