/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.model;

/**
 *
 * @author jose
 */
public class Produit {
    private int idProduit;
    private String nom;
    private double prixVente;
    private int stockActuel;
    private int seuilAlerte;
    private int idCategorie;

    public Produit() {
    }

    public Produit(int idProduit, String nom, double prixVente,
                   int stockActuel, int seuilAlerte, int idCategorie) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prixVente = prixVente;
        this.stockActuel = stockActuel;
        this.seuilAlerte = seuilAlerte;
        this.idCategorie = idCategorie;
    }
    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public int getStockActuel() {
        return stockActuel;
    }
    public void setStockActuel(int stockActuel) {
        this.stockActuel = stockActuel;
    }

    public int getSeuilAlerte() {
        return seuilAlerte;
    }

    public void setSeuilAlerte(int seuilAlerte) {
        this.seuilAlerte = seuilAlerte;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    
}
