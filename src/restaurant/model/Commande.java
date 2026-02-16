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
public class Commande {
    private int idCommande;
    private Date dateCommande;
    private double total;
    private String etat;

    public Commande() {
    }

    public Commande(int idCommande, Date dateCommande, double total, String etat) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.total = total;
        this.etat = etat;
    }
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
}
