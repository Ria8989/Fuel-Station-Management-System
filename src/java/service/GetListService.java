/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import connection.GetConnection;
import java.sql.Connection;
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
public class GetListService {
    private Connection conn=GetConnection.getConnection();
    private String query,sql;
    private Statement stmt=null;
    private ResultSet rs=null;
    private Map<String,String> idName;
    
    public boolean gNameBill(NewBillData billdata){
        try{
            System.out.println("g1");
            query="select * from debtors;";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            idName=new HashMap<>();
            System.out.println("g2");
            while(rs.next()){
                idName.put(rs.getString(1),rs.getString(2));
            }
            billdata.setName_list(idName);
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return true;
    }
        public boolean gNameCus(NewCustomerData cusdata){
        try{
            System.out.println("g1");
            query="select * from debtors;";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            idName=new HashMap<String,String>();
            System.out.println("g2");
            while(rs.next()){
                idName.put(rs.getString(1),rs.getString(2));
            }
            cusdata.setNameList(idName);
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return true;
    }

}
