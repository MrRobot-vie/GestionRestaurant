/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.dao;
import java.sql.*;
import java.util.*;
import restaurant.model.Categorie;
import restaurant.util.DBConnection;


/**
 *
 * @author jose
 */
public class CategorieDAO {
   

    public void ajouterCategorie(Categorie c) throws SQLException {
        String sql = "INSERT INTO categorie(libelle) VALUES(?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getLibelle());
        ps.executeUpdate();
        con.close();
    }

    public List<Categorie> listerCategories() throws SQLException {
        List<Categorie> list = new ArrayList<>();
        String sql = "SELECT * FROM categorie";
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery(sql);

        while (rs.next()) {
            Categorie c = new Categorie();
            c.setIdCategorie(rs.getInt("id_categorie"));
            c.setLibelle(rs.getString("libelle"));
            list.add(c);
        }
        con.close();
        return list;
    }
     public Categorie trouverParId(int id) throws SQLException {
        String sql = "SELECT * FROM categorie WHERE id_categorie=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Categorie c = null;
        if (rs.next()) {
            c = new Categorie();
            c.setIdCategorie(rs.getInt("id_categorie"));
            c.setLibelle(rs.getString("libelle"));
        }
        con.close();
        return c;
    }

    public void modifierCategorie(Categorie c) throws SQLException {
        String sql = "UPDATE categorie SET libelle=? WHERE id_categorie=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getLibelle());
        ps.setInt(2, c.getIdCategorie());
        ps.executeUpdate();
        con.close();
    }

    public void supprimerCategorie(int id) throws SQLException {
        String sql = "DELETE FROM categorie WHERE id_categorie=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
    
}
