
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


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
    String name;
    String email;
    long mob_no;
    JLabel uname;
    JLabel uemail;
    JLabel umob_no;
    JButton back;
    
    public userpage(String name,String email,long mob_no)
    {
        this.name=name;
        this.email=email;
        this.mob_no=mob_no;
        
    }
    
    public userpage()
    {
        setLayout(new FlowLayout());
        uname = new JLabel(name+" you are in");
        uemail= new JLabel("your email "+email);
        umob_no = new JLabel("your mobile number is "+mob_no);
        back = new JButton("Back");
        
        add(uname);
        add(uemail);
        add(umob_no);
        add(back);
        back.addActionListener(this);
        
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        new index();
        setVisible(false);
    }
}
