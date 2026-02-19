/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.controller;

import restaurant.dao.UtilisateurDAO;
import restaurant.model.Utilisateur;

public class UtilisateurController {

    private UtilisateurDAO dao = new UtilisateurDAO();

    // Connexion
    public Utilisateur seConnecter(String login, String mdp) throws Exception {
        Utilisateur u = dao.authentifier(login, mdp);
        if (u == null) {
            throw new Exception("Login ou mot de passe incorrect");
        }
        return u;
    }

    //  Création utilisateur (ADMIN seulement)
    public void creerUtilisateur(Utilisateur utilisateurConnecte, Utilisateur nouveau) throws Exception {
        if (!utilisateurConnecte.getRole().equals("ADMIN")) {
            throw new Exception("Action interdite : ADMIN uniquement");
        }
        dao.ajouterUtilisateur(nouveau);
    }

    //  Vérification de droits
    public boolean estAdmin(Utilisateur u) {
        return u.getRole().equals("ADMIN");
    }
}