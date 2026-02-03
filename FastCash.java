import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JLabel l1;
    JButton amt100,amt500,amt1000,amt2000,amt5k,amt10k,back ;
    String pinNum;

    FastCash( String pin){
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

        l1 = new JLabel("Please Select The FastCash Amount you Want");
        image.add(l1);
        l1.setBounds(210,280,300,50);
        l1.setForeground(Color.WHITE);


        amt100 = new JButton("Rs 100");
        image.add(amt100);
        amt100.setBounds(165,417,150,25);
        amt100.addActionListener(this);

        amt500 = new JButton("Rs 500");
        image.add(amt500);
        amt500.setBounds(360,417,150,25);
        amt500.addActionListener(this);

        amt1000 = new JButton("Rs 1000");
        image.add(amt1000);
        amt1000.setBounds(165,450,150,25);
        amt1000.addActionListener(this);

        amt2000 = new JButton("Rs 2000");
        image.add(amt2000);
        amt2000.setBounds(360,450,150,25);
        amt2000.addActionListener(this);

        amt5k = new JButton("Rs 5000");
        image.add(amt5k);
        amt5k.setBounds(165,485,150,25);
        amt5k.addActionListener(this);

        amt10k = new JButton("Rs 10000");
        image.add(amt10k);
        amt10k.setBounds(360,485,150,25);
        amt10k.addActionListener(this);

        back = new JButton("Back");
        image.add(back);
        back.setBounds(360,520,150,25);
        back.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){
        Date date = new Date();
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNum).setVisible(true);

        } else {

            String amt = ((JButton)ae.getSource()).getText().substring(3);
            String query = "Select * from bank where pin = '"+pinNum+"'";
            Con c = new Con();
            try{

                ResultSet rs = c.s.executeQuery(query);
                int balance=0;
                while(rs.next()){

                    if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    } else if ((rs.getString("type").equals("Withdrawal"))|| rs.getString("type").equals("fastcash")) {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                }
                if(ae.getSource() != back && balance < Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                } else if (balance >= Integer.parseInt(amt)) {
                    String query2 = "Insert into bank values('"+pinNum+"','"+date+"','fastcash','"+amt+"')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Cash Rs."+amt+" debited Successful");
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);

                }
            }catch (Exception E){
                System.out.println(E.getMessage());
            }


        }

    }



    public static void main(String[] args){
        new FastCash("");


    }
}



