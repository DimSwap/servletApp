package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public static void main(String[] args) throws SQLException {
        getConnection();

        Employee employee = new Employee();

        employee.setName("Dima");
        employee.setEmail("logu123dima@gmail.com");
        employee.setCountry("UK");
        save(employee);
    }

    public static Connection getConnection() {

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "admin";

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        return connection;
    }

    public static int save(Employee employee) throws SQLException {
        int status = 0;
        try {
            PreparedStatement ps = Methods_For_Implementation.connectionSql("insert into users(name,email,country) values (?,?,?)");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getCountry());
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(Employee employee) throws SQLException {

        int status = 0;

        try {
            PreparedStatement ps = Methods_For_Implementation.connectionSql("update users set name=?,email=?,country=? where id=?");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getCountry());
            ps.setInt(4, employee.getId());
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) throws SQLException {

        int status = 0;

        try {
            PreparedStatement ps = Methods_For_Implementation.connectionSql("delete from users where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return status;
    }

    public static Employee getEmployeeById(int id) throws SQLException {

        Employee employee = new Employee();

        try {
            PreparedStatement ps = Methods_For_Implementation.connectionSql("select * from users where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Methods_For_Implementation.columnIndex(rs);
            }
            ps.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getAllEmployees() throws SQLException {

        List<Employee> listEmployees = new ArrayList<>();

        try {
            PreparedStatement ps = Methods_For_Implementation.connectionSql("select * from users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listEmployees.add( Methods_For_Implementation.columnIndex(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployees;
    }
}
