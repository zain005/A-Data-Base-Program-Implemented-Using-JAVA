/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PalmSpecimenProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DatabaseConnection {

    String dbUsername = "root";
    String dbPassword = "";
    String dbServerUrl = "jdbc:mysql://localhost:3306/palmspecimenproject";
    String dbClassPathUrl = "com.mysql.cj.jdbc.Driver";

    String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneshift=true&useLegacyDatetimecode=false&serverTimezone=UTC";

    public Connection databaseConnection() {
        Connection conn;
        try {
            //Load Driver
            Class.forName(dbClassPathUrl);
            //JOptionPane.showMessageDialog(null, "Driver Loaded");
            //Connect to database

            conn = DriverManager.getConnection(dbServerUrl + timeZone, dbUsername, dbPassword);
            //JOptionPane.showMessageDialog(null, "Connected");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(PalmSpecimenProject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PalmSpecimenProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Failed to connect to MySQL database,\nYou may need to open xampp_control");
        System.exit(0);
        return null;
    }
}
