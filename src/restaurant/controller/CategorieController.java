/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.controller;

import restaurant.dao.CategorieDAO;
import restaurant.model.Categorie;

import java.util.List;




public class CategorieController {

    private CategorieDAO dao = new CategorieDAO();

    public void ajouterCategorie(String libelle) throws Exception {
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new Exception("Libellé obligatoire");
        }
        Categorie c = new Categorie();
        c.setLibelle(libelle);
        dao.ajouter(c);
    }

    public void supprimerCategorie(int id) throws Exception {
        dao.supprimer(id);
    }

    public List<Categorie> chargerCategories() throws Exception {
        return dao.lister();
    }
}