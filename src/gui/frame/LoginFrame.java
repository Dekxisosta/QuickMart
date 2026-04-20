package gui.frame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import gui.theme.POSTheme;

public class LoginFrame extends JFrame {
    public LoginFrame(POSFrame posFrame) {
        setTitle("QUICKMART POS Login");
        setIconImage(POSTheme.ICON);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(POSTheme.COLOR_BG);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 30, 10, 30);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel logoLabel = new JLabel(new ImageIcon(POSTheme.ICON.getScaledInstance(120, 90, Image.SCALE_SMOOTH)));
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        container.add(logoLabel, gbc);

        JLabel titleLabel = new JLabel("QUICKMART POS", SwingConstants.CENTER);
        titleLabel.setFont(POSTheme.FONT_MAIN);
        titleLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        container.add(titleLabel, gbc);

        JTextField userField = new JTextField();
        styleComponent(userField, "Username");
        gbc.gridy = 2;
        container.add(userField, gbc);

        JPasswordField passField = new JPasswordField();
        styleComponent(passField, "Password");
        gbc.gridy = 3;
        container.add(passField, gbc);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setFont(POSTheme.FONT_BOLD);
        loginBtn.setBackground(POSTheme.COLOR_DARK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("Acheron") && password.equals("hsr1234")) {
                this.dispose(); // Close login
                SwingUtilities.invokeLater(() -> {
                	posFrame.setVisible(true);
                });
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Invalid Credentials", "Error", 
                    JOptionPane.ERROR_MESSAGE);
                passField.setText("");
            }
        });

        gbc.gridy = 4;
        gbc.insets = new Insets(25, 30, 20, 30);
        container.add(loginBtn, gbc);

        add(container);
    }

    private void styleComponent(JComponent comp, String title) {
        comp.setFont(POSTheme.FONT_CART);
        comp.setBackground(Color.WHITE);
        comp.setPreferredSize(new Dimension(0, 40));
        
        TitledBorder border = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(POSTheme.COLOR_DARK, 1), 
            title, 
            TitledBorder.LEFT, 
            TitledBorder.TOP, 
            POSTheme.FONT_BOLD, 
            POSTheme.COLOR_DARK
        );
        comp.setBorder(border);
    }
}