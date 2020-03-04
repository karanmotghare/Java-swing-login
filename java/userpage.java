
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karan
 */
 class userpage extends JFrame implements ActionListener
{
    Container c;
    String name;
    String email;
    String mob_no;
    JLabel uname;
    JLabel uemail;
    JLabel umob_no;
    JLabel show;
    JLabel ticket;
    JComboBox book;
    JButton confirm;
    JButton back;
    
    String books[]={"Train","Flight","Metro","Rental Car","Taxi","Auto"};    

//    public userpage(String name)
//    {
//        this.name=name;
//        //this.email=email;
//        //this.mob_no=mob_no;
//        
//    }
    
    public userpage(String name)
    {
        try{
             String url = "jdbc:mysql://localhost:3306/userlogin";
            String uename = "root";
            String pass = "Karan@123";
            String query = "select * from users"; 
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, uename, pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                String dname=rs.getString(1);
                if(dname.equals(name))
                {
                    email = rs.getString(3);
                    mob_no = rs.getString(4);
                }
                
            }
            conn.close();
            st.close();
        }
        catch(Exception f)
        {
            System.out.println("connect to database failed");
        }
        setTitle("User Form"); 
        setBounds(300, 90, 900, 600);
        c = getContentPane(); 
        c.setLayout(null); 
        //setLayout(new FlowLayout());
        uname = new JLabel(name+" Welcome");
        uname.setFont(new Font("Arial", Font.PLAIN, 20)); 
        uname.setSize(400, 20); 
        uname.setLocation(100, 100); 
        c.add(uname); 
        uemail= new JLabel("your email is: "+email);
        uemail.setFont(new Font("Arial", Font.PLAIN, 20)); 
        uemail.setSize(400, 20); 
        uemail.setLocation(100, 150); 
        c.add(uemail); 
        umob_no = new JLabel("your mobile number is "+mob_no);
        umob_no.setFont(new Font("Arial", Font.PLAIN, 20)); 
        umob_no.setSize(400, 20); 
        umob_no.setLocation(100, 200); 
        c.add(umob_no); 
        ticket= new JLabel("Book your Ticket : ");
        ticket.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ticket.setSize(400, 20); 
        ticket.setLocation(100, 250); 
        c.add(ticket);
        book = new JComboBox(books); 
        book.setFont(new Font("Arial", Font.PLAIN, 15)); 
        book.setSize(150, 30); 
        book.setLocation(300, 250); 
        c.add(book);
//        show= new JLabel("");
//        show.setFont(new Font("Arial", Font.PLAIN, 20)); 
//        show.setSize(400, 20); 
//        show.setLocation(125, 300); 
//        c.add(show);
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Arial", Font.PLAIN, 15)); 
        confirm.setSize(100, 20); 
        confirm.setLocation(150, 400); 
        confirm.addActionListener(this); 
        c.add(confirm);   
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 15)); 
        back.setSize(100, 20); 
        back.setLocation(270, 400); 
        back.addActionListener(this); 
        c.add(back);   
        
       /* add(uname);
        add(uemail);
        add(umob_no);
        add(back); */
       // back.addActionListener(this);
        
        setVisible(true);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setBackground(Color.gray);
    }
    
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource() == confirm)
       {
         String value = book.getSelectedItem().toString(); 
        // show.setText("You have Booked " + value +" for your Journey");
        JOptionPane.showMessageDialog(this, "You have Booked " + value +" for your Journey");
        book.setSelectedIndex(0);
       }
      else
      { 
        new index();
        setVisible(false);
      }
    }
}
