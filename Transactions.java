import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel l1;
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balance,exit ;
    String pinNum;

    Transactions( String pin){
        this.pinNum = pin;
        setLayout(null);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0,0,900,900);

        l1 = new JLabel("Please Select The Transactions you Want");
        image.add(l1);
        l1.setBounds(210,280,300,50);
        l1.setForeground(Color.WHITE);


        deposit = new JButton("Deposit");
        image.add(deposit);
        deposit.setBounds(165,417,150,25);
        deposit.addActionListener(this);

        withdrawl = new JButton("Withdrawl");
        image.add(withdrawl);
        withdrawl.setBounds(360,417,150,25);
        withdrawl.addActionListener(this);

        fastcash = new JButton("Fastcash");
        image.add(fastcash);
        fastcash.setBounds(165,450,150,25);
        fastcash.addActionListener(this);

        ministatement = new JButton("Mini Statement");
        image.add(ministatement);
        ministatement.setBounds(360,450,150,25);
        ministatement.addActionListener(this);

        pinchange = new JButton("Pin Change");
        image.add(pinchange);
        pinchange.setBounds(165,485,150,25);
        pinchange.addActionListener(this);

        balance = new JButton("Balance Inquiry");
        image.add(balance);
        balance.setBounds(360,485,150,25);
        balance.addActionListener(this);

        exit = new JButton("EXIT");
        image.add(exit);
        exit.setBounds(360,520,150,25);
        exit.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);

        } else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNum).setVisible(true);
        }else if (ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinNum).setVisible(true);
        } else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinNum).setVisible(true);
        } else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinNum).setVisible(true);

        } else if (ae.getSource()==balance){
            setVisible(false);
            new Balance(pinNum).setVisible(true);
        }
        else if(ae.getSource()==ministatement){

            new EStatement(pinNum).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Transactions("");


    }
}
