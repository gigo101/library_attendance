/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ppp
 */
public class allmethods {
    
    public static void Update_table(JTable tblname,String sqlQuery){
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        conn=javaconnect.ConnecrDb();
        try{
            //Statement st=conn.createStatement();

            //rs=st.executeQuery(sql); //if using simple query not prepared statment
            pst=conn.prepareStatement(sqlQuery);
            rs=pst.executeQuery();
            
            tblname.setModel(DbUtils.resultSetToTableModel(rs));     
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);    
            
        } finally{
            try {
                rs.close();
                pst.close();
                                
            } catch (Exception e) {
            }
        }
        
    }
    
    
        public static void fillcombo(JComboBox combo,String sql,String getstring){
            Connection conn=null;
            ResultSet rs=null;
            PreparedStatement pst=null;
            conn=javaconnect.ConnecrDb();
            try{       
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
            
                while(rs.next()){
                    String name= rs.getString(getstring);
                    combo.addItem(name);
                }
                        
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);                
            } 

    }
    
}
