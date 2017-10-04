/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.formswing;

import com.fpt.adf2.assignment.enity.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Nam Nguyen
 */
public class FormMenu extends JFrame {

    private JMenuBar jmbMenu;
    private JMenu menu;
    private JMenuItem listEmp;
    private JMenuItem addEmp;

    public FormMenu() {
        this.setTitle("============Manager Employee===========");
        this.setSize(800, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        jmbMenu = new JMenuBar();
        menu = new JMenu("Menu");
        listEmp = new JMenuItem("List Employee");
        addEmp = new JMenuItem("Add Employee");

        setJMenuBar(jmbMenu);
        this.add(jmbMenu);
        jmbMenu.add(menu);
        menu.add(listEmp);
        menu.add(addEmp);

        listEmp.addActionListener(new ListEmp());
        addEmp.addActionListener(new AddEmp());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    class ListEmp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ListEmployee listEmp = new ListEmployee();
        }
    }

    class AddEmp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            AddEmployee addEmp = new AddEmployee();
        }
    }

    public static void main(String[] args) {
        FormMenu formMenu = new FormMenu();
    }
}
