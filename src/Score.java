
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {


    JButton Submit;
    Score(String name ,int score){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,320,300,250);
        add(image);

        JLabel heading=new JLabel("Thankyou "+name+" for playing Simple Minds");
        heading.setBounds(45,30,800,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,26));
        heading.setForeground(new Color(94, 66, 48));
        add(heading);

        JLabel lblscore=new JLabel("Your score is "+score);
        lblscore.setBounds(350,200,300,30);
        lblscore.setFont(new Font("Tahoma",Font.PLAIN,26));
        lblscore.setForeground(new Color(225, 155, 149));
        add(lblscore);


        Submit=new JButton("Play Again");
        Submit.setBounds(400, 270,200,40);
        Submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        Submit.setBackground(new Color(94, 66, 48));
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        setVisible(true);
        setSize(800,600);
        setLocation(400,150);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();

    }
    public static void main(String[] args) {
        new Score("User",0);
    }
}
