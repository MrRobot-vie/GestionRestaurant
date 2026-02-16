/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.dao;
import java.sql.*;
import java.util.*;
import restaurant.model.Produit;
import restaurant.util.DBConnection;


/**
 *
 * @author jose
 */
public class ProduitDAO {
     public void ajouterProduit(Produit p) throws SQLException {
        String sql = """
            INSERT INTO produit(nom, prix_vente, stock_actuel, seuil_alerte, id_categorie)
            VALUES(?,?,?,?,?)
        """;
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getNom());
        ps.setDouble(2, p.getPrixVente());
        ps.setInt(3, p.getStockActuel());
        ps.setInt(4, p.getSeuilAlerte());
        ps.setInt(5, p.getIdCategorie());

        ps.executeUpdate();
        con.close();
    }

    public List<Produit> listerProduits() throws SQLException {
        List<Produit> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM produit");

        while (rs.next()) {
            Produit p = new Produit();
            p.setIdProduit(rs.getInt("id_produit"));
            p.setNom(rs.getString("nom"));
            p.setPrixVente(rs.getDouble("prix_vente"));
            p.setStockActuel(rs.getInt("stock_actuel"));
            p.setSeuilAlerte(rs.getInt("seuil_alerte"));
            p.setIdCategorie(rs.getInt("id_categorie"));
            list.add(p);
        }
        con.close();
        return list;
    }
    
    public Produit trouverParId(int id) throws SQLException {
        String sql = "SELECT * FROM produit WHERE id_produit=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        Produit p = null;
        if (rs.next()) {
            p = new Produit();
            p.setIdProduit(rs.getInt("id_produit"));
            p.setNom(rs.getString("nom"));
            p.setPrixVente(rs.getDouble("prix_vente"));
            p.setStockActuel(rs.getInt("stock_actuel"));
            p.setSeuilAlerte(rs.getInt("seuil_alerte"));
            p.setIdCategorie(rs.getInt("id_categorie"));
        }
        con.close();
        return p;
    }
    public void modifierProduit(Produit p) throws SQLException {
        String sql = """
            UPDATE produit
            SET nom=?, prix_vente=?, stock_actuel=?, seuil_alerte=?, id_categorie=?
            WHERE id_produit=?
        """;
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getNom());
        ps.setDouble(2, p.getPrixVente());
        ps.setInt(3, p.getStockActuel());
        ps.setInt(4, p.getSeuilAlerte());
        ps.setInt(5, p.getIdCategorie());
        ps.setInt(6, p.getIdProduit());

        ps.executeUpdate();
        con.close();
    }

    public void supprimerProduit(int id) throws SQLException {
        String sql = "DELETE FROM produit WHERE id_produit=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    // MÉTIER
    public List<Produit> produitsSousSeuil() throws SQLException {
        List<Produit> list = new ArrayList<>();
        String sql = "SELECT * FROM produit WHERE stock_actuel <= seuil_alerte";
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery(sql);

        while (rs.next()) {
            Produit p = new Produit();
            p.setIdProduit(rs.getInt("id_produit"));
            p.setNom(rs.getString("nom"));
            p.setStockActuel(rs.getInt("stock_actuel"));
            p.setSeuilAlerte(rs.getInt("seuil_alerte"));
            list.add(p);
        }
        con.close();
        return list;
    }
}

  
  