/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.tp.pgm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author loicpatigny
 */
public class PGM {
    String type;
    String commentaire;
    int largeur;
    int hauteur;
    int gris = 255;
    List<List<Integer>> contenu;
    

    // Constructeurs

    public PGM() {
    }
    
    public PGM(String type, String commentaire, int largeur, int hauteur) {
        this.type = type;
        this.commentaire = commentaire;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    

    public PGM(String type, String commentaire, int largeur, int hauteur, List<List<Integer>> contenu) {
        this.type = type;
        this.commentaire = commentaire;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.contenu = contenu;
    }
    
    
    
    //Getters and Setters

    public String getType() {
        return type;
    }

    public void setType(String P2) {
        this.type = type;
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
    
    public void remplirAvecBlanc() {
        List<List<Integer>> nouveauContenu = new ArrayList<>(this.hauteur);
        for (int k = 0; k < this.hauteur; k++) {
            List<Integer> line = new ArrayList<>(this.largeur);
            Collections.fill(line, this.gris);
            nouveauContenu.set(k, line);
        }
        this.contenu = nouveauContenu;
    }
    
    private List<Integer> calculeHistogramme() {
        List<Integer> histogramme = new ArrayList<>(this.gris + 1);
        Collections.fill(histogramme, 0);
        for (List<Integer> ligne : this.contenu) {
            for (int pixel : ligne) {
                histogramme.set(pixel, histogramme.get(pixel) + 1);
            }
        }
        return histogramme;
    }
    
    private PGM convertirHistogrammeEnImage(List<Integer> histogramme) {
        
        // Recupere la taille de l'image de l'histogramme
        int largeurImage = 2 * (this.gris + 1) + 1;
        int hauteurImage = Collections.max(histogramme) + 4;
        
        // Cree l'image vide (blanche) de l'histogramme
        PGM imageHistogramme = new PGM(this.type, "", largeurImage, hauteurImage);
        imageHistogramme.remplirAvecBlanc();
        
        // Remplit l'image de l'histogramme
        for (int g = 0; g < this.gris + 1; g++) {
            for (int l = 0; l < hauteurImage; l++) {
                if (l >= 1 && l <= 1 + histogramme.get(g)) { // Si dans la bin
                    imageHistogramme.contenu.get(l).set(1 + 2 * g, this.gris);
                } else if (l == hauteurImage - 2){ // Si en dessous la bin
                    imageHistogramme.contenu.get(l).set(1 + 2 * g, g);
                }
            }
        }
        
        return imageHistogramme;   
    } 
    
    public void creeHistogramme(String nomFichier) {
        List<Integer> histogramme = this.calculeHistogramme();
        PGM imageHistogramme = this.convertirHistogrammeEnImage(histogramme);
        imageHistogramme.enregistre(nomFichier);
    }
    
    /**
     * La fonction lire permet de lire un fichier .pgm comme un fichier texte et créer l'objet comme un PGM pour pouvoir effectuer des manipulations avec.
     * @param nomFichier le nom du fichier dans lequel se situe l'image PGM
     */
    //FIXME gerer la matrice de pixels
    public void lire(String nomFichier){
        try{
            //lecture du fichier
            FileInputStream file = new FileInputStream(nomFichier);
            Scanner scanner = new Scanner(file);
            
            //creation et remplissage d'un objet PGM
            this.setType(scanner.nextLine());
            this.setCommentaire(scanner.nextLine());
            String[] str = scanner.nextLine().split(" ");
            this.setLargeur(Integer.valueOf(str[0]));
            this.setHauteur(Integer.valueOf(str[1]));
            this.setGris(Integer.valueOf(scanner.nextLine()));
            
            //gestion de la matrice de pixels
            int j = 0;
            while (j < this.getHauteur()) {
                int i = 0;
                List ligne = new ArrayList<Integer>(this.getLargeur());
                while (i < this.getLargeur()){
                    for (String pixel : scanner.nextLine().split(" ")){
                        ligne.add(Integer.valueOf(pixel));
                        i+=1;
                    }
                }
                this.contenu.add(ligne);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PGM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void histogramme(){
        
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
