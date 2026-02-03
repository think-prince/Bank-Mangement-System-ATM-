import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {

        JLabel  addDetails,religion,cat,income,education,occupation,pan,aadhar,seniorCitizen,account;
        JComboBox toccupation,treligion,tcat,tincome,tedu;
        JTextField tpan, taadhar;
        JRadioButton syes, sno, eyes,eno;
        JButton next;
        String formno;






//Constructor Call
        SignupTwo(String form_no){

            this.formno=form_no;
            //Creation of Container or frame ***
            setLayout(null);
            setSize(750,700);
            setLocation(320,50);
            getContentPane().setBackground(Color.WHITE);

            setVisible(true);
            setTitle("NEW ACCOUNT APPLICATION FOR - Page:2");

            //Creation & Addition of Labels ***
           // religion,cat,income,education,occupation,pan,aadhar,seniorCitizen,account

            addDetails = new JLabel("Page 2: Additional Details");
            addDetails.setFont(new Font("Arial",Font.BOLD,22));
            addDetails.setBounds(230,70,400,70);
            add(addDetails);


            religion = new JLabel("Religion:");
            religion.setFont(new Font("Arial",Font.BOLD,18));
            religion.setBounds(80,140,100,40);
            add(religion);

            cat = new JLabel("Category:");
            cat.setFont(new Font("Arial",Font.BOLD,18));
            cat.setBounds(80,170,200,40);
            add(cat);

            income = new JLabel("Income:");
            income.setFont(new Font("Arial",Font.BOLD,18));
            income.setBounds(80,200,150,40);
            add(income);

            education = new JLabel("Education:");
            education.setFont(new Font("Arial", Font.BOLD,18));
            education.setBounds(80,230,150,40);
            add(education);

            occupation = new JLabel("Occupation:");
            occupation.setFont(new Font("Arial",Font.BOLD,18));
            occupation.setBounds(80,260,150,40);
            add(occupation);


            pan = new JLabel("PAN No.:");
            pan.setFont(new Font("Arial",Font.BOLD,18));
            pan.setBounds(80,290,150,40);
            add(pan);

            aadhar = new JLabel("Aadhar No.:");
            aadhar.setFont(new Font("Arial",Font.BOLD,18));
            aadhar.setBounds(80,320,150,40);
            add(aadhar);

            seniorCitizen = new JLabel("Senior Citizen:");
            seniorCitizen.setFont(new Font("Arial", Font.BOLD,18));
            seniorCitizen.setBounds(80,360,150,40);
            add(seniorCitizen);

            account =new JLabel("Existing Account:");
            account.setFont(new Font("Arial",Font.BOLD,18));
            account.setBounds(80,390,160,40);
            add(account);

            //**Adding drop down menu to enter

            String []  varReligion= {"Buddhist","Hindu","Muslim","Sikh","Christian", "Others"};
            treligion = new JComboBox(varReligion);
            add(treligion);
            treligion.setBounds(270,145,350,20);
            treligion.setFont(new Font("Arial",Font.BOLD,14));

            String[] varCategory = {"General","SC","ST","OBC"};
            tcat = new JComboBox(varCategory);
            add(tcat);
            tcat.setBounds(270,180,350,20);
            tcat.setFont(new Font("Arial",Font.BOLD,14));

            String[] varIncome = {"< 1.5L","< 3L","<5L","<10L",">10L"};
            tincome = new JComboBox(varIncome);
            add(tincome);
            tincome.setBounds(270,210,350,20);
            tincome.setFont(new Font("Arial",Font.BOLD,14));

            String[] varEdu = {"10th","12th","Graduate","Master's","PhD"};
            tedu = new JComboBox(varEdu);
            add(tedu);
            tedu.setBounds(270,240,350,20);
            tedu.setFont(new Font("Arial",Font.BOLD,14));

            String[] varOccupation = {"Salaried","Business","Self-Employed","Student","Others"};
            toccupation = new JComboBox(varOccupation);
            add(toccupation);
            toccupation.setBounds(270,270,350,20);
            toccupation.setFont(new Font("Arial",Font.BOLD,14));

            tpan = new JTextField();
            add(tpan);
            tpan.setBounds(270,300,350,20);
            tpan.setBackground(Color.WHITE);
            tpan.setFont(new Font("Arial",Font.BOLD,14));

            taadhar = new JTextField();
            add(taadhar);
            taadhar.setBounds(270,330,350,20);
            taadhar.setBackground(Color.WHITE);
            taadhar.setFont(new Font("Arial",Font.BOLD,14));

            syes = new JRadioButton("Yes");
            add(syes);
            syes.setBounds(300,370,100,20);
            syes.setBackground(Color.WHITE);

            sno = new JRadioButton("No");
            add(sno);
            sno.setBounds(450,370,100,20);
            sno.setBackground(Color.WHITE);

            ButtonGroup b1 = new ButtonGroup();
            b1.add(syes);
            b1.add(sno);

            eyes = new JRadioButton("Yes");
            add(eyes);
            eyes.setBounds(300,405,100,20);
            eyes.setBackground(Color.WHITE);

            eno = new JRadioButton("No");
            add(eno);
            eno.setBounds(450,405,100,20);
            eno.setBackground(Color.WHITE);

            ButtonGroup b2 = new ButtonGroup();
            b2.add(eyes);
            b2.add(eno);

            next = new JButton("NEXT");
            add(next);
            next.addActionListener(this);
            next.setBounds(510,500,100,20);
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setFont(new Font("calibri", Font.BOLD,18 ));
        }

        public void actionPerformed(ActionEvent e){

            String sreligion = (String) treligion.getSelectedItem();
            String scategory = (String) tcat.getSelectedItem();
            String sincome = (String) tincome.getSelectedItem();
            String seducation = (String) tedu.getSelectedItem();
            String soccupation = (String) toccupation.getSelectedItem();

            String span = tpan.getText();
            String saadhar = taadhar.getText();

            String scitizen = null;
            if(syes.isSelected()){
                scitizen ="Yes";
            } else if(sno.isSelected()){
                scitizen = "No";
            }

            String saccount = null;
            if(eyes.isSelected()){
                saccount = "Yes";
            } else if (eno.isSelected()) {
                saccount = "No";

            }

            try{
                if (span.isEmpty()||saadhar.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fill the Required Field");
               } else{
                    //adding data into database

                    Con c1 = new Con();

                    String query = "insert into Signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+scitizen+"','"+saccount+"')";
                    c1.s.executeUpdate(query);
                    setVisible(false);
                    Signupthree s3 = new Signupthree(formno);
                    s3.setVisible(true);
                }
            }catch (Exception E){
              System.out.println("Here:"+E.getMessage());
            }
        }

    public static void main (String args[]){
        new SignupTwo("");

    }


}
