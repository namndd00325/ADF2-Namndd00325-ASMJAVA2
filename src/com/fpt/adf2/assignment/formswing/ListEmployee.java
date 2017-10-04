/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.formswing;

import com.fpt.adf2.assignment.enity.Employee;
import com.fpt.adf2.assignment.model.EmployeeModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nam Nguyen
 */
public class ListEmployee extends JFrame {

    private JTable table;
    private Employee emp;

    EmployeeModel empModel = new EmployeeModel();
    ArrayList<Employee> list = empModel.getList();

    public ListEmployee() {
        this.table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Birthday");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone number");
        tableModel.addColumn("Address");

        for (Employee emp : list) {
            Object[] str = new Object[]{emp.getId(), emp.getName(), emp.getBirthday(), emp.getEmmail(), emp.getPhoneNumber(), emp.getAddress()};
            tableModel.addRow(str);
        }
        table.setModel(tableModel);
        table.addMouseListener(new ListHandle());
        setSize(800, 300);
        setTitle("List Employee");
        add(new JScrollPane(table));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    class ListHandle implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            int rowIndex = table.getSelectedRow();
            emp = list.get(rowIndex);
            Option op = new Option(emp);

        }

        @Override
        public void mousePressed(MouseEvent me) {

        }

        @Override
        public void mouseReleased(MouseEvent me) {

        }

        @Override
        public void mouseEntered(MouseEvent me) {

        }

        @Override
        public void mouseExited(MouseEvent me) {

        }
    }

}
