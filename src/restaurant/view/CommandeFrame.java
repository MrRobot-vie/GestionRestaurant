/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.view;

import javax.swing.SwingUtilities;

/**
 *
 * @author DELL
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class CommandeFrame extends JFrame{
  

    private DefaultTableModel model;
    private JTable table;

    private JTextField txtProduit;
    private JTextField txtPrix;
    private JTextField txtQuantite;
    private JComboBox<String> cbEtat;
    private JLabel lblTotal;
    private javax.swing.JSpinner jspQuantite;


    public CommandeFrame() {
        initUI();
        jspQuantite = new javax.swing.JSpinner(
        new javax.swing.SpinnerNumberModel(1, 1, 1000, 1)
);

    }

    private void initUI() {

        setTitle("Gestion des commandes");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 🎨 Couleurs
        Color primary = new Color(0, 102, 102);
        Color secondary = new Color(97, 141, 142);
        Color accent = new Color(10, 75, 83);

        setLayout(new BorderLayout());

        // ===== HEADER =====
        JLabel title = new JLabel("GESTION DES COMMANDES", SwingConstants.CENTER);
        title.setFont(new Font("Segoe Print", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setBackground(primary);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // ===== TABLE =====
        model = new DefaultTableModel(
                new Object[]{"Produit", "Prix", "Quantité", "Etat", "Date", "Total Ligne"}, 0);

        table = new JTable(model);
        table.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createTitledBorder("Liste des commandes"));

        // ===== FORMULAIRE =====
        JPanel form = new JPanel(new GridLayout(2, 5, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Nouvelle commande"));
        form.setBackground(secondary);

        txtProduit = new JTextField();
        txtPrix = new JTextField();
        txtQuantite = new JTextField();

        cbEtat = new JComboBox<>(new String[]{"En attente", "En préparation", "Servi"});

        form.add(new JLabel("Produit"));
        form.add(new JLabel("Prix"));
        form.add(new JLabel("Quantité"));
        form.add(new JLabel("Etat"));
        form.add(new JLabel(""));

        form.add(txtProduit);
        form.add(txtPrix);
        form.add(txtQuantite);
        form.add(cbEtat);

        JButton btnAjouter = new JButton("Ajouter");
        form.add(btnAjouter);

        // ===== BOUTONS =====
        JPanel actions = new JPanel();
        actions.setBackground(accent);

        JButton btnSupprimer = new JButton("Supprimer");
        JButton btnVider = new JButton("Vider");
        JButton btnTotal = new JButton("Calculer Total");

        actions.add(btnSupprimer);
        actions.add(btnVider);
        actions.add(btnTotal);

        // ===== FOOTER TOTAL =====
        JPanel footer = new JPanel();
        footer.setBackground(primary);

        JLabel lblMontant = new JLabel("TOTAL : ");
        lblMontant.setForeground(Color.WHITE);
        lblMontant.setFont(new Font("Segoe Print", Font.BOLD, 16));

        lblTotal = new JLabel("0 FCFA");
        lblTotal.setForeground(Color.WHITE);
        lblTotal.setFont(new Font("Segoe Print", Font.BOLD, 16));

        footer.add(lblMontant);
        footer.add(lblTotal);

        // ===== CENTER PANEL =====
        JPanel center = new JPanel(new BorderLayout());
        center.add(form, BorderLayout.NORTH);
        center.add(scroll, BorderLayout.CENTER);
        center.add(actions, BorderLayout.SOUTH);

        add(center, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

        // ===== ACTIONS =====

        btnAjouter.addActionListener(this::ajouterCommande);
        btnSupprimer.addActionListener(e -> supprimerLigne());
        btnVider.addActionListener(e -> viderTable());
        btnTotal.addActionListener(e -> calculerTotal());
    }

    // ================= MÉTHODES =================

    private void ajouterCommande(ActionEvent e) {
        try {
            String produit = txtProduit.getText();
            double prix = Double.parseDouble(txtPrix.getText());
            int quantite = Integer.parseInt(txtQuantite.getText());
            String etat = cbEtat.getSelectedItem().toString();

            double totalLigne = prix * quantite;

            model.addRow(new Object[]{
                    produit,
                    prix,
                    quantite,
                    etat,
                    LocalDate.now(),
                    totalLigne
            });

            JOptionPane.showMessageDialog(this,
                    "Commande ajoutée avec succès ✅",
                    "Succès",
                    JOptionPane.INFORMATION_MESSAGE);

            txtProduit.setText("");
            txtPrix.setText("");
            txtQuantite.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Vérifie les champs saisis ⚠️",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void supprimerLigne() {
        int selected = table.getSelectedRow();
        if (selected >= 0) {
            model.removeRow(selected);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Sélectionne une ligne à supprimer",
                    "Attention",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void viderTable() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Voulez-vous vraiment vider la table ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            model.setRowCount(0);
            lblTotal.setText("0 FCFA");
        }
    }

    private void calculerTotal() {
        double total = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            total += Double.parseDouble(model.getValueAt(i, 5).toString());
        }

        lblTotal.setText(total + " FCFA");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CommandeFrame().setVisible(true));
    }
}


