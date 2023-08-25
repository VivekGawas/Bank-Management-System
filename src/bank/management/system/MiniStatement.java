
package bank.management.system;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class MiniStatement extends JFrame{
    
    Container c;
    String pin;
    MiniStatement(String pin){
        
        this.pin=pin;
        c=getContentPane();
        c.setLayout(null);
        
        JLabel mini=new JLabel();
        mini.setBounds(20, 150, 400, 200);
        c.add(mini);
        
        JLabel l1=new JLabel("Bank of Maharashtra");
        l1.setFont(new Font("Roboto", Font.BOLD, 14));
        l1.setBounds(120, 20, 150, 24);
        c.add(l1);
        
        JLabel balance=new JLabel();
        balance.setBounds(20, 400, 300, 20);
        c.add(balance);
        
        JLabel card=new JLabel();
        card.setBounds(20, 80, 300, 20);
        c.add(card);
        
        
        Conn c1=new Conn();
        try{
            String sql="select * from login where pin='"+pin+"'";
            ResultSet rs=c1.smt.executeQuery(sql);
            while(rs.next()){
                card.setText("Card number: "+rs.getString("cardnum").substring(0,4)+"XXXXXXXX" + rs.getString("cardnum").substring(12));
            }            

        }
        catch (Exception e){
            System.out.println(e);
        }
        
        try{
            String sql="select * from bank where pin= '"+pin+"'";
            ResultSet rs=c1.smt.executeQuery(sql);
            int bal=0;
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" +rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }    
            }            
            balance.setText("Yur current balance is Rs "+bal);
        }
        catch (Exception e){
            System.out.println(e);
        }
        

        
        
        c.setBackground(Color.white);
        setTitle("MINI STATEMENT");
        setSize(400,600);
        setLocation(20,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
    
}
