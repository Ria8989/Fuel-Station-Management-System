/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import connection.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import model.NewBillData;
import model.NewCustomerData;

/**
 *
 * @author RIYA PATIDAR
 */
public class UpdateService {
    
    private PreparedStatement ps=null;
    private Connection conn=null;
    private String query,sql;
    private static String d_id="Customer doesn't exist", bill="Bill does't exist";
    private static int balance=0;
    private Statement stmt=null;
    private ResultSet rs=null;
    private Map<String,String> idName;
    
    public boolean verifyCustomer(NewCustomerData cusdata){
        try{
            conn=GetConnection.getConnection();
            query="select * from debtors where d_name=? and d_contact=?;";
            ps=conn.prepareStatement(query);
            ps.setString(1,cusdata.getD_name());
            ps.setString(2,cusdata.getD_contact());
            rs=ps.executeQuery();
            if(rs.next()){
                cusdata.setD_table(rs.getString(1));
                cusdata.setD_name(rs.getString(2));
                cusdata.setD_contact(rs.getString(3));
                cusdata.setD_email(rs.getString(4));
                cusdata.setD_balance(rs.getString(6));
                d_id=rs.getString(1);
                return true;
            }
            else{
                cusdata.setD_table(d_id);
                return false;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return false;
    }
    
    public boolean verifyBill(NewBillData billdata){
        try{
            conn=GetConnection.getConnection();
            query="select * from ledger where bill_no=?";
            System.out.println("v0 "+billdata.getBill_no()+" "+bill);
            ps=conn.prepareStatement(query);
            ps.setString(1,billdata.getBill_no());
            System.out.println("v1");
            rs=ps.executeQuery();
            System.out.println("v2");
            if(rs.next()){
                System.out.println("v3");
                billdata.setD_id(rs.getString(3));
                billdata.setBill_date(rs.getString(1));
                billdata.setDebit(rs.getString(4));
                billdata.setCredit(rs.getString(5));
                billdata.setDescription(rs.getString(6));
                d_id=rs.getString(3);
                bill=rs.getString(2);
                balance = rs.getInt(4) - rs.getInt(5);
                System.out.println(bill);
                return true;
            }
            else{
                System.out.println("v4");
                billdata.setBill_no(bill);
                return false;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteBill(NewBillData billdata){
        try{
            conn=GetConnection.getConnection();
            query="delete from ledger where bill_no=?;";
            ps=conn.prepareStatement(query);
            ps.setString(1,bill);
            int i=ps.executeUpdate();
            if(i>0){
                sql="delete from "+d_id+" where bill_no=?;";
                ps=conn.prepareStatement(sql);
                ps.setString(1,bill);
                int j=ps.executeUpdate();
                if(j>0 && changeBalance(billdata)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteCustomer(NewCustomerData cusdata){
        try{
            conn=GetConnection.getConnection();
            query="delete from debtors where d_id=?";
            ps=conn.prepareStatement(query);
            ps.setString(1,d_id);  
            int i=ps.executeUpdate();
            if(i>0){
                sql="drop table "+d_id+";";
                stmt=conn.createStatement();
                int j=stmt.executeUpdate(sql); 
                if(j==0)
                    return true;
                else
                    return false;
            }
            else{
                    return false;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return false;
    }
    
    public boolean updateEntry(NewCustomerData cusdata){
        try{
            conn=GetConnection.getConnection();
            query="update debtors set d_name=?, d_contact=?, d_email=? where d_id=?";
            ps=conn.prepareStatement(query);
            ps.setString(1,cusdata.getD_name());
            ps.setString(2,cusdata.getD_contact());
            ps.setString(3,cusdata.getD_email());
            ps.setString(4,d_id);  
            int i=ps.executeUpdate();
            if(i>0){
                    return true;
            }
            else{
                    return false;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return false;
    }
    
    public boolean changeBalance(NewBillData billdata){
        try{
            conn=GetConnection.getConnection();
            query="select * from debtors where d_id=?;";
            ps=conn.prepareStatement(query);
            ps.setString(1,d_id);
            rs=ps.executeQuery();
            System.out.println("2");
            if(rs.next()){
                balance= rs.getInt(6) - balance;
                sql="update debtors set d_balance=? where d_id=?;";
                ps=conn.prepareStatement(sql);
                ps.setInt(1,balance);
                ps.setString(2, d_id);
                int j=ps.executeUpdate();
                if(j>0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                System.out.println("7");
                return false;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return false;
    }
    
    public boolean gNameCus(NewCustomerData cusdata){
        try{
            conn=GetConnection.getConnection();
            System.out.println("g1");
            query="select * from debtors;";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            idName=new HashMap<String,String>();
            System.out.println("g2");
            while(rs.next()){
                idName.put(rs.getString(1),rs.getString(2));
            }
            
        }
        catch(Exception E){
            E.printStackTrace();
        }
        cusdata.setNameList(idName);
        return true;
    }
    
}
