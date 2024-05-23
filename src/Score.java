
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {


    JButton playagain,WrongAns;
    String wa[][];
    Score(String name ,int score,String[][] wrongans){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        setIconImage(img.getImage());
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,320,300,250);
        add(image);

        JLabel heading=new JLabel("Thank You "+name+" for completing the test.");
        heading.setBounds(45,30,800,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,26));
        heading.setForeground(new Color(94, 66, 48));
        add(heading);

        JLabel lblscore=new JLabel("Your score is "+score);
        lblscore.setBounds(350,200,300,30);
        lblscore.setFont(new Font("Tahoma",Font.PLAIN,26));
        lblscore.setForeground(new Color(225, 155, 149));
        add(lblscore);


        playagain=new JButton("Play Again");
        playagain.setBounds(400, 270,200,40);
        playagain.setFont(new Font("Tahoma",Font.PLAIN,22));
        playagain.setBackground(new Color(94, 66, 48));
        playagain.setForeground(Color.white);
        playagain.addActionListener(this);
        add(playagain);

        WrongAns=new JButton("Display Mistakes");
        WrongAns.setBounds(400, 320,200,40);
        WrongAns.setFont(new Font("Tahoma",Font.PLAIN,18));
        WrongAns.setBackground(new Color(94, 66, 48));
        WrongAns.setForeground(Color.white);
        WrongAns.addActionListener(this);
        add(WrongAns);

        setVisible(true);
        setSize(800,600);
        setLocation(400,150);
        wa=wrongans;
    }
    public void actionPerformed(ActionEvent ae){

        setVisible(false);
        if(ae.getSource()==WrongAns) {
            new DisplayWrongAns(wa);
        } else if (ae.getSource()==playagain) {

            new Login();
        }

    }
}
