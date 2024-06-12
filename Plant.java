/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PalmSpecimenProject;

import java.util.Date;

/**
 *
 * @author user
 */
public class Plant {

    private int ID;
    private String commonName;
    private String genus;
    private String species;
    private String stem;
    private String leaf;
    private String location;
    private String imageName;
    private String imagePath;
    private byte[] imageFile;
    private Date date;
    private Date time;

    // Constructor 
//    public Plant(int ID, String commonName, String genus, String species, String stem, String leaf, String location, String imageName, String imagePath, byte[] imageFile) {
//        super();
//        this.ID = ID;
//        this.commonName = commonName;
//        this.genus = genus;
//        this.species = species;
//        this.stem = stem;
//        this.leaf = leaf;
//        this.location = location;
//        this.imageName = imageName;
//        this.imagePath = imagePath;
//        this.imageFile = imageFile;
//    }
    // Getters And Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public byte[] getImageFile() {
        return imageFile;
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
    }

    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Date getTime() {
        return time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }

}
