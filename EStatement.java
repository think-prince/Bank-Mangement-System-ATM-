import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class EStatement extends JFrame {
    JLabel l1, card,stat,actbal;
    String pinNum;

    EStatement(String pin){
        this.pinNum= pin;
        setLayout(null);
        setSize(600,600);
        setLocation(300,0);
        setTitle("Account Statement");
        setVisible(true);



        l1 = new JLabel("HDFC Bank");
        add(l1);
        l1.setBounds(300,0,150,25);

        card = new JLabel();
        add(card);
        card.setBounds(50,50,200,25);

        stat = new JLabel();
        add(stat);
        stat.setBounds(50,150,400,200);


        Con c = new Con();

        try{

            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinNum+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+ "xxxxxxxxxx"
                            +rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        int bal =0;

        try{
            ResultSet rs2 = c.s.executeQuery("select * from bank where pin='"+pinNum+"' order by date desc limit 5");
            while(rs2.next()){
                stat.setText(stat.getText() + "<html>"+ rs2.getString("date")+"       "+
                        rs2.getString("type")+"        "+rs2.getString("amount")+"<br><br><html>");


                if(rs2.getString("type").equals("Deposit")){

                    bal += Integer.parseInt(rs2.getString("amount"));

                } else if (rs2.getString("type").equals("fastcash")) {
                    bal -= Integer.parseInt(rs2.getString("amount"));

                }else if ((rs2.getString("type").equals("Withdrawal"))){
                    bal -= Integer.parseInt(rs2.getString("amount"));
                }
            }

             actbal = new JLabel("Your account balance is: "+bal);
                    add(actbal);
                    actbal.setBounds(50,70,200,25);

        } catch (Exception e) {
            System.out.println(e);;
        }
    }
    public static void main(String[] args) {
        new EStatement("");

    }
}
