/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.dao;
import java.sql.*;
import java.util.*;
import restaurant.model.Utilisateur;
import restaurant.util.DBConnection;

/**
 *
 * @author jose
 */
public class UtilisateurDAO {
 
     public void ajouterUtilisateur(Utilisateur u) throws SQLException {
        String sql = "INSERT INTO utilisateur(login, mot_de_passe) VALUES(?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u.getLogin());
        ps.setString(2, u.getMotDePasse());
        ps.executeUpdate();
        con.close();
    }

    public List<Utilisateur> listerUtilisateurs() throws SQLException {
        List<Utilisateur> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM utilisateur");

        while (rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setIdUtilisateur(rs.getInt("id_utilisateur"));
            u.setLogin(rs.getString("login"));
            u.setMotDePasse(rs.getString("mot_de_passe"));
            list.add(u);
        }
        con.close();
        return list;
    }

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
        }
        con.close();
        return u;
    }

    public void modifierUtilisateur(Utilisateur u) throws SQLException {
        String sql = "UPDATE utilisateur SET login=?, mot_de_passe=? WHERE id_utilisateur=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u.getLogin());
        ps.setString(2, u.getMotDePasse());
        ps.setInt(3, u.getIdUtilisateur());
        ps.executeUpdate();
        con.close();
    }

    public void supprimerUtilisateur(int id) throws SQLException {
        String sql = "DELETE FROM utilisateur WHERE id_utilisateur=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

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
        }
        con.close();
        return u;
    }
    
}
