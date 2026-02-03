

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



public class SignupOne extends JFrame implements ActionListener {

    JLabel formNo, personalDetails,name,fname,dob,gender,email,mStatus,adr,city,pcode,state;
    JTextField tname,tfather,tdob,temail,tmstatus,tadr,tcity,tpcode,tstate;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;
    long num;




    SignupOne(){
      //Creation of Container or frame ***
        setLayout(null);
        setSize(750,700);
        setLocation(320,50);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);

       //Creation & Addition of Labels ***

        Random ran = new Random();
        num = Math.abs(ran.nextLong()%9000) + 1000;
        formNo = new JLabel("Application Form No. "+ num);
        formNo.setFont(new Font("Arial",Font.BOLD,32));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Arial",Font.BOLD,22));
        personalDetails.setBounds(210,70,400,20);
        add(personalDetails);


        name = new JLabel("Name:");
        name.setFont(new Font("Arial",Font.BOLD,18));
        name.setBounds(80,120,100,20);
        add(name);

        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Arial",Font.BOLD,18));
        fname.setBounds(80,150,200,20);
        add(fname);

        dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Arial",Font.BOLD,18));
        dob.setBounds(80,180,150,20);
        add(dob);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD,18));
        gender.setBounds(80,210,150,20);
        add(gender);

        email = new JLabel("Email Address:");
        email.setFont(new Font("Arial",Font.BOLD,18));
        email.setBounds(80,240,150,20);
        add(email);


        mStatus = new JLabel("Marital Status:");
        mStatus.setFont(new Font("Arial",Font.BOLD,18));
        mStatus.setBounds(80,270,150,20);
        add(mStatus);

        adr = new JLabel("Address:");
        adr.setFont(new Font("Arial",Font.BOLD,18));
        adr.setBounds(80,300,150,20);
        add(adr);

        city = new JLabel("City:");
        city.setFont(new Font("Arial", Font.BOLD,18));
        city.setBounds(80,340,150,20);
        add(city);

        pcode =new JLabel("Pin Code:");
        pcode.setFont(new Font("Arial",Font.BOLD,18));
        pcode.setBounds(80,370,150,20);
        add(pcode);

        state = new JLabel("State:");
        state.setFont(new Font("Arial",Font.BOLD,18));
        state.setBounds(80,400,150,20);
        add(state);

        //tname,tfather,tdob,temail,tmstatus,tadr,tcity,tpcode,tstate;

        tname = new JTextField();
        add(tname);
        tname.setBounds(270,120,350,20);
        tname.setFont(new Font("Arial", Font.BOLD,18));

        tfather = new JTextField();
        add(tfather);
        tfather.setBounds(270,150,350,20);
        tfather.setFont(new Font("Arial", Font.BOLD,18));

        temail = new JTextField();
        add(temail);
        temail.setBounds(270,240,350,20);
        temail.setFont(new Font("Arial", Font.BOLD,18));



        tadr = new JTextField();
        add(tadr);
        tadr.setBounds(270,300,350,20);
        tadr.setFont(new Font("Arial", Font.BOLD,18));


        tcity = new JTextField();
        add(tcity);
        tcity.setBounds(270,335,350,20);
        tcity.setFont(new Font("Arial", Font.BOLD,18));


        tpcode = new JTextField();
        add(tpcode);
        tpcode.setBounds(270,365,350,20);
        tpcode.setFont(new Font("Arial", Font.BOLD,18));


        tstate = new JTextField();
        add(tstate);
        tstate.setBounds(270,400,350,20);
        tstate.setFont(new Font("Arial", Font.BOLD,18));

        dateChooser = new JDateChooser();
        add(dateChooser);
        dateChooser.setBounds(270,180,300,20);
        pack();
        setSize(750,700);

        male = new JRadioButton("Male");
        add(male);
        male.setBounds(270,210,110,20);
        male.setBackground(Color.WHITE);
        ButtonGroup g1 = new ButtonGroup();
        g1.add(male);

        female = new JRadioButton("Female");
        add(female);
        female.setBounds(400,210,150,20);
        female.setBackground(Color.WHITE);
        ButtonGroup g2 = new ButtonGroup();
        g1.add(female);

        married = new JRadioButton("Married");
        add(married);
        married.setBounds(270,270,130,20);
        married.setBackground(Color.WHITE);
        ButtonGroup g3 = new ButtonGroup();
        g3.add(married);

        unmarried = new JRadioButton("UnMarried");
        add(unmarried);
        unmarried.setBounds(400,270,150,20);
        unmarried.setBackground(Color.WHITE);
        g3.add(unmarried);

        other = new JRadioButton("Others");
        add(other);
        other.setBounds(550,270,150,20);
        other.setBackground(Color.WHITE);
        g3.add(other);

        next = new JButton("NEXT");
        add(next);
        next.addActionListener(this);
        next.setBounds(510,500,100,20);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("calibri", Font.BOLD,18 ));





    }
    public static void main (String args[]){
        new SignupOne();

    }

    public void actionPerformed(ActionEvent e){
        //JTextField tname,tfather,tdob,temail,tmstatus,tadr,tcity,tpcode,tstate;
        //    JRadioButton male,female,married,unmarried,other;
        String formno = ""+num;
        String name = tname.getText();
        String fname= tfather.getText();
        String dob= ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String mail = temail.getText();

        String mstats= null;
        if(married.isSelected()){
            mstats = "Married";
        }else if(unmarried.isSelected()){
            mstats = "UnMarried";
        }else if(other.isSelected()) {
            mstats = "Others";
        }

        String add= tadr.getText();
        String city = tcity.getText();
        String pin = tpcode.getText();
        String st = tstate.getText();

        try{
        if (name.isEmpty()){
            JOptionPane.showMessageDialog(null,"Name is Required");
        } else{
            //adding data into database

            Con c1 = new Con();
            String query = "insert into Signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+mail+"','"+mstats+"','"+add+"','"+city+"','"+pin+"','"+st+"')";
            c1.s.executeUpdate(query);
            setVisible(false);
            new SignupTwo(formno).setVisible(true);

        }
        }catch (Exception E){
                System.out.println("Here:"+E.getMessage());
        }
    }

}
