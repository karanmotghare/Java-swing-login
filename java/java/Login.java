import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author karan
 */
public class Login {

     
    public static void main(String[] args) 
    {
        index id = new index();
        
    }
    
}

class index extends JFrame implements ActionListener
{
    verify v = new verify();
    JLabel username;
    JLabel password;
    JTextField txt1;
    JTextField txt2;
    JButton login;
    JButton register;
    JButton login_as_admin;
    
    String user_name;
    String user_email;
    long user_mob_no;
    public index(String name,String email,long mob_no)
    {
        this.user_name = name;
        this.user_email = email;
        this.user_mob_no = mob_no;
    }
    
    public index()
    {
        setLayout(new FlowLayout());
        username = new JLabel("Username");
        password = new JLabel("Password");
        txt1 = new JTextField(10);
        txt2 = new JTextField(10);
        login = new JButton("Login");
        register = new JButton("Register");
        login_as_admin = new JButton("login_as_admin");
        
        //Container c = getContentPane();
        //JPanel panel = new JPanel();
        //c.add(panel);
        
        add(username);
        add(txt1);
        add(password);
        add(txt2);
        add(login);
        add(register);
        add(login_as_admin);
        
        login.addActionListener(this);
        register.addActionListener(this);
        login_as_admin.addActionListener(this);
        
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String uname = txt1.getText();
        String upass = txt2.getText();
        if(e.getSource()==login)
        {
            //verify(uname,upass);
            int flag=0;
            flag = v.verification(uname,upass,"login");
            if(flag==1)
            {
               
                JOptionPane.showMessageDialog(this,uname+" you have Successfully login");
                //System.out.println("you have Successfully login");
                new userpage(user_name,user_email,user_mob_no);
                new userpage();
                setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "login failed");
                //System.out.println("login failed");
            }
        }
        else if (e.getSource()==register)
        {
            new register();
            setVisible(false);
        }
        else 
        {
            int flag=0;
            flag = v.verification(uname,upass,"admin");
            if(flag==1)
            {
               
                JOptionPane.showMessageDialog(this,uname+" you have Successfully login");
                
                setVisible(false);
                new admin();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "login failed");
                //System.out.println("login failed");
            }
        }
    }

    
}