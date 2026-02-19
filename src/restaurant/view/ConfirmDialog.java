/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package restaurant.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfirmDialog extends JDialog {
    private boolean ok = false;

    public ConfirmDialog(JFrame parent, String message) {
        super(parent, "Confirmation", true);
        setSize(350, 150);
        setLocationRelativeTo(parent);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 250, 240));

        setLayout(new BorderLayout());

        // Message
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Segoe Print", Font.BOLD, 14));
        label.setForeground(new Color(139, 0, 0));
        add(label, BorderLayout.CENTER);

        // Panel des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 250, 240));

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
}
