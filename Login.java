import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    String pinNumber;

    public void setComponents(){

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l4= new JLabel(i3);
        add(l4);
        l4.setBounds(50,70,80,70);


        l1 = new JLabel("Welcome To ATM");
        add(l1);
        l1.setBounds(150,70,300,70);
        l1.setFont(new Font("Onward",Font.BOLD,30));


        l2 = new JLabel("Card No:");
        add(l2);
        l2.setBounds(150,100,100,200);
        l2.setFont(new Font("Osward",Font.BOLD,22));

        t1 = new JTextField();
        add(t1);
        t1.setBounds(270,185,180,30);
        t1.setFont(new Font("Osward",Font.BOLD,20));


        l3 = new JLabel("Password:");
        add(l3);
        l3.setBounds(150,150,150,200);
        l3.setFont(new Font("Osward", Font.BOLD,22));

        t2 = new JPasswordField();
        add(t2);
        t2.setBounds(270,235,180,30);
        t2.setFont(new Font("Osward", Font.BOLD,20));


        b1 = new JButton("SIGN IN");
        b1.setBounds(150,350,100,40);
        add(b1);
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);


        b2 = new JButton("CLEAR");
        b2.setBounds(270,350, 170,40);
        add(b2);
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);

        b3 = new JButton("SIGN UP");
        b3.setBounds(150,400,290,40);
        add(b3);
        b3.setBackground(Color.black);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
    }
   public void actionPerformed(ActionEvent e){
        if(e.getSource()==b2){
            t1.setText("");
            t2.setText("");
        }else if(e.getSource()== b1){
            Con c3 = new Con();
            String cardNumber = t1.getText();
            pinNumber = t2.getText();
            String query = "Select * from login where CardNumber = '"+cardNumber+"' and PIN = '"+pinNumber+"'";
            try {
                ResultSet rs= c3.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect CardNumber Or PIN");
                }
            } catch (Exception E) {
                System.out.println(E);;
            }
        }else if (e.getSource()== b3){
           setVisible(false);
           SignupOne s1 = new SignupOne();
           s1.setVisible(true);
        }
   }
    public static void main(String[] args) {
        Login jf = new Login();
        jf.setTitle("AUTOMATED TELLER MACHINE");
        jf.setVisible(true);
        jf.setSize(600,700);
        jf.setLocation(300,50);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setComponents();

    }
}