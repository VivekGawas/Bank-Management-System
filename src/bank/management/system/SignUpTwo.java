
package bank.management.system;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener {
    
    String formno;
    JTextField panText, aadharText, existAcc;
    JButton next;
    JRadioButton yes, no;
    JComboBox religionBox, incomeBox, educationBox, occupationBox;
    Container c;
    SignUpTwo(String formno){
        
        this.formno=formno;
        c=getContentPane();
        c.setLayout(null);
        
        // personal details
        JLabel addDetails=new JLabel("Page 2: Additonal Details");
        addDetails.setFont(new Font("Roboto", Font.BOLD, 20));
        addDetails.setBounds(270, 40, 600, 40);
        c.add(addDetails);
        
        // religion
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Roboto", Font.BOLD, 18));
        religion.setBounds(70, 90, 80, 40);
        c.add(religion);
        
        String[] val={"Hindu", "Muslim", "Christian", "Sikh", "Other"};
        religionBox=new JComboBox(val);
        religionBox.setFont(new Font("Roboto", Font.BOLD, 18));
        religionBox.setBounds(260,100, 450, 25);
        c.add(religionBox);
        
        // Income
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Roboto", Font.BOLD, 18));
        income.setBounds(70, 140, 200, 40);
        c.add(income);
        
        String val2[]={"null", "< 1,00,000", "< 2,00,000", "< 5,00,000", "upto 10,00,000", "above 10,00,000"};
        incomeBox=new JComboBox(val2);
        incomeBox.setFont(new Font("Roboto", Font.BOLD, 18));
        incomeBox.setBounds(260,150, 450, 25);
        c.add(incomeBox);
        
        // education
        JLabel education=new JLabel("Educational");
        education.setFont(new Font("Roboto", Font.BOLD, 18));
        education.setBounds(70, 190, 200, 40);
        c.add(education);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Roboto", Font.BOLD, 18));
        qualification.setBounds(70, 210, 200, 40);
        c.add(qualification);
        
        String val3[]={"Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Others"};
        educationBox=new JComboBox(val3);
        educationBox.setBounds(260, 210, 450, 25);
        c.add(educationBox);
        
        // Occupation
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Roboto", Font.BOLD, 18));
        occupation.setBounds(70, 260, 200, 40);
        c.add(occupation);
        
        
        String val4[]={"Salaried", "Student", "Self-Employed", "Business", "Retired", "Others"};
        occupationBox=new JComboBox(val4);
        occupationBox.setBounds(260, 270, 150, 25);
        occupationBox.setBackground(Color.white);
        c.add(occupationBox);
        
        
        // Pan
        JLabel pan=new JLabel("Pan number:");
        pan.setFont(new Font("Roboto", Font.BOLD, 18));
        pan.setBounds(70, 310, 200, 40);
        c.add(pan);
        
        panText=new JTextField();
        panText.setFont(new Font("Roboto", Font.BOLD, 18));
        panText.setBounds(260,320, 450, 25);
        c.add(panText);
        
        // Aadhar
        JLabel aadhar=new JLabel("Aadhar number:");
        aadhar.setFont(new Font("Roboto", Font.BOLD, 18));
        aadhar.setBounds(70, 360, 200, 40);
        c.add(aadhar);
        
        aadharText=new JTextField();
        aadharText.setFont(new Font("Roboto", Font.BOLD, 18));
        aadharText.setBounds(260,370, 450, 25);
        c.add(aadharText);
        
        // address
        JLabel existAcc=new JLabel("Existing Account:");
        existAcc.setFont(new Font("Roboto", Font.BOLD, 18));
        existAcc.setBounds(70, 410, 200, 40);
        c.add(existAcc);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(260, 420, 150, 25);
        yes.setFont(new Font("Roboto", Font.BOLD, 18));
        yes.setBackground(Color.white);
        c.add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(420, 420, 150, 25);
        no.setFont(new Font("Roboto", Font.BOLD, 18));
        no.setBackground(Color.white);
        c.add(no);
        
        ButtonGroup existAccGrp=new ButtonGroup();
        existAccGrp.add(yes);
        existAccGrp.add(no);
        
        //nextbutton
        JButton next =new JButton("NEXT");
        next.setBackground(Color.blue);
        next.setForeground(Color.white);
        next.setFont(new Font("Roboto", Font.BOLD, 20));
        next.setBounds(550,460, 160, 30);
        next.addActionListener(this);
        c.add(next);
        
        
        // frame 
        c.setBackground(Color.white);
        setTitle("NEW ACCOUNT APPLICATION FORM");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
       //String formno=""+random; //long
       String religion=(String)religionBox.getSelectedItem();
       String income=(String)incomeBox.getSelectedItem();
       String education=(String)educationBox.getSelectedItem();
       String occupation = (String) occupationBox.getSelectedItem();
       String pan=panText.getText();
       String aadhar=aadharText.getText();
       
       String existAcc=null;
       if(yes.isSelected()){
           existAcc="Yes";
       }
       else if(no.isSelected()){
           existAcc="No";
       }
       

       // SQL
       try{
            Conn con=new Conn();
            String sql="insert into signup2 values ('"+formno+"','"+religion+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+existAcc+"')";
            
            con.smt.executeUpdate(sql);
            JOptionPane.showMessageDialog(c, "records saved");
            
            //sign up 3
            setVisible(false);
            new SignUpThree(formno).setVisible(true);
             
       }catch(Exception e){
           System.out.println(e);
       }
        
    }
    
    public static void main(String args[]){
        new SignUpTwo("");
    }
}
