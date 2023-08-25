
package bank.management.system;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpThree extends JFrame implements ActionListener {
    
    String formno;
    JButton submit, cancel;
    JRadioButton savings, currAcc, reccAcc, fdAcc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    Container c;
    SignUpThree(String formno){
        
        this.formno=formno;
        c=getContentPane();
        c.setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Roboto", Font.BOLD, 25));
        l1.setBounds(260, 30, 400, 40);
        c.add(l1);
        
        //account type
        JLabel accType=new JLabel("Account Type:");
        accType.setFont(new Font("Roboto", Font.BOLD, 22));
        accType.setBounds(100, 100, 400, 40);
        c.add(accType);
        
        savings =new JRadioButton("Savings Account");
        savings.setFont(new Font("Roboto", Font.BOLD, 16));
        savings.setBackground(Color.white);
        savings.setBounds(270, 100, 200, 40);
        c.add(savings);
        
        fdAcc =new JRadioButton("Fixed Deposit Account");
        fdAcc.setFont(new Font("Roboto", Font.BOLD, 16));
        fdAcc.setBackground(Color.white);
        fdAcc.setBounds(470, 100, 200, 40);
        c.add(fdAcc);
        
        currAcc =new JRadioButton("Current Account");
        currAcc.setFont(new Font("Roboto", Font.BOLD, 16));
        currAcc.setBackground(Color.white);
        currAcc.setBounds(270, 150, 200, 40);
        c.add(currAcc);
        
        reccAcc =new JRadioButton("Recurring Deposit Account");
        reccAcc.setFont(new Font("Roboto", Font.BOLD, 16));
        reccAcc.setBackground(Color.white);
        reccAcc.setBounds(470, 150, 250, 40);
        c.add(reccAcc);
        
        
        ButtonGroup accTypegrp=new ButtonGroup();
        accTypegrp.add(savings);
        accTypegrp.add(currAcc);
        accTypegrp.add(fdAcc);
        accTypegrp.add(reccAcc);
        
        // card no.
        JLabel cardno=new JLabel("Card number:");
        cardno.setFont(new Font("Roboto", Font.BOLD, 22));
        cardno.setBounds(100, 220, 400, 40);
        c.add(cardno);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-7391");
        number.setFont(new Font("Roboto", Font.BOLD, 18));
        number.setBounds(320, 220, 400, 40);
        c.add(number);
        
        JLabel cardInfo=new JLabel("(your 16 digit card number)");
        cardInfo.setFont(new Font("Roboto", Font.BOLD, 14));
        cardInfo.setBounds(100, 250, 400, 40);
        c.add(cardInfo);
        
        // pin no.
        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Roboto", Font.BOLD, 22));
        pin.setBounds(100, 300, 400, 40);
        c.add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Roboto", Font.BOLD, 18));
        pnumber.setBounds(320, 300, 400, 40);
        c.add(pnumber);
        
        JLabel pinInfo=new JLabel("(your 4 digit pin)");
        pinInfo.setFont(new Font("Roboto", Font.BOLD, 14));
        pinInfo.setBounds(100, 330, 400, 40);
        c.add(pinInfo);
        
        //services required
        JLabel services=new JLabel("Services required:");
        services.setFont(new Font("Roboto", Font.BOLD, 18));
        services.setBounds(100, 380, 400, 40);
        c.add(services);
        
        c1=new JCheckBox("ATM card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Roboto", Font.BOLD, 18));
        c1.setBounds(300, 380, 200, 40);
        c.add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Roboto", Font.BOLD, 18));
        c2.setBounds(500, 380, 250, 40);
        c.add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Roboto", Font.BOLD, 18));
        c3.setBounds(300, 420, 200, 40);
        c.add(c3);
        
        c4=new JCheckBox("Email & SMS alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Roboto", Font.BOLD, 18));
        c4.setBounds(500, 420, 250, 40);
        c.add(c4);
        
        c5=new JCheckBox("Cheque book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Roboto", Font.BOLD, 18));
        c5.setBounds(300, 460, 200, 40);
        c.add(c5);
        
        c6=new JCheckBox("E-statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Roboto", Font.BOLD, 18));
        c6.setBounds(500, 460, 200, 40);
        c.add(c6);
        
        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Roboto", Font.BOLD, 13));
        c7.setBounds(100, 520, 600, 40);
        c.add(c7);
        
        // submit button
        submit =new JButton("Submit");
        submit.setFont(new Font("Roboto", Font.BOLD, 16));
        submit.setBounds(200, 575, 150, 30);
        submit.setForeground(Color.white);
        submit.setBackground(Color.blue);
        submit.addActionListener(this);
        c.add(submit);
        
        // cancel button
        cancel =new JButton("Cancel");
        cancel.setFont(new Font("Roboto", Font.BOLD, 16));
        cancel.setBounds(430, 575, 150, 30);
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        c.add(cancel);
        
        // frame
        c.setBackground(Color.white);
        setTitle("ACCOUNT DETAILS");
        setSize(800,690);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accType=null;
            if(savings.isSelected()){
                accType="Savings Account";
            }
            else if(currAcc.isSelected()){
                accType="Current Account";
            }
            else if(fdAcc.isSelected()){
                accType="Fixed Deposit Account";
            }
            else if(reccAcc.isSelected()){
                accType="Recurring Deposit Account";
            }   
            
            Random random=new Random();
            String cardNum="" + Math.abs((random.nextLong() % 90000000L + 8090267800000000L));
            
            String pin="" + Math.abs(random.nextLong() % 9000L + 1000L);
            
            String services="";
            if(c1.isShowing()){
                services=services + "ATM Card";
            }
            else if(c2.isShowing()){
                services=services + "Internet Banking";
            }
            else if(c3.isShowing()){
                services=services + "Mobile banking";
            }
            else if(c4.isShowing()){
                services=services + "Email & SMS alerts";
            }
            else if(c5.isShowing()){
                services=services + "Cheque book";
            }
            else if(c6.isShowing()){
                services=services + "E-statement";
            }
            
            if(c7.isSelected()){
                try{
                    if(accType.equals("")){
                        JOptionPane.showMessageDialog(c, "select account type");
                    }
                    else {
                        Conn con=new Conn();
                        String sql1="insert into signup3 values ('"+formno+"','"+accType+"', '"+cardNum+"', '"+pin+"', '"+services+"')";
                        String sql2="insert into login values ('"+formno+"', '"+cardNum+"', '"+pin+"')";
                        
                        con.smt.executeUpdate(sql1);
                        con.smt.executeUpdate(sql2);
                        
                        JOptionPane.showMessageDialog(c, "Card Num: "+cardNum+"\nPin: "+pin);
                        
                        setVisible(false);
                        new Deposit(pin).setVisible(true);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else {
                JOptionPane.showMessageDialog(c, "select declaration.");
            }
            
        }
        
        else if(ae.getSource() == cancel){
            try{
                
                int ans=JOptionPane.showConfirmDialog(c, "Are you sure?");
                if(ans == 0){
                    Conn con=new Conn();
                    String sql3="delete from signup where formno = '"+formno+"'";
                    String sql4="delete from signup2 where formno = '"+formno+"'";
                    
                    con.smt.executeUpdate(sql3);
                    con.smt.executeUpdate(sql4);
                    
                    setVisible(false);
                    new Login().setVisible(true);
                }
                else{
                    
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String args[]){
        new SignUpThree("");
    }
}
