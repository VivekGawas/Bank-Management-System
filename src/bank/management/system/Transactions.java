
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    String pinNum;
    JButton deposit, withdrawal, fastcash, ministatement, pinChange, balance, exit;
    Container c;
    Transactions(String pinNum){
        
        this.pinNum=pinNum;
        c=getContentPane();
        c.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0, 900, 700);
        c.add(image);
        
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(225, 230, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Roboto", Font.BOLD, 15));
        image.add(text);

        // buttons
        deposit=new JButton("Deposit");
        deposit.setFont(new Font("Roboto", Font.BOLD, 12));
        deposit.setBounds(170, 318, 150, 24);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal=new JButton("Cash Withdrawal");
        withdrawal.setFont(new Font("Roboto", Font.BOLD, 12));
        withdrawal.setBounds(350, 318, 150, 24);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash=new JButton("Fast cash");
        fastcash.setFont(new Font("Roboto", Font.BOLD, 12));
        fastcash.setBounds(170, 347, 150, 24);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini statement");
        ministatement.setFont(new Font("Roboto", Font.BOLD, 14));
        ministatement.setBounds(350, 347, 150, 24);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinChange=new JButton("Pin change");
        pinChange.setFont(new Font("Roboto", Font.BOLD, 12));
        pinChange.setBounds(170, 376, 150, 24);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balance=new JButton("Check balance");
        balance.setFont(new Font("Roboto", Font.BOLD, 14));
        balance.setBounds(350, 376, 150, 24);
        balance.addActionListener(this);
        image.add(balance);
        
        exit=new JButton("Exit");
        exit.setFont(new Font("Roboto", Font.BOLD, 14));
        exit.setBounds(350, 405, 150, 24);
        exit.addActionListener(this);
        image.add(exit);
        
        // Frame
        c.setBackground(Color.white);
        setTitle("ACCOUNT DETAILS");
        setSize(900,700);
        setLocation(200,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNum).setVisible(true);
        }
        else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawl(pinNum).setVisible(true);
        }
        else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNum).setVisible(true);
        }
        else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNum).setVisible(true);
        }
        else if(ae.getSource() == balance){
            setVisible(false);
            new BalanceEnquiry(pinNum).setVisible(true);
        }
        else if(ae.getSource() == ministatement){
            new MiniStatement(pinNum).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
}
