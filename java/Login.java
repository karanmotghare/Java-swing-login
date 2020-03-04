import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author karan
 */
public class Login {

     
    public static void main(String[] args) throws Exception 
    {
        index id = new index();
        
    }
    
}

class index extends JFrame implements ActionListener
{
    verify v = new verify();
    Container c;
    JLabel title;
    JLabel usertype;
    JComboBox type;
    JLabel username;
    JLabel password;
    JTextField txt1;
    JPasswordField txt2;
    JButton login;
    JButton register;
    String types[]={"ADMIN","USER"};
    
    String user_name;
    String user_email;
    String user_mob_no;
    public index(String name,String email,String mob_no)
    {
        this.user_name = name;
        this.user_email = email;
        this.user_mob_no = mob_no;
    }
    
    public index()
    {
        setTitle("Login Form");
        setBounds(300, 90, 900, 600);
        c = getContentPane(); 
        c.setLayout(null);  
        //setLayout(new FlowLayout());
        title = new JLabel("LOGIN FORM"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title);  
        username = new JLabel("Username");
        username.setFont(new Font("Arial", Font.PLAIN, 20)); 
        username.setSize(100, 20); 
        username.setLocation(100, 100); 
        c.add(username); 
        txt1 = new JTextField(); 
        txt1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txt1.setSize(190, 20); 
        txt1.setLocation(200, 100); 
        c.add(txt1); 
        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20)); 
        password.setSize(100, 20); 
        password.setLocation(100, 150); 
        c.add(password); 
        txt2 = new JPasswordField(); 
        txt2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txt2.setSize(150, 20); 
        txt2.setLocation(200, 150); 
        c.add(txt2);
        usertype = new JLabel("Usertype"); 
        usertype.setFont(new Font("Arial", Font.PLAIN, 20)); 
        usertype.setSize(100, 20); 
        usertype.setLocation(100, 200); 
        c.add(usertype);
        type = new JComboBox(types); 
        type.setFont(new Font("Arial", Font.PLAIN, 15)); 
        type.setSize(100, 20); 
        type.setLocation(200, 200); 
        c.add(type);   
        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 15)); 
        login.setSize(100, 20); 
        login.setLocation(150, 275); 
        login.addActionListener(this); 
        c.add(login); 
        register = new JButton("Register");
        register.setFont(new Font("Arial", Font.PLAIN, 15)); 
        register.setSize(100, 20); 
        register.setLocation(270,275); 
        register.addActionListener(this); 
        c.add(register); 
        
        //Container c = getContentPane();
        //JPanel panel = new JPanel();
        //c.add(panel);
        
       // add(username);
       // add(txt1);
       //  add(password);
       // add(txt2);
       // add(login);
       // add(register);
       // add(login_as_admin);
        
       // login.addActionListener(this);
       // register.addActionListener(this);
       // login_as_admin.addActionListener(this);
        c.setBackground(Color.cyan);
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String uname = txt1.getText();
        String upass = txt2.getText();
        if(e.getSource()==login)
        {
            //verify(uname,upass);
            
            //flag = v.verification(uname,upass,"login");
            /*if(flag==1)
            {
                int value = type.getSelectedIndex();
                if(value==1)
              {
                JOptionPane.showMessageDialog(this,uname+" you have Successfully login");
                //System.out.println("you have Successfully login");
                //new userpage(user_name,user_email,user_mob_no);
                new userpage();
                setVisible(false);
              }
              else
              {
                 JOptionPane.showMessageDialog(this,uname +"(Admin),you have Successfully login");
                 new admin();
                 setVisible(false);
              }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "login failed");
               
            }*/
            int value = type.getSelectedIndex();
            if(value==1)
            {
                int flag=0;
                flag=v.verification(uname, upass, "user");
                if(flag==1)
                {
                    JOptionPane.showMessageDialog(this,uname +" you have Successfully login" );
                    new userpage(uname);
                    //new userpage();
                    
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Login Failed");
                }
                  
            }
            else
            {
                  int flag=0;
                flag=v.verification(uname, upass, "admin");
                if(flag==1)
                {
                    JOptionPane.showMessageDialog(this,uname +" you have Successfully login as admin" );
                    new admin();
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Login Failed");
                }
            }
            
        }
        else if (e.getSource()== register)
        {
            setVisible(false);
            new register();
            
        }
       /* else 
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
        } */
    }

    
}