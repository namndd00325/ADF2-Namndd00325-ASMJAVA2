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
public class ValidateEdit {
    public HashMap<String, String> validateEditEmp(Employee emp) {
        HashMap<String, String> errors = new HashMap<>();
        if (emp.getAddress().isEmpty()) {
            errors.put("txtAddress", "*Please enter  new address! ");
        }
        if (emp.getName().isEmpty()) {
            errors.put("txtName", "*Please enter new name!");
        }
        if (emp.getEmmail().isEmpty()) {
            errors.put("txtEmail", "*Please enter new email!");
        } else if (Validate.valiEmail(emp.getEmmail()) == false) {
            errors.put("txtEmail", "*Incorrect format email. Exp:abc@xyz.com");
        }
        if (emp.getPhoneNumber().isEmpty()) {
            errors.put("txtPhone", "*Please enter new phone number");
        } else if (Validate.valiPhoneNumber(emp.getPhoneNumber()) == false) {
            errors.put("txtPhone", "*Incorrect format phone number. Exp: +841.. or +8491.. ");
        }
         if (emp.getBirthday().isEmpty()) {
            errors.put("txtDate", "*Please enter  new birthday");
        } else if (Validate.valiBirthday(emp.getBirthday()) == false) {
            errors.put("txtDate", "*Incorrect format date. Exp: 13/12/1995 ");
        }
        return errors;
    }
}
