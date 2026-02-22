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

    

    public Utilisateur authentifier(String login, String mdp) throws SQLException {
        String sql = "SELECT * FROM utilisateur WHERE login=? AND mot_de_passe=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, login);
        ps.setString(2, mdp);

        ResultSet rs = ps.executeQuery();
        Utilisateur u = null;

        if (rs.next()) {
            u = new Utilisateur();
            u.setIdUtilisateur(rs.getInt("id_utilisateur"));
            u.setLogin(rs.getString("login"));
            u.setRole(rs.getString("role"));
        }
        con.close();
        return u;
    }

    public void ajouterUtilisateur(Utilisateur u) throws SQLException {
        String sql = "INSERT INTO utilisateur(login, mot_de_passe, role) VALUES(?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, u.getLogin());
        ps.setString(2, u.getMotDePasse());
        ps.setString(3, u.getRole());

        ps.executeUpdate();
        con.close();
    }
}