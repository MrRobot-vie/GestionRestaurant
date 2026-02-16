/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.dao;
import java.sql.*;
import java.util.*;
import restaurant.model.Commande;
import restaurant.util.DBConnection;

/**
 *
 * @author jose
 */
public class CommandeDAO {
  

    public int creerCommande(Commande c) throws SQLException {
        String sql = "INSERT INTO commande(date_commande, etat, total) VALUES(NOW(), ?, 0)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, c.getEtat());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        con.close();
        return id;
    }

    public List<Commande> listerCommandes() throws SQLException {
        List<Commande> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM commande");

        while (rs.next()) {
            Commande c = new Commande();
            c.setIdCommande(rs.getInt("id_commande"));
            c.setDateCommande(rs.getDate("date_commande"));
            c.setEtat(rs.getString("etat"));
            c.setTotal(rs.getDouble("total"));
            list.add(c);
        }
        con.close();
        return list;
    }

    public void changerEtat(int idCommande, String etat) throws SQLException {
        String sql = "UPDATE commande SET etat=? WHERE id_commande=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, etat);
        ps.setInt(2, idCommande);
        ps.executeUpdate();
        con.close();
    }

    // 🔴 PREUVE DE CALCUL
    public void recalculerTotal(int idCommande) throws SQLException {
        String sql = """
            UPDATE commande
            SET total = (
                SELECT SUM(montant_ligne)
                FROM ligne_commande
                WHERE id_commande = ?
            )
            WHERE id_commande = ?
        """;
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCommande);
        ps.setInt(2, idCommande);
        ps.executeUpdate();
        con.close();
    }
}

   
