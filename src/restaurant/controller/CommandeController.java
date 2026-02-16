/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.controller;
import restaurant.dao.*;
import restaurant.model.*;

import java.sql.SQLException;


/**
 *
 * @author jose
 */
public class CommandeController {
  
    private CommandeDAO commandeDAO = new CommandeDAO();
    private LigneCommandeDAO ligneDAO = new LigneCommandeDAO();
    private ProduitDAO produitDAO = new ProduitDAO();
    private MouvementStockDAO mouvementDAO = new MouvementStockDAO();

    public int creerCommande() throws SQLException {
        Commande c = new Commande();
        c.setEtat("EN_COURS");
        return commandeDAO.creerCommande(c);
    }

    public void ajouterProduitCommande(int idCommande, int idProduit, int quantite)
            throws SQLException {

        Produit p = produitDAO.trouverParId(idProduit);

        if (p.getStockActuel() < quantite) {
            throw new IllegalArgumentException("Stock insuffisant");
        }

        // 1️⃣ Ajouter ligne commande
        LigneCommande lc = new LigneCommande();
        lc.setIdCommande(idCommande);
        lc.setIdProduit(idProduit);
        lc.setQuantite(quantite);
        lc.setPrixUnitaire(p.getPrixVente());

        ligneDAO.ajouterLigneCommande(lc);

        // 2️⃣ Mettre à jour stock
        p.setStockActuel(p.getStockActuel() - quantite);
        produitDAO.modifierProduit(p);

        // 3️⃣ Tracer mouvement stock
        MouvementStock m = new MouvementStock();
        m.setTypeMouvement("SORTIE");
        m.setQuantite(quantite);
        m.setMotif("Vente");
        m.setIdProduit(idProduit);
        mouvementDAO.ajouterMouvement(m);

        // 4️⃣ Recalculer total
        commandeDAO.recalculerTotal(idCommande);
    }

    public void validerCommande(int idCommande) throws SQLException {
        commandeDAO.changerEtat(idCommande, "VALIDEE");
    }
}
    

