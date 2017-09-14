/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.controller;

import com.fpt.adf2.assignment.filehandle.FileHandle;
import java.util.Scanner;

/**
 *
 * @author Nam Nguyen
 */
public class MenuConsole {

    public void creatMenu() {
        while (true) {
            System.out.println("==============Employee Manager============");
            System.out.println("1. List Employee ");
            System.out.println("2. Add Employee");
            System.out.println("3. Edit Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Export Employee");
            System.out.println("6. Inport Employee");
            System.out.println("7. Exit");
            System.out.println("===========================================");
            System.out.println("Please enter your choice: ");

            String choice;
            int inChoice = 0;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine();
            try {
                inChoice = Integer.parseInt(choice); // Ép kiểu.
            } catch (Exception e) {
                System.err.println("Please enter number: ");
                continue;
            }

            EmployeeController employeeController = new EmployeeController();
            FileHandle fileHandle = new FileHandle();

            if (inChoice == 7) {
                break;
            } else {
                switch (inChoice) {
                    case 1:
                        System.out.println("=============List Employee==============");
                        employeeController.getList();
                        break;
                    case 2:
                        System.out.println("=============Add Employee===============");
                        employeeController.addEmployee();
                        break;
                    case 3:
                        System.out.println("=============Edit Employee==============");
                        employeeController.editEmployee();
                        break;
                    case 4:
                        System.out.println("=============Delete Employee=============");
                        employeeController.deleteEmployee();
                        break;
                    case 5:
                        System.out.println("=============Export Employee=============");
                        fileHandle.exportFile();
                        break;
                    case 6:
                        System.out.println("=============Import Employee==============");
                        fileHandle.importFlile();
                        break;
                    default:

                }
            }
        }

    }
}
