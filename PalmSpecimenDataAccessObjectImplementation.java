/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PalmSpecimenProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class PalmSpecimenDataAccessObjectImplementation implements PalmSpecimenProjectDataAccessObject {

    DatabaseConnection connx = new DatabaseConnection();

    @Override
    // store Database results in ArrayList Method
    public ArrayList<Plant> plantsList(String searchTerm) {

        ArrayList<Plant> plantLists = new ArrayList<Plant>();

        String queryString = "";
        //splits the string based on string
        String[] searchWords = searchTerm.split("\\sOR\\s");
        int i = 0;
        for (String word : searchWords) {
            if (i == 0) {
                queryString += "SELECT `ID`, `CommonName`, `Genus`, `Species`, `Stem`, `Leaf`, `Location`, `ImageName`, `ImagePath`, `ImageFile`, `Date`, `Time` FROM `palmspecimenprojecttable` WHERE CONCAT(`ID`, `CommonName`, `Genus`, `Species`, `Stem`, `Leaf`, `Location`, `ImageName`, `ImagePath`, `ImageFile`, `Date`, `Time`) LIKE '%" + word + "%'";
            } else {
                queryString += "OR CONCAT(`ID`, `CommonName`, `Genus`, `Species`, `Stem`, `Leaf`, `Location`, `ImageName`, `ImagePath`, `ImageFile`, `Date`, `Time`) LIKE '%" + word + "%'";
            }
            i++;
        }

        String selectAllSQLQuery = queryString;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connx.databaseConnection().createStatement();
            rs = stmt.executeQuery(selectAllSQLQuery);

            // loop through the results
            while (rs.next()) {
                Plant plant = new Plant();
                // populate Plant Setters
                plant.setID(rs.getInt("ID"));
                plant.setCommonName(rs.getString("CommonName"));
                plant.setGenus(rs.getString("Genus"));
                plant.setSpecies(rs.getString("Species"));
                plant.setStem(rs.getString("Stem"));
                plant.setLeaf(rs.getString("Leaf"));
                plant.setLocation(rs.getString("Location"));
                plant.setImageName(rs.getString("ImageName"));
                plant.setImagePath(rs.getString("ImagePath"));
                plant.setImageFile(rs.getBytes("ImageFile"));
                plant.setDate(rs.getDate("Date"));
                plant.setTime(rs.getTime("Time"));

                plantLists.add(plant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PalmSpecimenProject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            // Close variables to prevent java.sql.SQLException: Java heap space error 
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(PalmSpecimenProject.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return plantLists;
    }

    @Override
    // Populate Jtable with data from database 
    public void populateJTableFromMysqlDatabase(DefaultTableModel model, JTable jTable1, String searchTermPop) {
        ArrayList<Plant> dataArray = plantsList(searchTermPop);
        model = (DefaultTableModel) jTable1.getModel();
        // Clear JTableRows
        model.setRowCount(0);
        Object[] rows = new Object[11];

        //Loop through the arraylist to populate JTable
        for (int i = 0; i < dataArray.size(); i++) {
            rows[0] = dataArray.get(i).getID();
            rows[1] = dataArray.get(i).getCommonName();
            rows[2] = dataArray.get(i).getGenus();
            rows[3] = dataArray.get(i).getSpecies();
            rows[4] = dataArray.get(i).getStem();
            rows[5] = dataArray.get(i).getLeaf();
            rows[6] = dataArray.get(i).getLocation();
            rows[7] = dataArray.get(i).getImageName();
            rows[8] = dataArray.get(i).getImagePath();
            rows[9] = dataArray.get(i).getDate();
            rows[10] = dataArray.get(i).getTime();

            model.addRow(rows);
        }

    }

}
