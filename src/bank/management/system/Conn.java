
package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection conn;
    Statement smt;
    PreparedStatement pst;
    public Conn(){
        
        try{
            String url = "jdbc:mysql://localhost:3306/bankmngsystem_2023";
            conn = DriverManager.getConnection(url,"root","Harsh@12345");
            smt = conn.createStatement();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
