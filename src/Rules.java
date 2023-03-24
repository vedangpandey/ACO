
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener{
    String name;JButton exit,start;
    Rules(String name) {
        this.name=name;
        getContentPane().setBackground(Color.white);
        setSize(700,550);
        setLocation(350,150);
        setLayout(null);
        JLabel heading=new JLabel("Welcome "+ name + " to ACO");
        heading.setBounds(100,20,700,100);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(new Color(94, 66, 48));
        add(heading);
        JLabel rules=new JLabel();
        rules.setBounds(80,80,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,18));
        rules.setText(
                "<html>"+
                        "1. You are given only set amount of time" + "<br><br>" +
                        "2. You get around 2 minute for each question" + "<br><br>" +
                        "3. You May sit around with a rough page" + "<br><br>" +
                        "4. Be Honest." + "<br><br>" +
                        "<html>"
        );
        add(rules);

        exit=new JButton("Exit");
        exit.setBounds(320,360,120,25);
        exit.setBackground(new Color(94, 66, 48));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        start=new JButton("Start");
        start.setBounds(170,360,120,25);
        start.setBackground(new Color(94, 66, 48));
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);
        setVisible(true);
    }
    public static void main(String[] args){
        new Rules("User");
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==start){
            setVisible(false);
            new Quiz(name);
        }
        else if(ae.getSource()==exit){
            setVisible(false);
        }
    }

}
