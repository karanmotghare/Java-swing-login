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
    public index()
    {
        setLayout(new FlowLayout((int) CENTER_ALIGNMENT));
        username = new JLabel("Username");
        password = new JLabel("Password");
        txt1 = new JTextField(10);
        txt2 = new JTextField(10);
        login = new JButton("Login");
        register = new JButton("Register");
        
        //Container c = getContentPane();
        //JPanel panel = new JPanel();
        //c.add(panel);
        
        add(username);
        add(txt1);
        add(password);
        add(txt2);
        add(login);
        add(register);
        
        login.addActionListener(this);
        register.addActionListener(this);
        
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
            flag = v.verification(uname,upass);
            if(flag==1)
            {
                System.out.println("you have Successfully login");
            }
            else
            {
                System.out.println("login failed");
            }
        }
        else
        {
            
        }
    }

    
}