/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author karan
 */
class delete 
{
    int delete(String name)
    {
        int flag=-1;
            try
            {
                String daurl = "jdbc:mysql://localhost:3306/userlogin";
                String daname = "root";
                String dapass = "Karan@123";
                String dquery = "delete from users where name = '"+name+"'"; 
                //String query = "select * from users";
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(daurl, daname, dapass);
                Statement st = conn.createStatement();
                flag = st.executeUpdate(dquery);
                //ResultSet rt = st.executeQuery(query);
                //rt.next();
                //System.out.println(rt.getString(1));
                
                
            }
            catch(Exception l)
            {
                System.out.println("data base connection error");
            }
            return flag;
    }      
      
}
