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

public class ReadQuery {

    private Connection conn;
    private ResultSet results;

    public ReadQuery() {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {

        try {
            String query = "SELECT * FROM Customers ORDER BY custID";

            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getHTMLTable() {

        String table = "";

        table += "<table border=1>";

        table += "<tr>";
        table += "<th>ID</th><th>First Name</th><th>Last Name</th><th>Addr1</th><th>Addr2</th><th>City</th><th>State</th><th>Zip</th><th>Email</th><th>Action</th>";
        table += "</tr>";
        try {

            while (this.results.next()) {
                Customers c = new Customers();

                c.setCustID(this.results.getInt("custID"));
                c.setFirstName(this.results.getString("firstName"));
                c.setLastName(this.results.getString("lastName"));
                c.setAddr1(this.results.getString("addr1"));
                c.setAddr2(this.results.getString("addr2"));
                c.setCity(this.results.getString("city"));
                c.setcState(this.results.getString("cState"));
                c.setZip(this.results.getString("zip"));
                c.setEmail(this.results.getString("email"));

                table += "<tr>";

                table += "<td>";
                table += c.getCustID();
                table += "</td>";

                table += "<td>";
                table += c.getFirstName();
                table += "</td>";

                table += "<td>";
                table += c.getLastName();
                table += "</td>";

                table += "<td>";
                table += c.getAddr1();
                table += "</td>";

                table += "<td>";
                table += c.getAddr2();
                table += "</td>";

                table += "<td>";
                table += c.getCity();
                table += "</td>";

                table += "<td>";
                table += c.getcState();
                table += "</td>";

                table += "<td>";
                table += c.getZip();
                table += "</td>";

                table += "<td>";
                table += c.getEmail();
                table += "</td>";

                table += "<td>";
                table += "<a href=update?custID="+c.getCustID()+">Update</a>" + "<a href=delete?custID=" + c.getCustID() + "> Delete </a>";
                table += "</td>";

                table += "</tr>";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</table>";
        return table;
    }
}
