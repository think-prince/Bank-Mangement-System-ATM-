import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener{
    JLabel l1, text1,text2;
    //JPasswordField npin,rpin;
    JButton check, back;
    String pinNum;



    Balance(String pin){

        this.pinNum = pin;

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        add(l1);
        l1.setBounds(0, 0, 900, 900);

        text1 = new JLabel("Balance Enquiry");
        l1.add(text1);
        text1.setBounds(280, 280, 300, 50);
        text1.setFont(new Font("Arial", Font.BOLD, 18));
        text1.setForeground(Color.WHITE);

        text2 = new JLabel(" CLick on Check Balance Button");
        l1.add(text2);
        text2.setBounds(170, 320, 500, 50);
        text2.setFont(new Font("Arial", Font.BOLD, 14));
        text2.setForeground(Color.WHITE);

        check = new JButton("Check Balance");
        l1.add(check);
        check.setBounds(390,490,130,25);
        check.addActionListener(this);

        back = new JButton("Back");
        l1.add(back);
        back.setBounds(420,520,100,25);
        back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNum).setVisible(true);
        }
        else if(ae.getSource()==check){
            int bal=0;
            String query = "Select * from bank where pin= '"+pinNum+"'";
            Con c = new Con();

            try{

                ResultSet rs =c.s.executeQuery(query);
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        
                        bal += Integer.parseInt(rs.getString("amount"));
                        
                    } else if (rs.getString("type").equals("fastcash")) {
                        bal -= Integer.parseInt(rs.getString("amount"));
                        
                    }else if ((rs.getString("type").equals("Withdrawal"))){
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }

                }
                JOptionPane.showMessageDialog(null, "Your Account Balance is: Rs. " + bal+"");
                setVisible(false);
                new Transactions(pinNum).setVisible(true);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        new Balance("");

    }
}
