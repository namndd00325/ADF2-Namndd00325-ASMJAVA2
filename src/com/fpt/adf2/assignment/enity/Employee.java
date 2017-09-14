/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.assignment.enity;



/**
 *
 * @author Nam Nguyen
 */
public class Employee {
     private int id;
    private String name;
    private String birthday;
    private String emmail;
    private String phoneNumber;
    private String address;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String emmail, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.emmail = emmail;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmmail() {
        return emmail;
    }

    public void setEmmail(String emmail) {
        this.emmail = emmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   
    
    
}
