/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.controller;
import restaurant.dao.CategorieDAO;
import restaurant.model.Categorie;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author jose
 */
public class CategorieController {
    
  

    private CategorieDAO categorieDAO = new CategorieDAO();

    public void ajouterCategorie(String libelle) throws SQLException {
        Categorie c = new Categorie();
        c.setLibelle(libelle);
        categorieDAO.ajouterCategorie(c);
    }

    public List<Categorie> listerCategories() throws SQLException {
        return categorieDAO.listerCategories();
    }

    public void modifierCategorie(int id, String libelle) throws SQLException {
        Categorie c = new Categorie();
        c.setIdCategorie(id);
        c.setLibelle(libelle);
        categorieDAO.modifierCategorie(c);
    }

    public void supprimerCategorie(int id) throws SQLException {
        categorieDAO.supprimerCategorie(id);
    }
}
    

