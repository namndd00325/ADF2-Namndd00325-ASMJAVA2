/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.formswing;

import com.fpt.adf2.assignment.enity.Employee;
import com.fpt.adf2.assignment.model.EmployeeModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Nam Nguyen
 */
public class EditEmployee extends JFrame {

    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblDate;
    private JLabel lblAddress;
    private JTextField txtAddress;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JFormattedTextField txtDate;
    private JButton btnUpdate;
    private JLabel lblTotalMessage;
    private JLabel lblAddressMessage;
    private JLabel lblNameMessage;
    private JLabel lblPhoneMessage;
    private JLabel lblEmailMessage;
    private JLabel lblBirthdayMessage;

    public EditEmployee(Employee oldEmp) {
        
        this.setTitle("Edit Employee");
        this.setSize(800, 600);

        lblName = new JLabel("New Name");
        lblDate = new JLabel("New Birthday");
        lblPhone = new JLabel("New Number");
        lblEmail = new JLabel("New Email");
        lblAddress = new JLabel("New Address");
        lblTotalMessage = new JLabel();
        lblNameMessage = new JLabel();
        lblPhoneMessage = new JLabel();
        lblEmailMessage = new JLabel();
        lblAddressMessage = new JLabel();
        lblBirthdayMessage = new JLabel();

        txtName = new JTextField();
        try {
            txtDate = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtEmail = new JTextField();
        txtPhone = new JTextField();
        txtAddress = new JTextField();

        btnUpdate = new JButton("Update");

        lblName.setBounds(100, 100, 100, 40);
        lblDate.setBounds(100, 150, 100, 40);
        lblEmail.setBounds(100, 200, 100, 40);
        lblPhone.setBounds(100, 250, 100, 40);
        lblAddress.setBounds(100, 300, 100, 40);
        txtName.setBounds(220, 100, 250, 40);
        txtDate.setBounds(220, 150, 250, 40);
        txtEmail.setBounds(220, 200, 250, 40);
        txtPhone.setBounds(220, 250, 250, 40);
        txtAddress.setBounds(220, 300, 250, 40);
        btnUpdate.setBounds(300, 350, 100, 40);

        lblTotalMessage.setBounds(250, 50, 300, 40);
        lblNameMessage.setBounds(490, 100, 250, 40);
        lblBirthdayMessage.setBounds(490, 150, 250, 40);
        lblEmailMessage.setBounds(490, 200, 250, 40);
        lblPhoneMessage.setBounds(490, 250, 300, 40);
        lblAddressMessage.setBounds(490, 300, 250, 40);
        this.add(lblName);
        this.add(lblDate);
        this.add(lblEmail);
        this.add(lblPhone);
        this.add(lblAddress);
        this.add(txtName);
        this.add(txtDate);
        this.add(txtEmail);
        this.add(txtPhone);
        this.add(txtAddress);
        this.add(btnUpdate);

        this.add(lblTotalMessage);
        this.add(lblAddressMessage);
        this.add(lblEmailMessage);
        this.add(lblPhoneMessage);
        this.add(lblNameMessage);
        this.add(lblBirthdayMessage);

        btnUpdate.addActionListener(new UpdateHandle(oldEmp));
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void resetMessage() {
        lblTotalMessage.setText("");
        lblAddressMessage.setText("");
        lblNameMessage.setText("");
        lblPhoneMessage.setText("");
        lblEmailMessage.setText("");
        lblBirthdayMessage.setText("");
    }

    public void showError(HashMap<String, String> errors) {
        lblTotalMessage.setForeground(Color.red);
        lblTotalMessage.setText("*Please enter new information!");

        if (errors.containsKey("txtName")) {
            lblNameMessage.setForeground(Color.red);
            lblNameMessage.setText(errors.get("txtName"));
        } else {
            lblNameMessage.setForeground(Color.green);
            lblNameMessage.setText("Correct!");
        }
        if (errors.containsKey("txtPhone")) {
            lblPhoneMessage.setForeground(Color.red);
            lblPhoneMessage.setText(errors.get("txtPhone"));
        } else {
            lblPhoneMessage.setForeground(Color.green);
            lblPhoneMessage.setText("Correct!");
        }
        if (errors.containsKey("txtEmail")) {
            lblEmailMessage.setForeground(Color.red);
            lblEmailMessage.setText(errors.get("txtEmail"));
        } else {
            lblEmailMessage.setForeground(Color.green);
            lblEmailMessage.setText("Correct!");
        }
        if (errors.containsKey("txtAddress")) {
            lblAddressMessage.setForeground(Color.red);
            lblAddressMessage.setText(errors.get("txtAddress"));
        } else {
            lblAddressMessage.setForeground(Color.green);
            lblAddressMessage.setText("Correct!");
        }
        if (errors.containsKey("txtDate")) {
            lblBirthdayMessage.setForeground(Color.red);
            lblBirthdayMessage.setText(errors.get("txtDate"));
        } else {
            lblBirthdayMessage.setForeground(Color.green);
            lblBirthdayMessage.setText("Correct!");
        }
    }

    class UpdateHandle implements ActionListener {

        private Employee oldEmp;

        public UpdateHandle(Employee oldEmp) {
            this.oldEmp = oldEmp;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            Employee emp = new Employee();
            EmployeeModel empModel = new EmployeeModel();
            emp.setId(oldEmp.getId());
            emp.setName(txtName.getText());
            emp.setBirthday(txtDate.getText());
            emp.setEmmail(txtEmail.getText());
            emp.setPhoneNumber(txtPhone.getText());
            emp.setAddress(txtAddress.getText());

            HashMap<String, String> errors = new ValidateEdit().validateEditEmp(emp);
            if (errors.size() == 0) {
                resetMessage();

                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to update employee?");
                if (confirm == 0) {
                    empModel.updateEmployee(emp);
                    JOptionPane.showMessageDialog(null, "Update data success!");
                    txtName.setText("");
                    txtDate.setText("");
                    txtEmail.setText("");
                    txtPhone.setText("");
                    txtAddress.setText("");
                    txtDate.setText("");
                }
            } else {
                showError(errors);
            }
        }
    }
}
