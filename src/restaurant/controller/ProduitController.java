/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.controller;
import restaurant.dao.ProduitDAO;
import restaurant.model.Produit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jose
 */
public class ProduitController {
   

    private ProduitDAO produitDAO = new ProduitDAO();

    public void ajouterProduit(String nom, double prix, int stock,
                               int seuil, int idCategorie) throws SQLException {

        if (stock < 0 || prix <= 0) {
            throw new IllegalArgumentException("Données produit invalides");
        }

        Produit p = new Produit();
        p.setNom(nom);
        p.setPrixVente(prix);
        p.setStockActuel(stock);
        p.setSeuilAlerte(seuil);
        p.setIdCategorie(idCategorie);

        produitDAO.ajouterProduit(p);
    }

    public List<Produit> listerProduits() throws SQLException {
        return produitDAO.listerProduits();
    }

    public void modifierProduit(Produit p) throws SQLException {
        produitDAO.modifierProduit(p);
    }

    public void supprimerProduit(int id) throws SQLException {
        produitDAO.supprimerProduit(id);
    }

    public List<Produit> produitsSousSeuil() throws SQLException {
        return produitDAO.produitsSousSeuil();
    }
}
    

