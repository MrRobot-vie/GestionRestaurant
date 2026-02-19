/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//utilisatuerDao
package restaurant.dao;

import restaurant.model.Utilisateur;
import restaurant.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {

    
    // AJOUTER UTILISATEUR
   
    public void ajouterUtilisateur(Utilisateur u) throws SQLException {
        String sql = "INSERT INTO utilisateur(login, mot_de_passe, role) VALUES (?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, u.getLogin());
        ps.setString(2, u.getMotDePasse());
        ps.setString(3, u.getRole());

        ps.executeUpdate();
        con.close();
    }


    // LISTER TOUS LES UTILISATEURS
   
    public List<Utilisateur> listerUtilisateurs() throws SQLException {
        List<Utilisateur> list = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur";

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setIdUtilisateur(rs.getInt("id_utilisateur"));
            u.setLogin(rs.getString("login"));
            u.setMotDePasse(rs.getString("mot_de_passe"));
            u.setRole(rs.getString("role"));
            list.add(u);
        }
        con.close();
        return list;
    }

  
    // TROUVER PAR ID
  
    public Utilisateur trouverParId(int id) throws SQLException {
        String sql = "SELECT * FROM utilisateur WHERE id_utilisateur=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        Utilisateur u = null;

        if (rs.next()) {
            u = new Utilisateur();
            u.setIdUtilisateur(rs.getInt("id_utilisateur"));
            u.setLogin(rs.getString("login"));
            u.setMotDePasse(rs.getString("mot_de_passe"));
            u.setRole(rs.getString("role"));
        }
        con.close();
        return u;
    }

    
    // MODIFIER UTILISATEUR
    
    public void modifierUtilisateur(Utilisateur u) throws SQLException {
        String sql = "UPDATE utilisateur SET login=?, mot_de_passe=?, role=? WHERE id_utilisateur=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, u.getLogin());
        ps.setString(2, u.getMotDePasse());
        ps.setString(3, u.getRole());
        ps.setInt(4, u.getIdUtilisateur());

        ps.executeUpdate();
        con.close();
    }

   
    // SUPPRIMER UTILISATEUR
   
    public void supprimerUtilisateur(int id) throws SQLException {
        String sql = "DELETE FROM utilisateur WHERE id_utilisateur=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
        con.close();
    }

    
    // AUTHENTIFICATION (CLÉ DU PROJET)
 
    public Utilisateur authentifier(String login, String motDePasse) throws SQLException {
        String sql = "SELECT * FROM utilisateur WHERE login=? AND mot_de_passe=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, login);
        ps.setString(2, motDePasse);

        ResultSet rs = ps.executeQuery();
        Utilisateur u = null;

        if (rs.next()) {
            u = new Utilisateur();
            u.setIdUtilisateur(rs.getInt("id_utilisateur"));
            u.setLogin(rs.getString("login"));
            u.setMotDePasse(rs.getString("mot_de_passe"));
            u.setRole(rs.getString("role"));
        }
        con.close();
        return u;
    }
}