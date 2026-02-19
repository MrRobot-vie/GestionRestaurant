/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.view;

import javax.swing.*;
import java.awt.*;
import restaurant.view.CategorieFrame;
import javax.swing.DefaultListModel;


public class Produit_CatDialog extends JDialog {

    private JTextField tfLibelle;
    private JComboBox<String> cbCategorie;
    private JSpinner spPrix;
    private JSpinner spStock;
    private JButton btnOk, btnAnnuler;
    private boolean isOk = false;

    public Produit_CatDialog(JFrame parent, String title, String libelle, String categorie, double prix, int stock) {
        super(parent, title, true);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Libelle
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Libelle:"), gbc);
        tfLibelle = new JTextField(libelle != null ? libelle : "", 20);
        gbc.gridx = 1;
        add(tfLibelle, gbc);

        // Categorie
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Categorie:"), gbc);
        cbCategorie = new JComboBox<>();
        DefaultListModel<String> model = CategorieFrame.getCategoryModel();
        for (int i = 0; i < model.size(); i++) {
            cbCategorie.addItem(model.getElementAt(i));
        }
        if(categorie != null) cbCategorie.setSelectedItem(categorie);
        gbc.gridx = 1;
        add(cbCategorie, gbc);

        // Prix
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Prix:"), gbc);
        spPrix = new JSpinner(new SpinnerNumberModel(prix >= 0 ? prix : 0, 0, Double.MAX_VALUE, 0.5));
        gbc.gridx = 1;
        add(spPrix, gbc);

        // Stock
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Stock:"), gbc);
        spStock = new JSpinner(new SpinnerNumberModel(stock >= 0 ? stock : 0, 0, 10000, 1));
        gbc.gridx = 1;
        add(spStock, gbc);

        // Buttons
        btnOk = new JButton("OK");
        btnAnnuler = new JButton("Annuler");
        JPanel panelBtn = new JPanel();
        panelBtn.add(btnOk);
        panelBtn.add(btnAnnuler);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(panelBtn, gbc);

        // Actions
        btnOk.addActionListener(e -> {
            isOk = true;
            dispose();
        });
        btnAnnuler.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isOk() {
        return isOk;
    }

    public String getLibelle() {
        return tfLibelle.getText();
    }

    public String getCategorie() {
        Object selected = cbCategorie.getSelectedItem();
        return selected != null ? selected.toString() : "";
    }

    public double getPrix() {
        return (double) spPrix.getValue();
    }

    public int getStock() {
        return (int) spStock.getValue();
    }
}
