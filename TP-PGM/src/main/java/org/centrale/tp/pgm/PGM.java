/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.tp.pgm;

/**
 * 
 * @author loicpatigny
 */
public class PGM {
    String P2;
    String commentaire;
    int largeur;
    int hauteur;
    int gris = 255;

    // Constructor
    public PGM(String P2, String commentaire, int largeur, int hauteur) {
        this.P2 = P2;
        this.commentaire = commentaire;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    
    //Getters and Setters

    public String getP2() {
        return P2;
    }

    public void setP2(String P2) {
        this.P2 = P2;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getGris() {
        return gris;
    }

    public void setGris(int gris) {
        this.gris = gris;
    }
    
    
    // Methodes
    
    /**
     * 
     */
    public void readPGM(){
        
    }
    
    public void histogrammePGM(){
        
    }
    
    
    public void seuillage(){
        
    }
    
    public void difference(){
        
    }
    
    public void agrandissement(){
        
    }
    
    public void reduction(){
        
    } 
}
