/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.filehandle;

import com.fpt.adf2.assignment.enity.Employee;
import com.fpt.adf2.assignment.model.EmployeeModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nam Nguyen
 */
public class FileHandle {

    private static ArrayList<Employee> listEmployee;
    private static EmployeeModel employeeModel = new EmployeeModel();

    public void importFlile() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            String str;
            fr = new FileReader("listEmployee.txt");
            br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    public void exportFile() {
        listEmployee = employeeModel.getList();
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("listEmployee.txt");
            bw = new BufferedWriter(fw);

            for (Employee emp : listEmployee) {
                bw.write("ID: " + emp.getId());
                bw.newLine();
                bw.write("Name: " + emp.getName());
                bw.newLine();
                bw.write("Birthday: " + emp.getBirthday());
                bw.newLine();
                bw.write("Email: " + emp.getEmmail());
                bw.newLine();
                bw.write("Phone Number: " + emp.getPhoneNumber());
                bw.newLine();
                bw.write("Address: " + emp.getAddress());
                bw.newLine();
                bw.newLine();
            }
            System.out.println("Export File Success!");

        } catch (IOException e) {
            System.out.println("Export File False! " + e.getMessage());
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.err.println(e);
            }

        }
    }
}
