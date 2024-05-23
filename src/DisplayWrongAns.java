import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DisplayWrongAns implements ActionListener {
    JLabel qno; JTextArea question;
    JTextArea opt1,opt2,opt3,opt4,answer;
    String[][] ques;


    public static int c;
    public static int count=0;
    JButton next,sa;
    JScrollPane js;
    ButtonGroup groupoptions;
    String name;
    DisplayWrongAns(String[][] wrongans){
        ques=wrongans;
        JFrame f=new JFrame();
        f.setBounds(50,0,1440,850);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        f.setIconImage(img.getImage());
        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);
        JPanel j1=new JPanel();
        j1.setBackground(Color.WHITE);
        j1.setBounds(0,-10,1540,500);
        f.add(j1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        qno=new JLabel();
        j1.setLayout(null);
        qno.setBounds(0,20,40,20);
        qno.setFont(new Font("Tahoma",Font.PLAIN,20));
        qno.setForeground(new Color(94, 66, 48));
        j1.add(qno);

        question=new JTextArea();
        question.setBounds(40,16,1200,600);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        question.setForeground(new Color(94, 66, 48));




        //=============================OPTION 1================================================
        opt1=new JTextArea();
        opt1.setBounds(170,550,1000,50);
        opt1.setBackground(Color.WHITE);
        f.add(opt1);
        opt1.setFont(new Font("Dialog", Font.PLAIN,18));


        //=============================OPTION 2================================================
        opt2=new JTextArea();
        opt2.setBounds(170,600,1000,50);
        opt2.setBackground(Color.WHITE);
        f.add(opt2);
        opt2.setFont(new Font("Dialog", Font.PLAIN,18));

        //=============================OPTION 3================================================
        opt3=new JTextArea();
        opt3.setBounds(170,650,1000,50);
        opt3.setBackground(Color.WHITE);
        f.add(opt3);
        opt3.setFont(new Font("Dialog", Font.PLAIN,18));

        //=============================OPTION 4================================================
        opt4=new JTextArea();
        opt4.setBounds(170,700,1000,50);
        opt4.setBackground(Color.WHITE);
        f.add(opt4);
        opt4.setFont(new Font("Dialog", Font.PLAIN,18));

        answer=new JTextArea();
        answer.setBounds(170,750,1000,50);
        answer.setBackground(Color.WHITE);
        f.add(answer);
        answer.setFont(new Font("Dialog", Font.PLAIN,18));
        c=0;
        for (int i = 0; i < wrongans.length; i++) {
            if(ques[i][0]!=null)c++;
        else break;
            System.out.println(c);
        }



        next=new JButton("Next");
        next.setBounds(1170, 550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(94, 66, 48));
        next.setForeground(Color.white);
        next.addActionListener(this);
        f.add(next);


        sa=new JButton("Show Answer");
        sa.setBounds(1170, 600,200,40);
        sa.setFont(new Font("Tahoma",Font.PLAIN,22));
        sa.setBackground(new Color(94, 66, 48));
        sa.setForeground(Color.white);
        sa.addActionListener(this);
        f.add(sa);

        start(count);
        js=new JScrollPane(question,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        js.setBounds(40,16,1300,450);
        js.setBorder(null);
        j1.add(js);
        f.setVisible(true);



    }




    public void start(int count){
        try{
            qno.setText(count+1+".");
            question.setText(ques[count][0]);

            opt1.setText(ques[count][1]);

            opt2.setText(ques[count][2]);

            opt3.setText(ques[count][3]);

            opt4.setText(ques[count][4]);


            }
        catch(Exception ex) { System.out.println(ex); }

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){

            if(count<c-1){
            start(++count);
            answer.setText("");}
        }else if(ae.getSource()==sa)
        {
            answer.setText("Answer is "+ques[count][6]);

        }


        }

    }






