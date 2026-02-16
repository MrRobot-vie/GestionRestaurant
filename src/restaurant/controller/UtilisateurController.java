/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.controller;
import restaurant.dao.UtilisateurDAO;
import restaurant.model.Utilisateur;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class UtilisateurController {
   

    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    public Utilisateur login(String login, String motDePasse) throws SQLException {
        Utilisateur u = utilisateurDAO.authentifier(login, motDePasse);

        if (u == null) {
            throw new IllegalArgumentException("Login ou mot de passe incorrect");
        }
        return u;
    }

    public void creerUtilisateur(String login, String mdp) throws SQLException {
        Utilisateur u = new Utilisateur();
        u.setLogin(login);
        u.setMotDePasse(mdp);
        utilisateurDAO.ajouterUtilisateur(u);
    }
}

