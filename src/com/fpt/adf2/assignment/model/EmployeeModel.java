/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.model;

import com.fpt.adf2.assignment.enity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nam Nguyen
 */
public class EmployeeModel {

    public ArrayList<Employee> getList() {
        ArrayList<Employee> listEmployee = new ArrayList<>();
        try {
            String sql = "SELECT * FROM employee";
            Connection cnn = DAO.getConnection();

//            Statement stt = cnn.createStatement();
            PreparedStatement preStt = cnn.prepareStatement(sql);
            ResultSet rss = preStt.executeQuery();

            while (rss.next()) {
                Employee employee = new Employee();
                employee.setId(rss.getInt("id"));
                employee.setName(rss.getString("name"));
                employee.setBirthday(rss.getString("birthday"));
                employee.setEmmail(rss.getString("email"));
                employee.setPhoneNumber(rss.getString("phone_number"));
                employee.setAddress(rss.getString("address"));
                listEmployee.add(employee);
            }

        } catch (SQLException e) {

            System.err.println("Loi " + e.getMessage());
        }
        return listEmployee;

    }

    public void insertEmployee(Employee employee) {
        try {
            String sql = "INSERT INTO employee (name, birthday, email, phone_number, address) VALUE(?, ?, ?, ?, ?);";

            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement(sql);
            preStt.setString(1, employee.getName());
            preStt.setString(2, employee.getBirthday());
            preStt.setString(3, employee.getEmmail());
            preStt.setString(4, employee.getPhoneNumber());
            preStt.setString(5, employee.getAddress());
            preStt.execute();

            System.out.println("Insert success!");
        } catch (SQLException e) {
            System.err.println("Insert Data False! " + e.getMessage());
        }

    }

    public static void main(String[] args) {

    }

    public void updateEmployee(Employee employee) {
        try {
            String sql = "UPDATE employee SET name=? , birthday=? , email=?, phone_number=? , address=? Where id=?;";
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement(sql);

            preStt.setString(1, employee.getName());
            preStt.setString(2, employee.getBirthday());
            preStt.setString(3, employee.getEmmail());
            preStt.setString(4, employee.getPhoneNumber());
            preStt.setString(5, employee.getAddress());
            preStt.setInt(6, employee.getId());

            int rowsUpdate = preStt.executeUpdate();
            if (rowsUpdate > 0) {
                System.out.println("Update Success! ");
            }

        } catch (SQLException e) {
            System.out.println("Update Data False! " + e.getMessage());
        }

    }

    public void deleteEmployee(int id) {
        try {
            String sql = "DELETE FROM employee WHERE id=? ;";
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement(sql);
            preStt.setInt(1, id);
            int rowsDelete = preStt.executeUpdate();
            if (rowsDelete > 0) {
                System.out.println("Delete Date Success! ");
            }
        } catch (SQLException e) {
            System.out.println("Delete Data False! " + e.getMessage());
        }

    }

    public Employee getById(int id) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("SELECT * FROM employee where id=?;");
            preStt.setInt(1, id);
            ResultSet rss = preStt.executeQuery();
            if (rss.next()) {
                Employee employee = new Employee();
                employee.setId(rss.getInt("id"));
                employee.setName(rss.getString("name"));
                employee.setBirthday(rss.getString("birthday"));
                employee.setEmmail(rss.getString("email"));
                employee.setPhoneNumber(rss.getString("phone_number"));
                employee.setAddress(rss.getString("address"));

                return employee;
            }
        } catch (SQLException e) {
            System.out.println("False " + e.getMessage());
        }

        return null;
    }

}
