
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
    Container c;
    JButton[] udelete = new JButton[10];
    delete d = new delete();
    public admin()
    {
        c = getContentPane(); 
        c.setLayout(null); 
        setTitle("Admin");
        setVisible(true);
        setSize(600,500);
        setBounds(300, 90, 900, 600);
        c.setBackground(Color.red);
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
            
            JLabel j = new JLabel("Click to delete user");
            j.setFont(new Font("Arial", Font.BOLD, 40));
            j.setSize(400, 30);
            j.setLocation(50,100);
            c.add(j);
            int i=0;
            int a=150;
            while(rs.next())
            {
                String name = rs.getString(1);
                udelete[i] = new JButton(name);
                udelete[i].setSize(100, 20);
                udelete[i].setLocation(100,a);
                a=a+50;
                add(udelete[i]);
                udelete[i].addActionListener(this);
                c.add(udelete[i]);
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
