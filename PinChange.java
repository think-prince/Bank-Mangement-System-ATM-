import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JLabel l1, text1,text2,text3;
    JPasswordField npin,rpin;
    JButton change, back;
    String pinNum;

    PinChange(String pin) {
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

        text1 = new JLabel("Pin Change");
        l1.add(text1);
        text1.setBounds(280, 280, 300, 50);
        text1.setFont(new Font("Arial", Font.BOLD, 18));
        text1.setForeground(Color.WHITE);

        text2 = new JLabel("Enter New Pin:");
        l1.add(text2);
        text2.setBounds(170, 320, 150, 50);
        text2.setFont(new Font("Arial", Font.BOLD, 16));
        text2.setForeground(Color.WHITE);


        text3 = new JLabel("Re-Enter Pin:");
        l1.add(text3);
        text3.setBounds(170, 360, 300, 50);
        text3.setFont(new Font("Arial", Font.BOLD, 16));
        text3.setForeground(Color.WHITE);

        npin = new JPasswordField();
        l1.add(npin);
        npin.setBounds(300, 335, 100, 20);

        rpin = new JPasswordField();
        l1.add(rpin);
        rpin.setBounds(300, 375, 100, 20);

        change = new JButton("Save");
        l1.add(change);
        change.setBounds(420,490,100,25);
        change.addActionListener(this);

        back = new JButton("Back");
        l1.add(back);
        back.setBounds(420,520,100,25);
        back.addActionListener(this);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNum).setVisible(true);
        } else if (ae.getSource()== change) {
            String newPin = npin.getText();
            String rePin = rpin.getText();
            if(newPin.isEmpty()||rePin.isEmpty()){
                JOptionPane.showMessageDialog(null, "New Pin or Re-Enter Pin is blank");
            }else if(!newPin.equals(rePin)){
                JOptionPane.showMessageDialog(null,"New Pin not Matching with the Re-Pin");
            }else if(newPin.equals(pinNum)){
                JOptionPane.showMessageDialog(null,"New Pin cannot be same as Old pin. Re-Enter New PIN");
            } else if((newPin.equals(rePin)) && (!newPin.equals(pinNum))) {
                Con c = new Con();
                try{
                    String query1 = "Update signupthree set pin= '"+newPin+"' where pin= '"+pinNum+"'";
                    String query2 = "Update login set pin='"+newPin+"' where pin= '"+pinNum+"'";
                    String query3 ="Update bank set pin= '"+newPin+"' where pin='"+pinNum+"'";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null,"Pin changed successfully");
                    setVisible(false);
                    new Transactions(newPin).setVisible(true);


                }catch (Exception E){
                    System.out.println(E.getMessage());
                }
            }
        }
    }




    public static void main(String[] args) {
        new PinChange("");
    }



}
