package gui.frame;

import javax.swing.*;

import gui.dialog.DialogManager;
import gui.panel.ActionPanel;
import gui.panel.CartPanel;
import gui.panel.ProductPanel;
import gui.panel.TopPanel;
import gui.theme.POSTheme;
import model.base.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

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
    public void resetQuantityInput() {
        cartPanel.clearAndFocusQty();
    }

    public String getQuantityInput() {
        return cartPanel.getQtyText();
    }

    public String getQtyFieldText() {
        return cartPanel.getQtyField().getText().trim();
    }

    public void clearQtyField() {
        cartPanel.getQtyField().setText("");
    }

    public void showMessage(String message) {
        dialogManager.showMessage(this, message);
    }

    public String showInputDialog(String prompt) {
        return dialogManager.showInputDialog(this, prompt);
    }

    public String showPinDialog(String prompt) {
        return dialogManager.showPinDialog(this, prompt);
    }

    public List<CartItem> getCartItems() {
        return cartPanel().getCartItems();
    }

    public boolean isCartEmpty() {
        return cartPanel.getTableModel().getRowCount() == 0;
    }

    public int findActiveCartRowByBarcode(String barcode) {
        return cartPanel.findActiveRowByBarcode(barcode);
    }

    public int getCartRowQty(int row) {
        return cartPanel.getRowQty(row);
    }

    public void updateCartRow(int row, int newQty, double finalPrice) {
        cartPanel.updateRow(row, newQty, finalPrice);
    }

    public void addCartRow(String barcode, String name, int qty, double finalPrice) {
        cartPanel.addRow(barcode, name, qty, finalPrice);
    }

    public boolean voidCartItemByBarcode(String barcode) {
        return cartPanel.voidItemByBarcode(barcode);
    }

    public void clearCartTable() {
        cartPanel.getTableModel().setRowCount(0);
    }

    public void clearReceivedField() {
        cartPanel.getReceivedField().setText("");
    }

    public void setTotalLabel(double total) {
        cartPanel.getTotalLabel().setText(String.format("₱%.2f", total));
    }

    public String getReceivedFieldText() {
        return cartPanel.getReceivedField().getText();
    }

    public void setChangeField(double change) {
        cartPanel.getChangeField().setText(String.format("₱%.2f", change));
    }

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