package gui.panel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gui.theme.POSTheme;

@SuppressWarnings("serial")
public class ActionPanel extends JPanel {
    private JButton cash50Btn, cash100Btn, cash500Btn, cash1000Btn;
    private JButton exactBtn, voidBtn, cancelBtn, drawerBtn, printBtn, payBtn;

    public ActionPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(POSTheme.COLOR_DARK);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel leftContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        leftContainer.setOpaque(false);
        
        JPanel rightContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        rightContainer.setOpaque(false);

        cash50Btn   = createStyledButton("₱50",    new Color(52, 152, 219));
        cash100Btn  = createStyledButton("₱100",   new Color(52, 152, 219));
        cash500Btn  = createStyledButton("₱500",   new Color(52, 152, 219));
        cash1000Btn = createStyledButton("₱1000",  new Color(52, 152, 219));
        exactBtn    = createStyledButton("EXACT",  new Color(155, 89, 182));
        voidBtn     = createStyledButton("VOID",   new Color(220, 53, 69));
        cancelBtn   = createStyledButton("CANCEL", new Color(220, 53, 69));
        drawerBtn   = createStyledButton("DRAWER", new Color(111, 66, 193));
        printBtn    = createStyledButton("PRINT",  new Color(108, 117, 125));
        payBtn      = createStyledButton("PAY",    new Color(40, 167, 69));

        leftContainer.add(cash50Btn);
        leftContainer.add(cash100Btn);
        leftContainer.add(cash500Btn);
        leftContainer.add(cash1000Btn);
        leftContainer.add(exactBtn);
        leftContainer.add(drawerBtn);
        leftContainer.add(voidBtn);
        leftContainer.add(cancelBtn);
        
        rightContainer.add(printBtn);
        rightContainer.add(payBtn);

        add(leftContainer, BorderLayout.WEST);
        add(rightContainer, BorderLayout.EAST);
    }

    // --- GETTERS FOR CONTROLLER ---
    public JButton getCash50Btn() { return cash50Btn; }
    public JButton getCash100Btn() { return cash100Btn; }
    public JButton getCash500Btn() { return cash500Btn; }
    public JButton getCash1000Btn() { return cash1000Btn; }
    public JButton getExactBtn() { return exactBtn; }
    public JButton getVoidBtn() { return voidBtn; }
    public JButton getCancelBtn() { return cancelBtn; }
    public JButton getDrawerBtn() { return drawerBtn; }
    public JButton getPrintBtn() { return printBtn; }
    public JButton getPayBtn() { return payBtn; }
    
    private JButton createStyledButton(String text, Color bg) {
		JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Shape roundedRect = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 0, 0);
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
        };;
        button.setText(text);
        button.setForeground(Color.WHITE);
        button.setFont(POSTheme.FONT_BOLD);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setPreferredSize(new Dimension(100, 50)); 
        
        button.setMaximumSize(new Dimension(40,20)); 

        button.setMargin(new Insets(10, 20, 10, 20));

        return button;
    }
}