package gui.frame;

import javax.swing.*;

import gui.dialog.DialogManager;
import gui.panel.ActionPanel;
import gui.panel.CartPanel;
import gui.panel.ProductPanel;
import gui.panel.TopPanel;
import gui.theme.POSTheme;

import javax.swing.border.EmptyBorder;
import java.awt.*;

@SuppressWarnings("serial")
public class POSFrame extends JFrame {
	private final DialogManager dialogManager;
	private final TopPanel topPanel;
	private final ProductPanel productPanel;
	private final CartPanel cartPanel;
	private final ActionPanel actionPanel;

    public POSFrame(
    		DialogManager dialogManager,
    		TopPanel topPanel,
    		ProductPanel productPanel,
    		CartPanel cartPanel,
    		ActionPanel actionPanel
    		) {
    	this.dialogManager = dialogManager;
    	this.topPanel = topPanel;
    	this.productPanel = productPanel;
    	this.cartPanel = cartPanel;
    	this.actionPanel = actionPanel;
        initMainFrame();
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(createCenterPanel(cartPanel, productPanel), BorderLayout.CENTER);
        getContentPane().add(actionPanel, BorderLayout.SOUTH);
    }
    public DialogManager getDialogService() {return dialogManager;}
    public TopPanel getTopPanel() {return topPanel;}
    public ProductPanel getProductPanel() {return productPanel;}
    public CartPanel getCartPanel() {return cartPanel;}
    public ActionPanel getActionPanel() {return actionPanel;}
    
    private void initMainFrame() {
        setTitle("QuickMart POS System - Matatag Corp.");
        setSize(1200, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (POSTheme.BG_IMAGE != null) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.drawImage(POSTheme.BG_IMAGE, 0, 0, getWidth(), getHeight(), this);
                    
                    g2.setColor(new Color(255, 255, 255, 220));
                    g2.fillRect(0, 0, getWidth(), getHeight());
                    
                    g2.dispose();
                }
            }
        };

        setContentPane(backgroundPanel);
        super.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("./icons/icon.png")).getImage());
    }
    private JPanel createCenterPanel(CartPanel cartPanel, ProductPanel productPanel) {
        JPanel centerPanel = new JPanel(new BorderLayout(15, 0));
        centerPanel.setOpaque(false);
        centerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        centerPanel.add(productPanel, BorderLayout.CENTER);
        centerPanel.add(cartPanel, BorderLayout.EAST);

        return centerPanel;
    }
}