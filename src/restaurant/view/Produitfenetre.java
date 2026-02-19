/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package restaurant.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Produitfenetre extends JDialog {
    private boolean ok = false;
    private JTextField libelleField;
    private JComboBox<String> categorieCombo;
    private JSpinner prixSpinner;
    private JSpinner stockSpinner;

    public Produitfenetre(JFrame parent, String title, String libelle, List<String> categories, double prix, int stock) {
        super(parent, title, true);
        setSize(400, 250); // petite dimension carrée
        setLocationRelativeTo(parent);
        setResizable(false);
        getContentPane().setBackground(new Color(240, 248, 255)); // couleur douce

        // Layout
        setLayout(new BorderLayout());

        // Panel central pour les champs
        JPanel centerPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.setBackground(new Color(240, 248, 255));

        // Libelle
        centerPanel.add(new JLabel("Libellé :"));
        libelleField = new JTextField(libelle);
        centerPanel.add(libelleField);

        // Catégorie
        centerPanel.add(new JLabel("Catégorie :"));
        categorieCombo = new JComboBox<>();
        if(categories != null) {
            for(String c : categories) categorieCombo.addItem(c);
        }
        if(libelle != null && !libelle.isEmpty()) {
            categorieCombo.setSelectedItem(libelle);
        }
        centerPanel.add(categorieCombo);

        // Prix
        centerPanel.add(new JLabel("Prix :"));
        prixSpinner = new JSpinner(new SpinnerNumberModel(prix, 0, 10000, 0.5));
        centerPanel.add(prixSpinner);

        // Stock
        centerPanel.add(new JLabel("Stock :"));
        stockSpinner = new JSpinner(new SpinnerNumberModel(stock, 0, 1000, 1));
        centerPanel.add(stockSpinner);

        add(centerPanel, BorderLayout.CENTER);

        // Panel bas pour boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));

        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(0, 102, 102));
        okButton.setForeground(Color.WHITE);
        okButton.addActionListener(e -> {
            ok = true;
            setVisible(false);
        });
        buttonPanel.add(okButton);

        JButton cancelButton = new JButton("Annuler");
        cancelButton.setBackground(new Color(255, 69, 0));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(e -> setVisible(false));
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public boolean isOk() {
        return ok;
    }

    public String getLibelle() {
        return libelleField.getText();
    }

    public String getCategorie() {
        return (String) categorieCombo.getSelectedItem();
    }

    public double getPrix() {
        return (double) prixSpinner.getValue();
    }

    public int getStock() {
        return (int) stockSpinner.getValue();
    }
}


