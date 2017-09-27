/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.javaswing.ex2;

import com.fpt.adf2.assignment.enity.Employee;
import com.fpt.adf2.assignment.model.EmployeeModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Nam Nguyen
 */
public class LoginForm extends JFrame {

    private JLabel lblID;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblDate;
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JSpinner txtDate;
    private JButton btnSubmit;
    private JButton btnReset;
    private JLabel lblTotalMessage;
    private JLabel lblIDMessage;
    private JLabel lblNameMessage;
    private JLabel lblPhoneMessage;
    private JLabel lblEmailMessage;
    
    

    public LoginForm() {
        this.setSize(850, 400);
        this.setLocationRelativeTo(null);

        this.lblID = new JLabel("ID Student");
        this.lblName = new JLabel("Name");
        this.lblDate = new JLabel("Birthday");
        this.lblEmail = new JLabel("Email");
        this.lblPhone = new JLabel("Phone");
        this.txtID = new JTextField();
        this.txtName = new JTextField();
        //this.txtDate = new JTextField();
        this.txtPhone= new JTextField();
        this.txtEmail = new JTextField();
         this.txtPhone = new JTextField();
        this.btnSubmit = new JButton("Submit");
        this.btnReset = new JButton("Reset");
        this.lblTotalMessage= new JLabel();
        this.lblNameMessage= new JLabel();
        this.lblIDMessage= new JLabel();
        this.lblPhoneMessage= new JLabel();
        this.lblEmailMessage= new JLabel();
        
        this.lblTotalMessage.setBounds(200, 10, 300, 25);
        this.lblIDMessage.setBounds(500, 40, 300, 30);
        this.lblNameMessage.setBounds(500, 80,300 , 30);
        this.lblPhoneMessage.setBounds(500,200, 300, 30);
        this.lblEmailMessage.setBounds(500, 160, 300, 30);
        this.lblID.setBounds(100, 40, 100, 30);
        this.txtID.setBounds(230, 40, 250, 30);

        this.lblName.setBounds(100, 80, 100, 30);
        this.txtName.setBounds(230, 80, 250, 30);
        
        // check date
        SpinnerDateModel spinnerDate = new SpinnerDateModel();
        this.txtDate = new JSpinner(spinnerDate);
        this.txtDate.setEditor(new JSpinner.DateEditor(this.txtDate, "dd/MM/yyyy"));
        this.lblDate.setBounds(100, 120, 100, 30);
        this.txtDate.setBounds(230, 120, 250, 30);

        this.lblEmail.setBounds(100, 160, 100, 30);
        this.txtEmail.setBounds(230, 160, 250, 30);
        
          //check phone
       
        this.lblPhone.setBounds(100, 200, 100, 30);
        this.txtPhone.setBounds(230, 200, 250, 30);

        this.btnSubmit.setBounds(250, 240, 90, 30);
        this.btnReset.setBounds(370, 240, 90, 30);

        this.btnSubmit.addActionListener(new SubmitHandle());
        this.btnReset.addActionListener(new ResetHandle());

        this.add(lblID);
        this.add(lblName);
        this.add(txtID);
        this.add(txtName);
        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblPhone);
        this.add(txtPhone);
        this.add(btnReset);
        this.add(btnSubmit);
        this.add(lblDate);
        this.add(txtDate);
        this.add(lblTotalMessage);
        this.add(lblIDMessage);
        this.add(lblNameMessage);
        this.add(lblPhoneMessage);
        this.add(lblEmailMessage);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class SubmitHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Employee emp = new Employee();
            EmployeeModel empModel = new EmployeeModel();
            
            try {
                emp.setId(Integer.parseInt(txtID.getText()));
            } catch (NumberFormatException e) {
                
            }

            emp.setName(txtName.getText());
            emp.setEmmail(txtEmail.getText());
            emp.setPhoneNumber(txtPhone.getText());
           // emp.setBirthday(txtDate.getT);
            // Gọi đến hàm validateForm() của class FormHandle để validate dữ liệu. 
            // Trong trường hợp không tồn tại lỗi thì hashmap trả về rỗng. Trong trường hợp, 
            // hashmap có giá trị thì hiển thị thông báo. 
            HashMap<String, String> errors = new ValidateHandle().validateLogin(emp);
            if (errors.size() == 0) { 
              resetMessage(); 
              empModel.insertEmployee(emp);
              JOptionPane.showConfirmDialog(null, "Are you want to insert employee?");
//                JOptionPane.showMessageDialog(null, "Submit Succsess! " + txtID.getText());  
           } else { 
                showError(errors); 
                
            } 
            

        }
    }
    public void resetMessage(){
        lblTotalMessage.setText("");
        lblIDMessage.setText("");
        lblNameMessage.setText("");
        lblPhoneMessage.setText("");
        lblEmailMessage.setText("");
        
    }
    private void showError(HashMap<String, String> errors){
        lblTotalMessage.setForeground(Color.red);
        lblTotalMessage.setText("*Vui lòng sửa các lỗi bên dưới và submit lại form!");
        if(errors.containsKey("txtID")){
            lblIDMessage.setForeground(Color.red);
            lblIDMessage.setText(errors.get("txtID"));
        }else{
            lblIDMessage.setForeground(Color.green);
            lblIDMessage.setText("Hợp lệ!");
        }
        if(errors.containsKey("txtName")){
            lblNameMessage.setForeground(Color.red);
            lblNameMessage.setText(errors.get("txtName"));
        }else{
            lblNameMessage.setForeground(Color.green);
            lblNameMessage.setText("Hợp lệ!");
        }
        if(errors.containsKey("txtPhone")){
            lblPhoneMessage.setForeground(Color.red);
            lblPhoneMessage.setText(errors.get("txtPhone"));
        }else{
            lblPhoneMessage.setForeground(Color.green);
            lblPhoneMessage.setText("Hợp lệ!");
        }
         if(errors.containsKey("txtEmail")){
            lblEmailMessage.setForeground(Color.red);
            lblEmailMessage.setText(errors.get("txtEmail"));
        }else{
            lblEmailMessage.setForeground(Color.green);
            lblEmailMessage.setText("Hợp lệ!");
        }
        
    }

    class ResetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            txtID.setText("");
            txtName.setText("");
           // txtDate.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
        }
    }
}
