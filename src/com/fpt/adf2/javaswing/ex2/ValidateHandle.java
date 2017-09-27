/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.javaswing.ex2;

import com.fpt.adf2.assignment.enity.Employee;
import com.fpt.adf2.assignment.validate.Validate;
import java.util.HashMap;

/**
 *
 * @author Nam Nguyen
 */
public class ValidateHandle {
    public HashMap<String, String> validateLogin(Employee emp){
        HashMap<String, String> errors = new HashMap<>(); 
        if(emp.getId() == 0){
          errors.put("txtID", "* Vui long nhap ID");
        }
        if(emp.getName().isEmpty()){
            errors.put("txtName", "*Vui long nhap ten");
        }
        if(emp.getEmmail().isEmpty()){
            errors.put("txtEmail","*Vui long nhap email");
        }else if(Validate.valiEmail(emp.getEmmail())==false){
            errors.put("txtEmail","*Nhập đúng định dạng email. Ví dụ:abc@xyz.com");
        }
        if(emp.getPhoneNumber().isEmpty()){
            errors.put("txtPhone","*Vui long nhap phone");
        }else if(Validate.valiPhoneNumber(emp.getPhoneNumber())==false){
           errors.put("txtPhone","*Nhập đúng định dạng số phone. Ví dụ: +841234567890 "); 
        }
        return errors;
    }
    
}
