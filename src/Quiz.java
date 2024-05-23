import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions=new String[1000][5];
    String[][] answers=new String[1000][2];
    String[][] wrongans=new String[100][7];

    JScrollPane js;

    public static int wrong=0;
    private static ResultSet rs = null;
    String[][] useranswer=new String[1000][1];
    JLabel qno; JTextArea question;
    JRadioButton opt1,opt2,opt3,opt4;
    public static int timer=120;
    public static int ans_given=0;

    public static int score=0;
    public static int count=0;
    JButton next,Submit,Clear;
    ButtonGroup groupoptions;
    String name;
    Quiz(String name,String tag){
        this.name=name;


        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        setIconImage(img.getImage());



        //=============================*_*_*_*_*_*_*_*================================================
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JPanel j1=new JPanel();
        j1.setBackground(Color.WHITE);
        j1.setBounds(0,-10,1540,500);
        add(j1);
        //JPanel j2=new JPanel();


        //database connection

        Connection con = null;

        //Database Connection
        try{

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/STC", "root", "S@k4tag1n");
            PreparedStatement ps = con.prepareStatement("select * from questionbank where tag = ?");
            ps.setString(1, tag);
            rs = ps.executeQuery();
            if(rs.next());
        }catch(Exception ex) { System.out.println(ex); }



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        opt1=new JRadioButton();
        opt1.setBounds(170,550,1000,50);
        opt1.setBackground(Color.WHITE);
        add(opt1);
        opt1.setFont(new Font("Dialog", Font.PLAIN,18));


        //=============================OPTION 2================================================
        opt2=new JRadioButton();
        opt2.setBounds(170,590,1000,50);
        opt2.setBackground(Color.WHITE);
        add(opt2);
        opt2.setFont(new Font("Dialog", Font.PLAIN,18));

        //=============================OPTION 3================================================
        opt3=new JRadioButton();
        opt3.setBounds(170,630,1000,50);
        opt3.setBackground(Color.WHITE);
        add(opt3);
        opt3.setFont(new Font("Dialog", Font.PLAIN,18));

        //=============================OPTION 4================================================
        opt4=new JRadioButton();
        opt4.setBounds(170,670,1000,50);
        opt4.setBackground(Color.WHITE);
        add(opt4);
        opt4.setFont(new Font("Dialog", Font.PLAIN,18));


        groupoptions=new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next=new JButton("Next");
        next.setBounds(1170, 550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(94, 66, 48));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        Clear=new JButton("Clear");
        Clear.setBounds(1170, 680,200,40);
        Clear.setFont(new Font("Tahoma",Font.PLAIN,22));
        Clear.setBackground(new Color(94, 66, 48));
        Clear.setForeground(Color.white);
        Clear.addActionListener(this);
        add(Clear);

        Submit=new JButton("Submit");
        Submit.setBounds(1170, 617,200,40);
        Submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        Submit.setBackground(new Color(94, 66, 48));
        Submit.setForeground(Color.white);

        Submit.addActionListener(this);
        add(Submit);

        start(count);
        js=new JScrollPane(question,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        js.setBounds(40,16,1300,450);
        js.setBorder(null);
        j1.add(js);
        setVisible(true);



    }
    public void paint(Graphics g){
        super.paint(g);
        String time="Time-left "+timer+" seconds";
        g.setColor(new Color(225, 155, 149));
        g.setFont(new Font("Tahoma",Font.BOLD,24));
        if(timer>0)
        {
            g.drawString(time,1100,500);
        }
        else{
            g.drawString("Times Up!!!",1100,500);
        }
        try {
            Thread.sleep(1000);
            timer--;
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(ans_given==1){
            ans_given=0;
            timer=120;
        }else if(timer<0){

            try{
            if(rs.next()){
                count++;
                timer=120;
                repaint();
                start(count);}

            else { setVisible(false);
                new Score(name, score,wrongans);
            }
            }

                catch(Exception ex)
            {
                System.out.println("Reached end of everything submit your test");
            };


            }
            else{
                if(groupoptions.getSelection()==null){
                    useranswer[count][0]="";
                }
                else{

                    useranswer[count][0]=groupoptions.getSelection().getActionCommand();
                }
            }
        }




    public void start(int count){
        try{
            qno.setText(count+1+".");
            question.setText(rs.getString("question"));

            opt1.setText(rs.getString("optiona"));
            question.setEditable(false);

            opt1.setActionCommand(rs.getString("optiona"));
            opt2.setText(rs.getString("optionb"));
            opt2.setActionCommand(rs.getString("optionb"));
            opt3.setText(rs.getString("optionc"));
            opt3.setActionCommand(rs.getString("optionc"));
            opt4.setText(rs.getString("optiond"));
            opt4.setActionCommand(rs.getString("optiond"));

            answers[count][1]=rs.getString("ans");
            groupoptions.clearSelection();}
        catch(Exception ex) { System.out.println(ex); }

    }
    public static void main(String[] args) {

        new Quiz("User","Java Basic");
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){


            ans_given=1;

            if(groupoptions.getSelection()==null){
                useranswer[count][0]="";
                try {
                    // logic of the wrong question is to be added.
                    wrongans[wrong][0] = rs.getString("question");
                    wrongans[wrong][1] = rs.getString("optiona");
                    wrongans[wrong][2] = rs.getString("optionb");
                    wrongans[wrong][3] = rs.getString("optionc");
                    wrongans[wrong][4] = rs.getString("optiond");
                    wrongans[wrong][5] = rs.getString("tag");
                    wrongans[wrong][6] = rs.getString("ans");

                    wrong++;
                }catch(SQLException s){}
            }
            else{
                useranswer[count][0]=groupoptions.getSelection().getActionCommand();
                if(!(useranswer[count][0].equals(answers[count][1]))){
                    try {
                        // logic of the wrong question is to be added.
                        wrongans[wrong][0] = rs.getString("question");
                        wrongans[wrong][1] = rs.getString("optiona");
                        wrongans[wrong][2] = rs.getString("optionb");
                        wrongans[wrong][3] = rs.getString("optionc");
                        wrongans[wrong][4] = rs.getString("optiond");
                        wrongans[wrong][5] = rs.getString("tag");
                        wrongans[wrong][6] = rs.getString("ans");

                        wrong++;
                    }catch(SQLException s){}
                }
            }
            try{
                if(rs.next()){
                    question.setEditable(true);
                    count++;
                    repaint();
                    start(count);}
                else next.setEnabled(false);
            }
            catch(Exception ex)
            {
                System.out.println("Reached end of everything submit your test");
            };

        } else if (ae.getSource()==Submit)
        {
            ans_given=1;
            try{
                if(groupoptions.getSelection()==null){
                    useranswer[count][0]="";
                }
                else{
                    useranswer[count][0]=groupoptions.getSelection().getActionCommand();
                }}catch(Exception e){}
                    boolean bool=true;
                for(int i=0;i<useranswer.length;i++)
                {
                    if(answers[i][1]==null)break;
                    if(useranswer[i][0].equals(answers[i][1])){
                        score+=10;
                    }
                    else if(bool){ try {
                        // logic of the wrong question is to be added.
                        wrongans[wrong][0] = rs.getString("question");
                        wrongans[wrong][1] = rs.getString("optiona");
                        wrongans[wrong][2] = rs.getString("optionb");
                        wrongans[wrong][3] = rs.getString("optionc");
                        wrongans[wrong][4] = rs.getString("optiond");
                        wrongans[wrong][5] = rs.getString("tag");
                        wrongans[wrong][6] = rs.getString("ans");

                        wrong++;
                    }catch(SQLException s){}
                        bool=false;

                    }
                }

            
                setVisible(false);
                new Score(name,score,wrongans);
            
        }else if (ae.getSource()==Clear){
            groupoptions.clearSelection();
        }

    }
}
