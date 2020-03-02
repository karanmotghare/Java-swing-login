
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
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
class register extends JFrame implements ActionListener
{
    JLabel name;
    JLabel password;
    JLabel email;
    JLabel mob_no;
    JTextField txt1;
    JTextField txt2;
    JTextField txt3;
    JTextField txt4;
    JButton register;
    
    public register()
    {
        setLayout(new FlowLayout());
        name = new JLabel("username");
        password = new JLabel("password");
        email = new JLabel("email");
        mob_no = new JLabel("mobile no");
        txt1 = new JTextField(10);
        txt2 = new JTextField(10);
        txt3 = new JTextField(20);
        txt4 = new JTextField(11);
        register = new JButton("Submit");
        
        add(name);
        add(txt1);
        add(password);
        add(txt2);
        add(email);
        add(txt3);
        add(mob_no);
        add(txt4);
        add(register);
        
        register.addActionListener(this);
        
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String uname = txt1.getText();
        String upass = txt2.getText();
        String uemail = txt3.getText();
        long umob_no = Integer.parseInt(txt4.getText());
        
        try
        {
            String url = "jdbc:mysql://localhost:3306/userlogin";
            String dname = "root";
            String dpass = "Karan@123";
            String query = "INSERT INTO users (name,password,email,mob_no) VALUES ('"+uname+"','"+upass+"','"+uemail+"',"+umob_no+")"; 
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, dname, dpass);
            Statement st = conn.createStatement();
            int rt = st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "you have successfully register");
            setVisible(false);
            new index();
           
        }
        catch(Exception q)
        {
            System.out.println("connect to database failed");
        }
    }
}
