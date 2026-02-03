
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Signupthree extends JFrame implements ActionListener {

    JLabel actdetails, acttype,cardNo,number, pin, pnumber, service;
    JRadioButton sa,ca,fda,rda;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String form_no;

    Signupthree(String formno) {
        this.form_no = formno;

        setLayout(null);
        setSize(750,700);
        setLocation(320,50);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Account Details Tab");

        actdetails = new JLabel("Page:3 Account Details");
        actdetails.setBounds(230,50,400,50);
        actdetails.setFont(new Font("Arial",Font.BOLD,22));
        add(actdetails);

        acttype = new JLabel("Account Type");
        add(acttype);
        acttype.setBounds(80,140,200,40);
        acttype.setFont(new Font("Arial",Font.BOLD,20));

        cardNo = new JLabel("Card Number:");
        add(cardNo);
        cardNo.setBounds(80,250,200,40);
        cardNo.setFont(new Font("Arial",Font.BOLD,20));

        number = new JLabel("XXXX-XXXX-XXXX-1642");
        add(number);
        number.setBounds(300,250,250,40);
        number.setFont(new Font("Arial",Font.BOLD,20));

        JLabel card = new JLabel("(your 16 digit Card No.)");
        add(card);
        card.setBounds(80,270,200,40);
        card.setFont(new Font("Arial",Font.BOLD,12));

        pin = new JLabel("PIN");
        add(pin);
        pin.setBounds(80,300,200,40);
        pin.setFont(new Font("Arial",Font.BOLD,20));

        pnumber = new JLabel("XXXX");
        add(pnumber);
        pnumber.setBounds(300,300,200,40);
        pnumber.setFont(new Font("Arial",Font.BOLD,20));

        JLabel p1 = new JLabel("(4 digit password)");
        add(p1);
        p1.setBounds(80,320,200,40);
        p1.setFont(new Font("Arial",Font.BOLD,12));

        service = new JLabel("Services Required:");
        add(service);
        service.setBounds(80,360,200,40);
        service.setFont(new Font("Arial",Font.BOLD,20));

        sa = new JRadioButton("Saving Account");
        add(sa);
        sa.setBounds(80,180,150,20);
        sa.setFont(new Font("Arial",Font.BOLD,14));
        sa.setBackground(Color.WHITE);
        ButtonGroup b = new ButtonGroup();
        b.add(sa);

        fda = new JRadioButton("Fixed Deposit Account");
        add(fda);
        fda.setBounds(300,180,200,20);
        fda.setFont(new Font("Arial",Font.BOLD,14));
        fda.setBackground(Color.WHITE);
        b.add(fda);

        ca = new JRadioButton("Current Account");
        add(ca);
        ca.setBounds(80,220,200,20);
        ca.setFont(new Font("Arial",Font.BOLD,14));
        ca.setBackground(Color.WHITE);
        b.add(ca);

        rda = new JRadioButton("Recurring Deposit Account");
        add(rda);
        rda.setBounds(300,220,250,20);
        rda.setFont(new Font("Arial",Font.BOLD,14));
        rda.setBackground(Color.WHITE);
        b.add(rda);

        c1 = new JCheckBox("ATM Card");
        add(c1);
        c1.setBounds(80,400,200,40);
        c1.setFont(new Font("Arial",Font.BOLD,14));
        c1.setBackground(Color.WHITE);
        ButtonGroup b2 = new ButtonGroup();
        b2.add(c1);


        c2 = new JCheckBox("INTERNET BANKING");
        add(c2);
        c2.setBounds(315,400,200,40);
        c2.setFont(new Font("Arial",Font.BOLD,14));
        c2.setBackground(Color.WHITE);
        b2.add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        add(c3);
        c3.setBounds(80,430,200,40);
        c3.setFont(new Font("Arial",Font.BOLD,14));
        c3.setBackground(Color.WHITE);
        b2.add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        add(c4);
        c4.setBounds(315,430,200,40);
        c4.setFont(new Font("Arial",Font.BOLD,14));
        c4.setBackground(Color.WHITE);
        b2.add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        add(c5);
        c5.setBounds(80,460,200,40);
        c5.setFont(new Font("Arial",Font.BOLD,14));
        c5.setBackground(Color.WHITE);
        b2.add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        add(c6);
        c6.setBounds(315,460,200,40);
        c6.setFont(new Font("Arial",Font.BOLD,14));
        c6.setBackground(Color.WHITE);
        b2.add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my Knowledge.");
        add(c7);
        c7.setBounds(50,510,700,40);
        c7.setFont(new Font("Arial",Font.PLAIN,16));
        c7.setBackground(Color.WHITE);


        submit = new JButton("SUBMIT");
        add(submit);
        submit.setBounds(200,560,90,20);
        submit.setFont(new Font("Arial",Font.BOLD,14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);


        cancel = new JButton("CANCEL");
        add(cancel);
        cancel.setBounds(350,560,100,20);
        cancel.setFont(new Font("Arial",Font.BOLD,14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);

    }

     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = null;
            if (sa.isSelected()){
                accountType= "Saving Account";
            } else if(fda.isSelected()){
                accountType = "Fixed Deposit Account";
            } else if(ca.isSelected()){
                accountType = "Current Account";
            } else if (rda.isSelected()){
                accountType="Recurring Deposit Account";
            }

            Random random =new Random();
            String cardNumber = "" + (Math.abs((random.nextLong() % 90000000L)) + 5049784500000000L);
            String pinNumber = ""+ (Math.abs((random.nextLong()) % 900L)+1000L);

            String serviceReq=null;
            if(c1.isSelected()){
                serviceReq= "ATM Card";
            } else if (c2.isSelected()){
                serviceReq ="INTERNET BANKING";
            }else if (c3.isSelected()){
                serviceReq ="MOBILE BANKING";
            }else if (c4.isSelected()){
                serviceReq ="Email & SMS Alerts";
            }else if (c5.isSelected()){
                serviceReq ="CHEQUE BOOK";
            }else if (c6.isSelected()){
                serviceReq ="E-STATEMENT";
            }

            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else if (serviceReq.equals("")){
                    JOptionPane.showMessageDialog(null,"Service Type is Required");
                } else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null,"Declaration needs to be selected");
                }
                else{
                    Con c2 = new Con();
                    String query1 = "Insert into Signupthree values('"+form_no+"', '"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+serviceReq+"')";
                    c2.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"CardNumber:"+ cardNumber + "\nPIN:"+ pinNumber);
                    String query2 = "Insert into Login values('"+form_no+"','"+cardNumber+"', '"+pinNumber+"')";
                    c2.s.executeUpdate(query2);
                }
            }catch (Exception e){
                System.out.println(e);
            }











        } else if (ae.getSource()==cancel){



        }
     }
    public static void main(String[] args) {
        new Signupthree("");

    }






}
