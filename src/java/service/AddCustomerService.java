/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;
import connection.GetConnection;
import java.sql.*;
import model.NewCustomerData;
/**
 *
 * @author RIYA PATIDAR
 */
public class AddCustomerService{
    
    private PreparedStatement ps=null;
    private Connection conn=null;
    private String query,sql,d_id="customer";
    private Statement stmt=null;
    private ResultSet rs=null;
    
    public boolean verifyNewCustomer(NewCustomerData newCustomer){
        try{
            conn=GetConnection.getConnection();
            query="select * from debtors where d_name=? and d_contact=?;";
            ps=conn.prepareStatement(query);
            ps.setString(1,newCustomer.getD_name());
            ps.setString(2,newCustomer.getD_contact());
            rs=ps.executeQuery();
            if(rs.next()){
                return false;
            }
            else{
                return true;
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return false;
    }
    
    public boolean addEntry(NewCustomerData newCustomer){
        try{
            conn=GetConnection.getConnection();
            stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from debtors");
            rs.last();
            // change it ny adding a colomun in debtors table that autoincrements
            int count=rs.getRow()+1;
            d_id="customer_"+count;
            query="insert into debtors values(?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(query);
            ps.setString(1,d_id);
            ps.setString(2,newCustomer.getD_name());
            ps.setString(3,newCustomer.getD_contact());
            ps.setString(4,newCustomer.getD_email());  
            ps.setString(5,newCustomer.getD_address());
            ps.setInt(6,0);
            ps.setString(7,"");
            int i=ps.executeUpdate();
            if(i>0){
                sql="CREATE TABLE "+d_id+
                        "(BILL_DATE DATE,"
                        + " BILL_NO VARCHAR(15) PRIMARY KEY,"
                        + " DEBIT INT(8),"
                        + " CREDIT INT(8),"
                        + " DESCRIPTION TEXT);";
                int j=stmt.executeUpdate(sql);
                if(j==0){
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
}
