/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.formswing;

import com.fpt.adf2.assignment.enity.Employee;
import com.fpt.adf2.assignment.model.EmployeeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nam Nguyen
 */
public class Option extends JFrame {

    private JTable table;
    private JButton edit;
    private JButton delete;
    private Employee getEmp;
    EmployeeModel empModel = new EmployeeModel();
    ArrayList<Employee> list = empModel.getList();

    public Option(Employee emp) {
        this.table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Birthday");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone number");
        tableModel.addColumn("Address");

        Object[] str = new Object[]{emp.getId(), emp.getName(), emp.getBirthday(), emp.getEmmail(), emp.getPhoneNumber(), emp.getAddress()};
        tableModel.addRow(str);

        table.setModel(tableModel);

        setSize(800, 300);
        setTitle("Option");
        edit = new JButton("Edit");
        delete = new JButton("Delete");
        edit.setBounds(150, 100, 150, 50);
        delete.setBounds(400, 100, 150, 50);
        edit.addActionListener(new editHandle());
        delete.addActionListener(new DeleteHandle(emp));
        this.add(edit);
        this.add(delete);
        add(new JScrollPane(table));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getEmp = emp;
    }

    class editHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            EditEmployee editEmp = new EditEmployee(getEmp);
           
        }
    }

    class DeleteHandle implements ActionListener {
       private Employee emp; // null
       public DeleteHandle(Employee emp){
       this.emp = emp;
       }
        EmployeeModel empModel = new EmployeeModel();

        @Override
        public void actionPerformed(ActionEvent ae) {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to delete employee?");
            if (confirm == 0) {
                 empModel.deleteEmployee(emp.getId());
            }
        }

    }

}
