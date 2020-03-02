
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karan
 */
class admin extends JFrame implements ActionListener
{
    
    JButton[] udelete = new JButton[10];
    delete d = new delete();
    public admin()
    {
        
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try
        {
            String url = "jdbc:mysql://localhost:3306/userlogin";
            String dname = "root";
            String dpass = "Karan@123";
            String query = "select * from users"; 
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, dname, dpass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            JLabel j = new JLabel("click to delete user");
            add(j);
            int i=0;
            
            while(rs.next())
            {
                String name = rs.getString(1);
                udelete[i] = new JButton(name);
                add(udelete[i]);
                udelete[i].addActionListener(this);
            }
            st.close();
            conn.close();
        }
        catch(Exception m)
        {
            System.out.println("data base connection error");
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof JButton)
        {
            
            String uname = ((JButton)e.getSource()).getText();
            int flag = d.delete(uname);
            if(flag>-1)
            {
                JOptionPane.showMessageDialog(this, "removed");
                setVisible(false);
                new admin();
            }
        }
    }
        
}
