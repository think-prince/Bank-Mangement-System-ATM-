import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JLabel l1, cash;
    JTextField inputCash;
    JButton deposit, clear, back;
    String pinNum;

    Deposit(String pin){
        this.pinNum= pin;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        add(l1);
        l1.setBounds(0,0,900,900);


        cash = new JLabel("Enter Amount to deposit");
        l1.add(cash);
        cash.setForeground(Color.WHITE);
        cash.setBounds(170,300,400,25);
        cash.setFont(new Font("Arial",Font.BOLD,18));


        inputCash = new JTextField();
        l1.add(inputCash);
        inputCash.setBounds(170,400, 300,25);
        inputCash.setForeground(Color.BLACK);
        inputCash.setFont(new Font("Arial",Font.BOLD,12));

        deposit = new JButton("Deposit");
        l1.add(deposit);
        deposit.setBounds(355,490,150,25);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);

        back = new JButton("Back");
        l1.add(back);
        back.setBounds(355,525,150,25);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);

    }


    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==deposit){
            String number = inputCash.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Insert Amount to Deposit");
            }else
                {
                    try {
                        Con c = new Con();
                        String query = "Insert into bank values('"+pinNum+"', '"+date+"', 'Deposit','"+number+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs."+number+" deposited successfully");
                    }catch (Exception E) {
                        System.out.println(E.getMessage());
                    }
                }



        }else if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNum).setVisible(true);

        }


    }


    public static void main(String[] args) {
        new Deposit("");
    }
}
