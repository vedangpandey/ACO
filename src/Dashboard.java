import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

   public class Dashboard{

       public static String name;
       Dashboard(String name){
           this.name=name;
           JFrame frame = new JFrame("JAVA OCA PROJECT");
           ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
           frame.setIconImage(img.getImage());

           JLabel label = new JLabel("JAVA ORACLE CERTIFIED ASSOCIATE");
           label.setBounds(120, 30, 600, 30);
           label.setFont(new Font("Tahoma", Font.BOLD, 28));
           label.setBackground(new Color(94, 66, 48));
           frame.add(label);

           frame.setSize(700,500);
           frame.setLocationRelativeTo(null);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Container c = frame.getContentPane();
           c.setBackground(Color.WHITE);

           c.setLayout(null);


           // BASICS
           String[] values = {"Java Basic", "Java Data Types", "Java Methods","Methods - Overloading", "Java Arrays","Java LambdaExpression","Java OOPS","Java InstanceOf","Java Inheritance","Overloading","Exceptional Handling","Handling Exceptions"};
           JComboBox<String> c1 = new JComboBox<>(values);
           c1.setBounds(200,150,200,50);
           c.add(c1);
           c1.setFont(new Font("arial",Font.PLAIN,18));

           JButton button = new JButton("Quick Test");
           button.setBounds(200,250,100,40);
           button.setBackground(new Color(94, 66, 48));
           button.setForeground(Color.white);
           c.add(button);



           button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                   String item = (String)c1.getSelectedItem();
                   switch (item){
                       case "Java Basic":frame.setVisible(false); new Quiz("User","Java Basic");
                           break;
                       case "Java Data Types":frame.setVisible(false);new Quiz("User","Java Data Types");
                           break;
                       case "Java Loops":frame.setVisible(false);new Quiz("User","Java Loops");
                           break;
                       case "Java Methods":frame.setVisible(false); new Quiz("User","Java Methods");
                           break;
                       case "Java Arrays":frame.setVisible(false);new Quiz("User","Java Arrays");
                           break;
                       case "Methods - Overloading":frame.setVisible(false);new Quiz("User","Methods - Overloading");
                           break;
                       case "Java Inheritance":frame.setVisible(false);new Quiz("User","Inheritance");
                           break;
                       case "Java InstanceOf":frame.setVisible(false);new Quiz("User","instanceof");
                           break;
                       case "Java LambdaExpression":frame.setVisible(false);new Quiz("User","Lambda Expressions");
                           break;
                       case "Exceptional Handling":frame.setVisible(false);new Quiz("User","Exceptional Handling");
                           break;
                       case "Handling Exceptions":frame.setVisible(false);new Quiz("User","Handling Exceptions");
                           break;
                       case "Overloading":frame.setVisible(false);new Quiz("User","Overloading");
                           break;

                   }
               }
           });



           frame.setResizable(false);
           frame.setVisible(true);
       }
   }



