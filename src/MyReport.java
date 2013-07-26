/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ppp
 */
import java.sql.Connection;
import modules.javaconnect;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
public class MyReport {
    
       
        Connection conn=null;
        public JasperPrint GenReportParam(String report_file, String sid) {
        conn=javaconnect.ConnecrDb();
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("sid", sid);

        JasperPrint jp = null;
        try {

            jp = JasperFillManager.fillReport(report_file, params, conn);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return jp;
    }
    
}
