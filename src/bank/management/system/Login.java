package bank.management.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton login, signup, clear;
    JTextField cardText;
    JPasswordField pinText;
    Container c;
    Login(){
            c=getContentPane();
            c.setLayout(null);
            
            // logo image 
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
            Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel label=new JLabel(i3);
            label.setBounds(150, 10, 100, 100);
            c.add(label);
            
            // Welcome to ATM
            JLabel text=new JLabel("Welcome to ATM");
            text.setFont(new Font("Roboto", Font.BOLD, 38));
            text.setBounds(270, 45, 400,40);
            c.add(text);
            
            // Card number
            JLabel cardno=new JLabel("Card no:");
            cardno.setFont(new Font("Roboto", Font.BOLD, 26));
            cardno.setBounds(100, 132, 130,40);
            c.add(cardno);
            
            cardText=new JTextField();
            cardText.setBounds(270, 143, 280, 30);
            cardText.setFont(new Font("Roboto", Font.BOLD, 17));
            c.add(cardText);
            
            
            //Pin number
            JLabel pin=new JLabel("Pin:");
            pin.setFont(new Font("Roboto", Font.BOLD, 26));
            pin.setBounds(100, 200, 130,40);
            c.add(pin);
            
            pinText=new JPasswordField();
            pinText.setBounds(270, 205, 280, 30);
            pinText.setFont(new Font("Roboto", Font.BOLD, 17));
            c.add(pinText);
            
            // buttons-----------------------
            
            // sign in
            login =new JButton("SIGN IN");
            login.setFont(new Font("Roboto", Font.BOLD, 15));
            login.setBounds(270, 280, 130, 30);
            login.setBackground(Color.blue);
            login.setForeground(Color.white);
            login.addActionListener(this);
            c.add(login);
            
            // Clear
            clear =new JButton("CLEAR");
            clear.setFont(new Font("Roboto", Font.BOLD, 15));
            clear.setBounds(420, 280, 130, 30);
            clear.setBackground(Color.blue);
            clear.setForeground(Color.white);
            clear.addActionListener(this);
            c.add(login);
            c.add(clear);
            
            // sign up
            signup =new JButton("SIGN UP");
            signup.setFont(new Font("Roboto", Font.BOLD, 15));
            signup.setBounds(270, 330, 280, 30);
            signup.setBackground(Color.blue);
            signup.setForeground(Color.white);
            signup.addActionListener(this);
            c.add(login);
            c.add(signup);
            
            // frame 
            c.setBackground(Color.white);
            setTitle("AUTOMATED TELLER MACHINE");
            setSize(800,480);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardText.setText("");
            pinText.setText("");
        }
        else if(ae.getSource() == login){
            
            try{
                Conn conn=new Conn();
                String cardNum=cardText.getText();
                String pinNum=pinText.getText();
                
                String sql="select * from login where cardnum = '"+cardNum+"' and pin = '"+pinNum+"'";
                ResultSet rs=conn.smt.executeQuery(sql);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(c, "Incorrect card number or pin");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
