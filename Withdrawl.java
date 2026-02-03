import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Objects;


public class Withdrawl extends JFrame implements ActionListener{

    JLabel l1, text;
    JTextField amount;
    JButton withdraw, back;
    String pinNum;

    Withdrawl(String pin){
        this.pinNum =pin;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1= new JLabel(i3);
        add(l1);
        l1.setBounds(0,0,900,900);

        text = new JLabel("Enter Amount to Withdraw");
        l1.add(text);
        text.setBounds(170,300,200,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD,16));

        amount = new JTextField();
        l1.add(amount);
        amount.setBounds(170,350,200,25);

        withdraw = new JButton("Withdraw");
        l1.add(withdraw);
        withdraw.setBounds(410,490,100,25);
        withdraw.addActionListener(this);

        back = new JButton("Back");
        l1.add(back);
        back.setBounds(410,525,100,25);
        back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNum).setVisible(true);
        } else if(ae.getSource()==withdraw){
            int number=0;
            try {

                 number = Integer.parseInt(amount.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "incorrect format");
            }

            if(number ==0 || amount.getText()==""){
                JOptionPane.showMessageDialog(null,"Insert amount to withdraw ");
            }else if (number>0){

                try {
                    Con c = new Con();
                    Date date = new Date();
                    String query = "Insert into Bank Values('" + pinNum + "','" + date + "','Withdrawal','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Amount Rs. "+number+" has been withdrawn suceessfully");
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
