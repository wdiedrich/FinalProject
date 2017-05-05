/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

/**
 *
 * @author Austin
 */
public class ReadRecord {
   
private Connection conn;
    private ResultSet results;
    
    private Customers c = new Customers();
    private int custID;
    
    public ReadRecord(int custID) {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        
        this.custID = custID;
        
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url,username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {

        try {
            //set up a string to hold our query
            String query = "SELECT * FROM customers WHERE custID = ?";
            //create a preprepared statement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            //fill in the preparedstatement
            ps.setInt(1,custID);
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            c.setCustID(this.results.getInt("custID"));
            c.setFirstName(this.results.getString("firstName"));
            c.setLastName(this.results.getString("lastName"));
            c.setAddr1(this.results.getString("addr1"));
            c.setAddr2(this.results.getString("addr2"));
            c.setCity(this.results.getString("city"));
            c.setcState(this.results.getString("cState"));
            c.setZip(this.results.getString("zip"));
            c.setEmail(this.results.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public Customers getCustomer() {
        
        return this.c;
    } 
}
