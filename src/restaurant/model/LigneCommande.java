/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.model;

/**
 *
 * @author jose
 */
public class LigneCommande {
    private int idLigne;
<<<<<<< HEAD
    private int idCommande;
    private int idProduit;
    private int quantite;
    private double prixUnitaire;
    private double montantLigne;

    public LigneCommande() {
    }

    public LigneCommande(int idLigne, int idCommande, int idProduit,
                         int quantite, double prixUnitaire, double montantLigne) {
        this.idLigne = idLigne;
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montantLigne = montantLigne;
    }
        public int getIdLigne() {
        return idLigne;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getMontantLigne() {
        return montantLigne;
    }

    public void setMontantLigne(double montantLigne) {
        this.montantLigne = montantLigne;
    }

=======
    private int quantite;
    private double prixUnitaire;
    private double montantLigne;
    private int idCommande;
    private int idProduit;

    public int getIdLigne() { return idLigne; }
    public void setIdLigne(int idLigne) { this.idLigne = idLigne; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }

    public double getMontantLigne() { return montantLigne; }
    public void setMontantLigne(double montantLigne) { this.montantLigne = montantLigne; }

    public int getIdCommande() { return idCommande; }
    public void setIdCommande(int idCommande) { this.idCommande = idCommande; }

    public int getIdProduit() { return idProduit; }
    public void setIdProduit(int idProduit) { this.idProduit = idProduit; }
>>>>>>> dao
    
}
