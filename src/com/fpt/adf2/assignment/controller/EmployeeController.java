/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.controller;

import com.fpt.adf2.assignment.enity.Employee;
import com.fpt.adf2.assignment.model.EmployeeModel;
import com.fpt.adf2.assignment.validate.Validate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nam Nguyen
 */
public class EmployeeController {

    private static ArrayList<Employee> listEmployee;
    private static EmployeeModel employeeModel = new EmployeeModel();
    private static Validate validate = new Validate();

    public void getList() {
        listEmployee = employeeModel.getList();

        for (Employee emp : listEmployee) {
            System.out.println(emp.getId() + ". " + emp.getName());
        }
//        System.out.println(listEmployee.toString());

    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter employee information.");
        System.out.println("Please enter name:");
        String name = scanner.nextLine();

        System.out.println("Please enter birthday:");
        String birthday = scanner.nextLine();

        System.out.println("Please enter email:");
        String email;
        //---------------- Validate email---------------------
        while (true) {
            email = scanner.nextLine();
            if (validate.valiEmail(email)) {
                break;
            } else {
                System.err.println("Incorrect Format Email! Please enter email:");
            }
        }

        System.out.println("Please enter phone number:");
        String phone = scanner.nextLine();

        System.out.println("Please enter address:");
        String address = scanner.nextLine();

        Employee emp = new Employee();
        emp.setName(name);
        emp.setBirthday(birthday);
        emp.setEmmail(email);
        emp.setPhoneNumber(phone);
        emp.setAddress(address);

        employeeModel.insertEmployee(emp);

    }

    public void editEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the employee ID that you want to edit:");
        int id = scanner.nextInt();

        //check và tìm nhân viên theo id, sửa thông tin
        Employee oldEmployee = employeeModel.getById(id);
        if (oldEmployee != null) {
            System.out.println("===========Information Employee==============");
            System.out.println("ID: " + oldEmployee.getId());
            System.out.println("Name: " + oldEmployee.getName());
            System.out.println("Birthday: " + oldEmployee.getBirthday());
            System.out.println("Email: " + oldEmployee.getEmmail());
            System.out.println("Phone Number: " + oldEmployee.getPhoneNumber());
            System.out.println("Address: " + oldEmployee.getAddress());

            System.out.println("Please enter new name (Press enter for skip): ");
            scanner.nextLine();
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                name = oldEmployee.getName();
            }

            System.out.println("Please enter new birthday (Press enter for skip): ");
            String birthday = scanner.nextLine();
            if (birthday.isEmpty()) {
                birthday = oldEmployee.getBirthday();
            }

            System.out.println("Please enter new email (Press enter for skip): ");
            //--------------------Validate Email--------------------
            String email;
            while (true) {
                email = scanner.nextLine();
                if (email.isEmpty()) {
                    email = oldEmployee.getEmmail();
                    if (validate.valiEmail(email)) {
                        break;
                    } else {
                        System.err.println("Incorrect Format Email! Please enter email:");
                    }
                }

            }

            System.out.println("Please enter new phone number (Press enter for skip): ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) {
                phoneNumber = oldEmployee.getPhoneNumber();
            }

            System.out.println("Please enter new address (Press enter for skip): ");
            String address = scanner.nextLine();
            if (address.isEmpty()) {
                address = oldEmployee.getAddress();
            }

            Employee newEmployee = new Employee(oldEmployee.getId(), name, birthday, email, phoneNumber, address);
            employeeModel.updateEmployee(newEmployee);
        } else {
            System.out.println("Not Found!");
        }

    }

    public void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the employee ID that you want to delete:");
        int id = scanner.nextInt();

        Employee employee = employeeModel.getById(id);
        if (employee != null) {
            System.out.println("===========Information Employee==============");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Birthday: " + employee.getBirthday());
            System.out.println("Email: " + employee.getEmmail());
            System.out.println("Phone Number: " + employee.getPhoneNumber());
            System.out.println("Address: " + employee.getAddress());

            employeeModel.deleteEmployee(id);
        } else {
            System.out.println("Not Found!");
        }

    }

}
