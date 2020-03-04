
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.event.*;

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
    
    Container c;
    JLabel title;
    JLabel name;
    JLabel password;
    JLabel repassword;
    JLabel email;
    JLabel match1;
    JLabel match2;
    JLabel mob_no;
    
    JTextField txt1;
    JPasswordField txt2;
    
    JFormattedTextField txt3;
    JFormattedTextField txt4;
    JButton register;
    int flag1=0,flag2=0,flag3=0,flag4=0;

    
    public register()
    {
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
       
                
        
         Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
       
         
        
         
         
         
        c = getContentPane(); 
        c.setLayout(null); 
        setTitle("Registration Form"); 
        setBounds(300, 90, 900, 600); 
      // setLayout(new FlowLayout());
       // JPanel p = new JPanel(); 
        title = new JLabel("Registration Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
        name = new JLabel("username");
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(100, 100); 
        c.add(name);
        txt1 = new JTextField();
        txt1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txt1.setSize(190, 20); 
        txt1.setLocation(200, 100); 
        c.add(txt1);
        password = new JLabel("password");
        password.setFont(new Font("Arial", Font.PLAIN, 20)); 
        password.setSize(100, 20); 
        password.setLocation(100, 150); 
        c.add(password);
        txt2 = new JPasswordField();
        txt2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txt2.setSize(150, 20); 
        txt2.setLocation(200, 150); 
        c.add(txt2); 
        
        email = new JLabel("email");
        email.setFont(new Font("Arial", Font.PLAIN, 20)); 
        email.setSize(100, 20); 
        email.setLocation(100, 200); 
        c.add(email); 
        txt3 = new JFormattedTextField(pat);
        txt3.setText("");
        txt3.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txt3.setSize(150, 30); 
        txt3.setLocation(200, 200);
        match1 = new JLabel("");
        match1.setFont(new Font("Arial", Font.PLAIN, 20));
        match1.setSize(100,20);
        match1.setLocation(375,200);
        txt3.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                Matcher r = pat.matcher(txt3.getText());
                if (!r.find()) {
                    match1.setText("not valid");
                } else
                    match1.setText("valid");
                    
            }
        });
        c.add(match1);
        c.add(txt3);
        mob_no = new JLabel("mobile no"); 
        mob_no.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mob_no.setSize(100, 20); 
        mob_no.setLocation(100, 250); 
        c.add(mob_no);
        txt4 = new JFormattedTextField(p);
        txt4.setText("");
        txt4.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txt4.setSize(150, 30); 
        txt4.setLocation(200, 250);
        match2 = new JLabel("");
        match2.setFont(new Font("Arial", Font.PLAIN, 20));
        match2.setSize(100,20);
        match2.setLocation(375,250);
        txt4.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                Matcher r = p.matcher(txt4.getText());
                if (!r.find()) {
                    match2.setText("not valid");
                } else
                    match2.setText("valid");
                   
            }
        });
        c.add(match2);
        c.add(txt4); 
        register = new JButton("Submit");
        register.setFont(new Font("Arial", Font.PLAIN, 15)); 
        register.setSize(100, 20); 
        register.setLocation(150, 300); 
        register.addActionListener(this); 
        c.add(register); 
       /* add(name);
        add(txt1);
        add(password);
        add(txt2);
        add(email);
        add(txt3);
        add(mob_no);
        add(txt4);
        add(register);
        
        register.addActionListener(this); */
        
        c.setBackground(Color.orange); 
         //c.add(p);
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String uname = txt1.getText();
        String upass = txt2.getText();
        String uemail = txt3.getText();
        String umob_no = txt4.getText();
        if(uname.equals(""))
        {
            JOptionPane.showMessageDialog(this, "this cant be blank");
        }
        else
        {
            flag1=1;
        }
        if(upass.equals(""))
        { JOptionPane.showMessageDialog(this, "this cant be blank");
        }
        else
        {
            flag2=1;
        }
        if(match1.getText().equals("valid"))
        {flag3=1;}
        if(match2.getText().equals("valid"))
        {flag4=1;}
   
        
        if(flag1==1&&flag2==1&&flag3==1&&flag4==1)
        {
        try
        {
            String url = "jdbc:mysql://localhost:3306/userlogin";
            String dname = "root";
            String dpass = "Karan@123";
            String query = "INSERT INTO users (name,pass,email,mob_no) VALUES ('"+uname+"','"+upass+"','"+uemail+"','"+umob_no+"')"; 
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, dname, dpass);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
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
}
