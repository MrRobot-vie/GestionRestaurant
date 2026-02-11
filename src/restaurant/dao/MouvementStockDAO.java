/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.dao;
import java.sql.*;
import java.util.*;
import restaurant.model.MouvementStock;
import restaurant.util.DBConnection;

/**
 *
 * @author jose
 */
public class MouvementStockDAO {
    
   

    public void ajouterMouvement(MouvementStock m) throws SQLException {
        String sql = """
            INSERT INTO mouvement_stock(type_mouvement, quantite, date_mouvement, motif, id_produit)
            VALUES(?, ?, NOW(), ?, ?)
        """;
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, m.getTypeMouvement());
        ps.setInt(2, m.getQuantite());
        ps.setString(3, m.getMotif());
        ps.setInt(4, m.getIdProduit());

        ps.executeUpdate();
        con.close();
    }

    public List<MouvementStock> listerParProduit(int idProduit) throws SQLException {
        List<MouvementStock> list = new ArrayList<>();
        String sql = "SELECT * FROM mouvement_stock WHERE id_produit=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idProduit);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MouvementStock m = new MouvementStock();
            m.setIdMouvement(rs.getInt("id_mouvement"));
            m.setTypeMouvement(rs.getString("type_mouvement"));
            m.setQuantite(rs.getInt("quantite"));
            m.setDateMouvement(rs.getDate("date_mouvement"));
            m.setMotif(rs.getString("motif"));
            list.add(m);
        }
        con.close();
        return list;
    }
    
}
