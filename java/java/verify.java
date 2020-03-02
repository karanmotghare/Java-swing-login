
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karan
 */
class verify 
{
    //String uname;
    //String upass;
    //verify(String uname,String upass)
    //{
     //   this.uname=uname;
     //   this.upass=upass;
    //}

    //verify() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    int verification(String uname,String upass,String query1)
    {
       
        int flag1=0,flag2=0,flag=0;
        try
        {
            String url = "jdbc:mysql://localhost:3306/userlogin";
            String name = "root";
            String pass = "Karan@123";
            String query=null;
            if(query1.equals("login"))
            {
                query = "select * from users"; 
            }
            else
            {
                query = "select * from admin";
            }
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, name, pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                String dname = rs.getString(1);
                String dpass = rs.getString(2);
                String email = rs.getString(3);
                long mob_no = rs.getLong(4);
                if(uname.equals(dname))
                {
                    flag1=1;
                }
                if(upass.equals(dpass))
                {
                    flag2=1;
                }
                if(flag1==1 && flag2==1)
                {
                    flag=1;
                    //new index(dname,email,mob_no);
                    
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println("connect to database failed");
        }
        return flag;
    }

    //int verification(String uname, String upass) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
}
