/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author RIYA PATIDAR
 */
public class NewCustomerData {
    
    private String d_name;
    private String d_contact;
    private String d_address;
    private String d_email;
    private String d_table;
    private String d_balance;
    private Map<String,String> nameList = new HashMap<String, String>();

    public String getD_balance() {
        return d_balance;
    }

    public void setD_balance(String d_balance) {
        this.d_balance = d_balance;
    }

    public String getD_table() {
        return d_table;
    }

    public void setD_table(String d_table) {
        this.d_table = d_table;
    }

    public Map<String, String> getNameList() {
        return nameList;
    }

    public void setNameList(Map<String, String> nameList) {
        this.nameList = nameList;
    }

    public String getDefaultName(){
        return "ledger";
    }
    
    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_contact() {
        return d_contact;
    }

    public void setD_contact(String d_contact) {
        this.d_contact = d_contact;
    }

    public String getD_address() {
        return d_address;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address;
    }
    
    public String getD_email() {
        return d_email;
    }

    public void setD_email(String d_email) {
        this.d_email = d_email;
    }
    
}
