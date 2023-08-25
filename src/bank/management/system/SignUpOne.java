package bank.management.system;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;

public class SignUpOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameText, fnameText, emailText, addressText, cityText, stateText, pincodeText;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
            
    Container c;
    SignUpOne(){
        c=getContentPane();
        c.setLayout(null);
        
        Random ran=new Random();
        random=(Math.abs((ran.nextLong() % 9000L ) + 1000L));
        
        JLabel formno=new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Roboto", Font.BOLD, 30));
        formno.setBounds(180, 10, 600, 40);
        c.add(formno);
        
        // personal details
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Roboto", Font.BOLD, 20));
        personalDetails.setBounds(270, 50, 600, 40);
        c.add(personalDetails);
        
        // name
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Roboto", Font.BOLD, 18));
        name.setBounds(70, 90, 80, 40);
        c.add(name);
        
        nameText=new JTextField();
        nameText.setFont(new Font("Roboto", Font.BOLD, 18));
        nameText.setBounds(240,100, 450, 25);
        c.add(nameText);
        
        // father name
        JLabel fname=new JLabel("Father's name:");
        fname.setFont(new Font("Roboto", Font.BOLD, 18));
        fname.setBounds(70, 140, 200, 40);
        c.add(fname);
        
        fnameText=new JTextField();
        fnameText.setFont(new Font("Roboto", Font.BOLD, 18));
        fnameText.setBounds(240,150, 450, 25);
        c.add(fnameText);
        
        // dob
        JLabel dob=new JLabel("Date of birth:");
        dob.setFont(new Font("Roboto", Font.BOLD, 18));
        dob.setBounds(70, 190, 200, 40);
        c.add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(240, 200, 450, 25);
        c.add(dateChooser);
        
        // gender
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Roboto", Font.BOLD, 18));
        gender.setBounds(70, 240, 200, 40);
        c.add(gender);
        
        //male
        male=new JRadioButton("Male");
        male.setBounds(240, 250, 150, 25);
        male.setBackground(Color.white);
        c.add(male);
        
        //female
        female=new JRadioButton("Female");
        female.setBounds(400, 250, 150, 25);
        female.setBackground(Color.white);
        c.add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        // email
        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Roboto", Font.BOLD, 18));
        email.setBounds(70, 290, 200, 40);
        c.add(email);
        
        emailText=new JTextField();
        emailText.setFont(new Font("Roboto", Font.BOLD, 18));
        emailText.setBounds(240,300, 450, 25);
        c.add(emailText);
        
        // marital
        JLabel marital=new JLabel("Marital status:");
        marital.setFont(new Font("Roboto", Font.BOLD, 18));
        marital.setBounds(70, 340, 200, 40);
        c.add(marital);
        
        //married
        married=new JRadioButton("Married");
        married.setBounds(240, 350, 150, 25);
        married.setBackground(Color.white);
        c.add(married);
        
        //unmarried
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400, 350, 150, 25);
        unmarried.setBackground(Color.white);
        c.add(unmarried);
        
        //others
        other=new JRadioButton("Other");
        other.setBounds(550, 350, 150, 25);
        other.setBackground(Color.white);
        c.add(other);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        // address
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Roboto", Font.BOLD, 18));
        address.setBounds(70, 390, 200, 40);
        c.add(address);
        
        addressText=new JTextField();
        addressText.setFont(new Font("Roboto", Font.BOLD, 18));
        addressText.setBounds(240,400, 450, 25);
        c.add(addressText);
        
        // city
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Roboto", Font.BOLD, 18));
        city.setBounds(70, 440, 200, 40);
        c.add(city);
        
        cityText=new JTextField();
        cityText.setFont(new Font("Roboto", Font.BOLD, 18));
        cityText.setBounds(240,450, 450, 25);
        c.add(cityText);
        
        // state
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Roboto", Font.BOLD, 18));
        state.setBounds(70, 490, 200, 40);
        c.add(state);
        
        stateText=new JTextField();
        stateText.setFont(new Font("Roboto", Font.BOLD, 18));
        stateText.setBounds(240,500, 450, 25);
        c.add(stateText);
        
        //pincode
        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Roboto", Font.BOLD, 18));
        pincode.setBounds(70, 540, 200, 40);
        c.add(pincode);
        
        pincodeText=new JTextField();
        pincodeText.setFont(new Font("Roboto", Font.BOLD, 18));
        pincodeText.setBounds(240,550, 450, 25);
        c.add(pincodeText);
        
        //nextbutton
        JButton next =new JButton("NEXT");
        next.setBackground(Color.blue);
        next.setForeground(Color.white);
        next.setFont(new Font("Roboto", Font.BOLD, 20));
        next.setBounds(530,590, 160, 30);
        next.addActionListener(this);
        c.add(next);
        
        
        // frame 
        c.setBackground(Color.white);
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800,680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       String formno=""+random; //long
       String name=nameText.getText();
       String fname=fnameText.getText();
       String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
       String gender= null;
       if(male.isSelected()){
           gender="Male";
       }
       else if(female.isSelected()){
           gender="Female";
       }
       
       String email=emailText.getText();
       String marital=null;
       if(married.isSelected()){
           marital="Married";
       }
       else if(unmarried.isSelected()){
           marital="Unmarried";
       }
       else if(other.isSelected()){
           marital="Other";
       }
       
       String address=addressText.getText();  
       String city=cityText.getText();
       String state=stateText.getText();
       String pincode=pincodeText.getText();
       
       try{
           
           if(name.equals("")){
               JOptionPane.showMessageDialog(null, "Name is required");
           }
           else if(fname.equals("")){
               JOptionPane.showMessageDialog(null, "Father's name is required");
           }
           else{
               Conn con=new Conn();
               String sql="insert into signup values(?,?,?,?,?,?,?,?,?,?,?)";
               PreparedStatement pst=con.conn.prepareStatement(sql);
               pst.setString(1,formno);
               pst.setString(2,name);
               pst.setString(3, fname);
               pst.setString(4, dob);
               pst.setString(5, gender);
               pst.setString(6, email);
               pst.setString(7, marital);
               pst.setString(8, address);
               pst.setString(9, city);
               pst.setString(10, state);
               pst.setString(11, pincode);
               
               pst.executeUpdate();
               JOptionPane.showMessageDialog(c, "records saved");
               
               setVisible(false);
               new SignUpTwo(formno).setVisible(true);
           }
       }catch(Exception e){
           System.out.println(e);
       }
       
    }
    
    
    public static void main(String args[]){
        new SignUpOne();
    }
}
