package modules;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ppp
 */
import java.sql.*;
import javax.swing.*;

public class javaconnect {
    
    static Connection conn=null;
    public static Connection ConnecrDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_attendance","root","");
            //JOptionPane.showMessageDialog(null, "Connection established");
            return conn;
        } catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }   
}
