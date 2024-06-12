/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PalmSpecimenProject;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public interface PalmSpecimenProjectDataAccessObject {
    public ArrayList<Plant> plantsList(String searchTerm);
    public void populateJTableFromMysqlDatabase(DefaultTableModel model, JTable jTable1, String searchTermPop);   
}
