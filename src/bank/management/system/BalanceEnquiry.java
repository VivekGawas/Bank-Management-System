
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    Container c;
    JButton back;
    String pin;
    public BalanceEnquiry(String pin){
        this.pin=pin;
        c=getContentPane();
        c.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, WIDTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        c.add(image);
        
        
        back =new JButton("Back");
        back.setFont(new Font("Roboto", Font.BOLD, 14));
        back.setBounds(350, 405, 150, 24);
        back.addActionListener(this);
        image.add(back);
        
        
        Conn c1=new Conn();
        int bal =0;
        try{
            String sql="select * from bank where pin='"+pin+"'";
            ResultSet rs=c1.smt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }            

        }
        catch (Exception e){
            System.out.println(e);
        }
        
        JLabel balance = new JLabel("Your current balance is Rs " + bal);
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("System", Font.BOLD, 16));
        balance.setBounds(210,240,400,35);
        image.add(balance);
        
        c.setBackground(Color.white);
        setTitle("BALANCE ENQUIRY");
        setSize(900,700);
        setLocation(200,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
    
}
