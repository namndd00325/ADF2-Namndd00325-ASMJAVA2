/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.formswing;

import com.fpt.adf2.assignment.enity.Employee;
import com.fpt.adf2.assignment.validate.Validate;
import java.util.HashMap;

/**
 *
 * @author Nam Nguyen
 */
public class ValidateAdd {

    public HashMap<String, String> validateAddEmp(Employee emp) {
        HashMap<String, String> errors = new HashMap<>();
        if (emp.getAddress().isEmpty()) {
            errors.put("txtAddress", "*Please enter address! ");
        }
        if (emp.getName().isEmpty()) {
            errors.put("txtName", "*Please enter name!");
        }
        if (emp.getEmmail().isEmpty()) {
            errors.put("txtEmail", "*Please enter Email!");
        } else if (Validate.valiEmail(emp.getEmmail()) == false) {
            errors.put("txtEmail", "*Incorrect format email. Exp:abc@xyz.com");
        }
        if (emp.getPhoneNumber().isEmpty()) {
            errors.put("txtPhone", "*Vui long nhap phone");
        } else if (Validate.valiPhoneNumber(emp.getPhoneNumber()) == false) {
            errors.put("txtPhone", "*Incorrect format phone. Exp: +841.. or +8491.. ");
        }
         if (emp.getBirthday().isEmpty()) {
            errors.put("txtDate", "*Please enter birthday");
        } else if (Validate.valiBirthday(emp.getBirthday()) == false) {
            errors.put("txtDate", "*Incorrect format date. Exp: 13/12/1995 ");
        }
        return errors;
    }

}
