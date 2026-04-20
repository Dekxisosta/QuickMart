package gui.panel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import gui.theme.POSTheme;
import gui.util.AutoHideScrollPane;

@SuppressWarnings("serial")
public class ProductPanel extends JPanel {
    private JPanel productGrid;
    private JScrollPane scroll;
    private final int COLS = 4;
    private final int GAP = 12;

    public ProductPanel() {
        setLayout(new BorderLayout());
        setOpaque(false);
        productGrid = new JPanel(new GridLayout(0, COLS, GAP, GAP));
        productGrid.setOpaque(false);
        
        productGrid.setBorder(new EmptyBorder(12, 12, 12, 12));

        scroll = new AutoHideScrollPane(productGrid);
        
        add(scroll, BorderLayout.CENTER);
    }

    public void refreshGrid() {
    	productGrid.revalidate();
        productGrid.repaint();
    }
	public void addProduct(String name, double price, int index) {
    	int row = index / 4;
        Color bg = getRowColor(row);
        int brightness = (int) (0.299 * bg.getRed() +
                0.587 * bg.getGreen() +
                0.114 * bg.getBlue());
        System.out.println(brightness);
        String html = String.format(
                "<html><div style='color:%s; width:100px;text-align:center;'>" +
                        "<b style='font-size:11px;'>%s</b><br>" +
                        "<span style='font-size:10px;'>₱%.2f</span></div></html>",
                
                (brightness<140)? "white": "#6B4226",
                name, 
                price
        );

        JButton pBtn = createStyledButton(bg);
        pBtn.setBorder(new AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getRowBorderColor(row));
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(x, y, w - 2, h - 2, 32, 32);
                g2.dispose();
            }
        });
        pBtn.setText(html);
        pBtn.setOpaque(false);
        pBtn.setContentAreaFilled(false);
        pBtn.setFont(POSTheme.FONT_MAIN);
        pBtn.setFocusPainted(false);
        pBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pBtn.setBackground(bg);
        
        productGrid.add(pBtn);
    }

	public void addProduct(int index, ImageIcon icon) {
        int row = index / 4;
        Color bg = getRowColor(row);
        JButton pBtn = createStyledButton(bg);
        pBtn.setFont(POSTheme.FONT_MAIN);

        if (icon != null) {
            Image scaledImg = icon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
            pBtn.setIcon(new ImageIcon(scaledImg));
        }
        pBtn.setBorder(new AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getRowBorderColor(row));
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(x, y, w - 2, h - 2, 32, 32);
                g2.dispose();
            }
        });
        pBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        pBtn.setHorizontalTextPosition(SwingConstants.CENTER);

        pBtn.setFocusPainted(false);
        pBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pBtn.setBackground(bg);
        
        productGrid.add(pBtn);
    }
    public JPanel getProductGrid() {return productGrid;}
    private JButton createStyledButton(Color bg) {
        return new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Shape roundedRect = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 32, 32);
                g2.setColor(bg);
                g2.fill(roundedRect); 
                if (POSTheme.TEXTURE3 != null) {
                    Shape oldClip = g2.getClip(); 
                    
                    g2.clip(roundedRect); 

                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
                    g2.drawImage(POSTheme.TEXTURE3, 0, 0, getWidth(), getHeight(), this);
                    
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
                    g2.setClip(oldClip); 
                }
                super.paintComponent(g2);

                g2.dispose();
            }

            @Override
            public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setContentAreaFilled(false);
                setBorderPainted(true);
            }
        };
    }
    
    private Color getRowColor(int row) {
        switch (row) {
            case 0: return new Color(255, 215, 0);
            case 1: return new Color(209, 255, 220);
            case 2: return new Color(220, 228, 255);
            case 3: return new Color(220, 195, 255);
            case 4: return new Color(210, 160, 255);
            default: return new Color(160, 100, 255);
        }
    }
    private Color getRowBorderColor(int row) {
        switch (row) {
            case 0: return new Color(200, 165, 0);
            case 1: return new Color(150, 210, 165);
            case 2: return new Color(160, 175, 220);
            case 3: return new Color(165, 140, 210);
            case 4: return new Color(160, 110, 220);
            default: return new Color(110, 55, 210);
        }
    }
}