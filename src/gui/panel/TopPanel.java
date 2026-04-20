package gui.panel;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gui.frame.POSFrame;
import gui.theme.POSTheme;

@SuppressWarnings("serial")
public class TopPanel extends JPanel {
    private JPanel topTabs;
    private List<JButton> categoryButtons;

    public TopPanel() {
        this.categoryButtons = new ArrayList<>();
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(createHeaderPanel());
        add(createTabPanel());
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(true);
        headerPanel.setBackground(POSTheme.COLOR_DARK);
        headerPanel.setPreferredSize(new Dimension(1200, 48));
        headerPanel.setBorder(new EmptyBorder(0, 16, 0, 16));
     
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
     
        Image rawLogo = new ImageIcon(POSFrame.class.getResource("/icons/icon.png")).getImage();
        JLabel logoLabel = new JLabel(new ImageIcon(rawLogo.getScaledInstance(48, 32, Image.SCALE_SMOOTH)));
        logoLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
     
        JLabel storeName = new JLabel("QUICKMART : POS");
        storeName.setFont(new Font("Arial", Font.BOLD, 13));
        storeName.setForeground(Color.WHITE);
        storeName.setAlignmentY(Component.CENTER_ALIGNMENT);
     
        JLabel separator = new JLabel("  |  ");
        separator.setForeground(new Color(120, 100, 160));
        separator.setAlignmentY(Component.CENTER_ALIGNMENT);
     
        JLabel dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        dateTimeLabel.setForeground(new Color(180, 170, 210));
        dateTimeLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
     
        Timer clockTimer = new Timer(1000, ____e____ -> {
            String dt = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss a").format(new java.util.Date());
            dateTimeLabel.setText(dt);
        });
        clockTimer.setInitialDelay(0);
        clockTimer.start();
     
        leftPanel.add(logoLabel);
        leftPanel.add(Box.createHorizontalStrut(8));
        leftPanel.add(storeName);
        leftPanel.add(separator);
        leftPanel.add(dateTimeLabel);
     
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
     
        JLabel cashierLabel = new JLabel("Cashier: Acheron");
        cashierLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        cashierLabel.setForeground(new Color(200, 195, 220));
        cashierLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
     
        Image rawProfile = new ImageIcon(POSFrame.class.getResource("/images/profile.jpg")).getImage();
        int profileSize = 34;
        ImageIcon profileIcon = new ImageIcon(rawProfile.getScaledInstance(profileSize, profileSize, Image.SCALE_SMOOTH));
     
        JButton userBtn = new JButton(profileIcon);
        userBtn.setPreferredSize(new Dimension(profileSize, profileSize));
        userBtn.setMaximumSize(new Dimension(profileSize, profileSize));
        userBtn.setOpaque(false);
        userBtn.setContentAreaFilled(false);
        userBtn.setBorderPainted(false);
        userBtn.setFocusPainted(false);
        userBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userBtn.setAlignmentY(Component.CENTER_ALIGNMENT);
     
        rightPanel.add(cashierLabel);
        rightPanel.add(Box.createHorizontalStrut(10));
        rightPanel.add(userBtn);
     
        JPanel leftWrapper = new JPanel(new GridBagLayout());
        leftWrapper.setOpaque(false);
        leftWrapper.add(leftPanel);
     
        JPanel rightWrapper = new JPanel(new GridBagLayout());
        rightWrapper.setOpaque(false);
        rightWrapper.add(rightPanel);
     
        headerPanel.add(leftWrapper, BorderLayout.WEST);
        headerPanel.add(rightWrapper, BorderLayout.EAST);
     
        return headerPanel;
    }

    private JPanel createTabPanel() {
        topTabs = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 12));
        topTabs.setBackground(Color.WHITE);
        topTabs.setMaximumSize(new Dimension(Integer.MAX_VALUE, 72));
        topTabs.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(210, 214, 218)));

        ImageIcon texture = new ImageIcon(POSFrame.class.getResource("/images/texture3.png"));

        for (String cat : POSTheme.CATEGORIES) {
            JButton btn = new JButton(cat.toUpperCase()) {
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    if (texture != null) {
                        float alpha = 0.1f;
                        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                        g2.drawImage(texture.getImage(), 0, 0, getWidth(), getHeight(), this);
                        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
                    }
                    super.paintComponent(g2);
                    g2.dispose();
                }
            };

            btn.setPreferredSize(new Dimension(140, 48));
            btn.setOpaque(false);
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setFont(POSTheme.FONT_BOLD);
            btn.setForeground(POSTheme.COLOR_DARK);
            btn.setBorder(new LineBorder(new Color(150, 120, 200), 1));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            categoryButtons.add(btn);
            topTabs.add(btn);
        }
        return topTabs;
    }
    
    public List<JButton> getCategoryButtons() {
        return categoryButtons;
    }
}