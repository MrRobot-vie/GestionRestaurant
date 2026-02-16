/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.model;

/**
 *
 * @author jose
 */
public class Categorie {

    private int idCategorie;
    private String libelle;

    public Categorie() { 
    }

    public Categorie(int idCategorie, String libelle) {
        this.idCategorie = idCategorie;
        this.libelle = libelle;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    

}
