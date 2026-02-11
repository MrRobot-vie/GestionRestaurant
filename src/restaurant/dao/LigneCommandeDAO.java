/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.dao;
import java.sql.*;
import java.util.*;
import restaurant.model.LigneCommande;
import restaurant.util.DBConnection;

/**
 *
 * @author jose
 */
public class LigneCommandeDAO {
    

    public void ajouterLigneCommande(LigneCommande lc) throws SQLException {
        lc.setMontantLigne(lc.getQuantite() * lc.getPrixUnitaire());

        String sql = """
            INSERT INTO ligne_commande(quantite, prix_unitaire, montant_ligne, id_commande, id_produit)
            VALUES(?,?,?,?,?)
        """;
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, lc.getQuantite());
        ps.setDouble(2, lc.getPrixUnitaire());
        ps.setDouble(3, lc.getMontantLigne());
        ps.setInt(4, lc.getIdCommande());
        ps.setInt(5, lc.getIdProduit());

        ps.executeUpdate();
        con.close();
    }

    public List<LigneCommande> lignesParCommande(int idCommande) throws SQLException {
        List<LigneCommande> list = new ArrayList<>();
        String sql = "SELECT * FROM ligne_commande WHERE id_commande=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCommande);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            LigneCommande lc = new LigneCommande();
            lc.setIdLigne(rs.getInt("id_ligne"));
            lc.setQuantite(rs.getInt("quantite"));
            lc.setPrixUnitaire(rs.getDouble("prix_unitaire"));
            lc.setMontantLigne(rs.getDouble("montant_ligne"));
            lc.setIdProduit(rs.getInt("id_produit"));
            list.add(lc);
        }
        con.close();
        return list;
    }  
}
