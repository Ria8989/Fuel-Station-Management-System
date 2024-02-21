/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;
import java.sql.*;
/**
 *
 * @author RIYA PATIDAR
 */
public class GetConnection {
    
    private static Connection conn;
    //private static final String driver="com.mysql.cj.jdbc.Driver";
    //private static final String url="jdbc:mysql://localhost/projects";
    //private static final String user="root";
    //private static final String pass="rootriya";
        
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false","root","rootriya");   
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
    
    public static Connection getConnection()
    {
            return conn;
    }
}
