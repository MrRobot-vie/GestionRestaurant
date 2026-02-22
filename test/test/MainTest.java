/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import restaurant.dao.ProduitDAO;
import restaurant.model.Produit;

/**
 *
 * @author jose
 */ 
    public class MainTest {
    public static void main(String[] args) throws Exception {
        Produit p = new Produit();
        p.setNom("laitier");
        p.setPrixVente(250);
        p.setStockActuel(2);

        ProduitDAO dao = new ProduitDAO();
        dao.ajouterProduit(p);

        System.out.println("Produit ajouté avec succès !");
    }
}
    
