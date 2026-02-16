/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.model;

import java.util.Date;

/**
 *
 * @author jose
 */
public class MouvementStock {
    private int idMouvement;
<<<<<<< HEAD
    private String typeMouvement; // ENTREE / SORTIE
    private int quantite;
    private String motif;
    private Date dateMouvement;
    private int idProduit;

    public MouvementStock() {
    }

    public MouvementStock(int idMouvement, String typeMouvement,
                          int quantite, String motif,
                          Date dateMouvement, int idProduit) {
        this.idMouvement = idMouvement;
        this.typeMouvement = typeMouvement;
        this.quantite = quantite;
        this.motif = motif;
        this.dateMouvement = dateMouvement;
        this.idProduit = idProduit;
    }

    public int getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(int idMouvement) {
        this.idMouvement = idMouvement;
    }
        public String getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(String typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(Date dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
=======
    private String typeMouvement;
    private int quantite;
    private Date dateMouvement;
    private String motif;
    private int idProduit;

    public int getIdMouvement() { return idMouvement; }
    public void setIdMouvement(int idMouvement) { this.idMouvement = idMouvement; }

    public String getTypeMouvement() { return typeMouvement; }
    public void setTypeMouvement(String typeMouvement) { this.typeMouvement = typeMouvement; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public Date getDateMouvement() { return dateMouvement; }
    public void setDateMouvement(Date dateMouvement) { this.dateMouvement = dateMouvement; }

    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }

    public int getIdProduit() { return idProduit; }
    public void setIdProduit(int idProduit) { this.idProduit = idProduit; }
>>>>>>> dao
    
}
