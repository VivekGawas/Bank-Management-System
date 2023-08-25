
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    
    Container c;
    String oldpin;
    JLabel l1, pinText, rePin;
    JPasswordField pin , r_pin ;
    JButton change, back;
    
    PinChange(String oldpin){
        c=getContentPane();
        c.setLayout(null);
        
        this.oldpin = oldpin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 700);
        c.add(l3);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(260,220,400,35);
        l3.add(l1);
        
        pinText=new JLabel("NEW PIN : ");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(170,255,150,25);
        l3.add(pinText);
        
        pin=new JPasswordField();
        pin.setFont(new Font("System", Font.BOLD, 16));
        pin.setBounds(350,255,150,25);
        l3.add(pin);
        
        rePin=new JLabel("RE-ENTER PIN : ");
        rePin.setForeground(Color.WHITE);
        rePin.setFont(new Font("System", Font.BOLD, 16));
        rePin.setBounds(170,285,150,25);
        l3.add(rePin);
        
        r_pin=new JPasswordField();
        r_pin.setFont(new Font("System", Font.BOLD, 16));
        r_pin.setBounds(350,285,150,25);
        l3.add(r_pin);
        
        change=new JButton("Change");
        change.setFont(new Font("Roboto", Font.BOLD, 14));
        change.setBounds(350, 376, 150, 24);
        change.addActionListener(this);
        l3.add(change);
        
        back=new JButton("Back");
        back.setFont(new Font("Roboto", Font.BOLD, 14));
        back.setBounds(350, 405, 150, 24);
        back.addActionListener(this);
        l3.add(back);
        
        
        
        
        c.setBackground(Color.white);
        setTitle("PIN CHANGE");
        setSize(900,700);
        setLocation(200,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin=pin.getText();
                String rpin=r_pin.getText();
                
                if(!(npin.equals(rpin))){
                    JOptionPane.showMessageDialog(c, "Entered PIN didn't match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(c, "Please enter NEW PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(c, "Please re-enter NEW PIN");
                    return;
                }
                
                Conn c1=new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+oldpin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+oldpin+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+oldpin+"' ";
                
                c1.smt.executeUpdate(q1);
                c1.smt.executeUpdate(q2);
                c1.smt.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(c, "PIN CHNAGED SUCCESSFULLY");
                setVisible(false);
                new Transactions(npin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(oldpin).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("");
    }
}
