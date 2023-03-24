import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JButton rules,exit;JTextField tfname;
        Login(){
            getContentPane().setBackground(Color.WHITE);
            setSize(1200,600);
            setLocation(200,100);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
            Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            add(image);
            setLayout(null);
            image.setBounds(0,0,600,600);

            JLabel heading=new JLabel("ACO");
            heading.setBounds(780,60,100,50);
            heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
            heading.setForeground(new Color(94, 66, 48));
            add(heading);
            JLabel name=new JLabel("Enter Your Name:");
            name.setBounds(780,140,300,30);
            name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
            name.setForeground(new Color(94, 66, 48));
            add(name);
            tfname= new JTextField();
            tfname.setBounds(720,220,300,30);
            tfname.setFont(new Font("Times New Roman",Font.BOLD,18));
            add(tfname);

            rules=new JButton("Rules");
            rules.setBounds(730,260,120,25);
            rules.setBackground(new Color(	94, 66, 48));
            rules.setForeground(Color.white);
            rules.addActionListener(this);
            add(rules);

            exit=new JButton("Exit");
            exit.setBounds(895,260,120,25);
            exit.setBackground(new Color(94, 66, 48));
            exit.setForeground(Color.white);
            exit.addActionListener(this);
            add(exit);

            setVisible(true);

    }
    public static void main(String[] args){
        new Login();

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==rules){
            String name=tfname.getText();
            setVisible(false);
            new Rules(name);
        }
        else if(ae.getSource()==exit){
            setVisible(false);
        }
    }

}
