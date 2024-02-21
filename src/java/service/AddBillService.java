/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import connection.GetConnection;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NewBillData;

/**
 *
 * @author RIYA PATIDAR
 */
public class AddBillService {
    private Connection conn=GetConnection.getConnection();
    private PreparedStatement ps=null;
    private String query,sql;
    private Statement stmt=null;
    private ResultSet rs=null;
    private static String table_name="ledger",bill_date;
    
    public boolean verifyBill(NewBillData newBill){
        try{
            sql="select * from debtors where d_name=?;";
            ps=conn.prepareStatement(sql);
            ps.setString(1,newBill.getBill_name());
            rs=ps.executeQuery();
            System.err.println("1");
            if(rs.next()){
                System.out.println("next");
                table_name=rs.getString(1);
                System.out.println("2 - "+table_name);
                //query="select * from "+table_name+" where bill_no=?;";
                query="select * from ledger where bill_no=?;";
                ps=conn.prepareStatement(query);
                ps.setString(1,newBill.getBill_no());
                rs=ps.executeQuery();
                System.out.println("3");
                if(rs.next()){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return false;
        
    }
    
    public boolean addBill(NewBillData newBill){
        try{
            System.out.println("4 - old "+newBill.getBill_date());
            //bill_date=dateConversion(newBill.getBill_date());
            //System.out.println("4 - "+bill_date);
            query="insert into "+table_name+" values(?,?,?,?,?);";
            ps=conn.prepareStatement(query);
            ps.setString(1,newBill.getBill_date());
            ps.setString(2,newBill.getBill_no());
            ps.setInt(3,Integer.parseInt(newBill.getDebit()));
            ps.setInt(4,Integer.parseInt(newBill.getCredit()));
            ps.setString(5,newBill.getDescription());
            int i=ps.executeUpdate();
            System.out.println("5");
            if(i>0){
                if(entryInLedger(newBill)){
                    System.out.println("6");
                    return true;
                }
            }
            else{
                return false;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        finally{
            try {
                conn.commit();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddBillService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean entryInLedger(NewBillData newBill){
        try{
            sql="insert into ledger values(?,?,?,?,?,?);";
            ps=conn.prepareStatement(sql);
            ps.setString(1,newBill.getBill_date());
            ps.setString(2,newBill.getBill_no());
            ps.setString(3,table_name);
            ps.setInt(4,Integer.parseInt(newBill.getDebit()));
            ps.setInt(5,Integer.parseInt(newBill.getCredit()));  
            ps.setString(6,newBill.getDescription());
            int j=ps.executeUpdate();
            if(j>0){
                if(entryInDebtors(newBill)){
                    System.out.println("7");
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
    
    public boolean entryInDebtors(NewBillData newBill){
        int d_debit=Integer.parseInt(newBill.getDebit());
        int d_credit=Integer.parseInt(newBill.getCredit());
        int d_balance=d_debit-d_credit;
        try{
            d_balance += getBalance();
            sql="update debtors set d_balance=?,d_lastbill=? where d_id=?;";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,d_balance);
            ps.setString(2,newBill.getBill_no());
            ps.setString(3,table_name);
            int j=ps.executeUpdate();
            if(j>0){
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
    
    public int getBalance(){
        try{
            sql="select * from debtors where d_id=?;";
            ps=conn.prepareStatement(sql);
            ps.setString(1, table_name);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt(6);
            }
            else{
                return 0;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return 0;
    }
    
    public String dateConversion(String date) throws ParseException{
        DateFormat formatter ;
        formatter = new SimpleDateFormat("YYYY-mm-dd");
        java.util.Date new_date=formatter.parse(date);
        String newbill_date=formatter.format(new_date);
        return newbill_date;
    }
    
}
