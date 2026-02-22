/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.dao;

import restaurant.model.Categorie;
import restaurant.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class CategorieDAO {

    public void ajouter(Categorie c) throws SQLException {
        String sql = "INSERT INTO categorie(libelle) VALUES (?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getLibelle());
        ps.executeUpdate();
        con.close();
    }

    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM categorie WHERE id_categorie=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    public List<Categorie> lister() throws SQLException {
        List<Categorie> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM categorie");

        while (rs.next()) {
            Categorie c = new Categorie();
            c.setIdCategorie(rs.getInt("id_categorie"));
            c.setLibelle(rs.getString("libelle"));
            list.add(c);
        }

        con.close();
        return list;
    }
}