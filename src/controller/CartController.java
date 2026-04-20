package controller;

import model.base.Product;
import service.ProductService;
import service.TotalService;
import gui.frame.POSFrame;

import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class CartController {
    private final POSFrame view;
    private final TotalService totalService;
    private final ProductService productService;

    public CartController(POSFrame view, TotalService totalService, ProductService productService) {
        this.view = view;
        this.totalService = totalService;
        this.productService = productService;
    }

    public void handleTextFieldEntry() {
        String input = view.getCartPanel().getQtyField().getText().trim();
        if (input.isEmpty() || input.endsWith("*")) return;

        Product found = productService.findByBarcode(input);
        if (found != null) {
            addToCart(found);
        } else {
            Toolkit.getDefaultToolkit().beep();
            view.getDialogService().showMessage(view, "Product not found: " + input);
            view.getCartPanel().getQtyField().setText("");
        }
    }

    public void addToCart(Product p) {
        try {
            String input = view.getCartPanel().getQtyField().getText().trim();
            int qty = 1;
            if (!input.isEmpty() && input.endsWith("*")) {
                qty = Integer.parseInt(input.substring(0, input.length() - 1));
            }

            DefaultTableModel model = view.getCartPanel().getTableModel();
            int existingRow = -1;

            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).equals(p.getBarcode()) && model.getValueAt(i, 5).equals("")) {
                    existingRow = i;
                    break;
                }
            }

            if (existingRow != -1) {
                int currentQty = (int) model.getValueAt(existingRow, 2);
                int newQty = currentQty + qty;
                model.setValueAt(newQty, existingRow, 2);
                model.setValueAt(String.format("₱%.2f", p.getFinalPrice() * newQty), existingRow, 4);
            } else {
                model.addRow(new Object[]{
                        p.getBarcode(),
                        p.getName(),
                        qty,
                        String.format("₱%.2f", p.getFinalPrice()),
                        String.format("₱%.2f", p.getFinalPrice() * qty),
                        ""
                });
            }
            view.getCartPanel().getQtyField().setText("");
            view.getCartPanel().getQtyField().requestFocus();
            refreshTotals();
        } catch (NumberFormatException e) {
            view.getCartPanel().getQtyField().setText("");
        }
    }

    public void handleVoidRequest() {
        String barcode = view.getDialogService().showInputDialog(view, "Enter Barcode to Void:");
        if (barcode == null || barcode.isEmpty()) return;

        String pin = view.getDialogService().showPinDialog(view, "Manager PIN Required");
        if ("1234".equals(pin)) {
            DefaultTableModel model = view.getCartPanel().getTableModel();
            boolean found = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).equals(barcode) && model.getValueAt(i, 5).equals("")) {
                    model.setValueAt("<<VOID>>", i, 5);
                    found = true;
                    break;
                }
            }
            if (!found) {
                view.getDialogService().showMessage(view, "Active item with barcode " + barcode + " not found.");
            }
        } else {
            view.getDialogService().showMessage(view, "Invalid Authentication.");
        }
        refreshTotals();
    }

    public void handleCancelRequest() {
    	if(view.getCartPanel().getTableModel().getRowCount() == 0) return;
    	
        String pin = view.getDialogService().showPinDialog(view, "Manager PIN Required");
        if ("1234".equals(pin)) {
            clearCart();
        } else {
            view.getDialogService().showMessage(view, "Invalid Authentication.");
        }
    }

    public void clearCart() {
        view.getCartPanel().getTableModel().setRowCount(0);
        view.getCartPanel().getReceivedField().setText("");
        refreshTotals();
    }

    public void refreshTotals() {
        double total = totalService.getCartTotal(view.getCartPanel().getTableModel());
        view.getCartPanel().getTotalLabel().setText(String.format("₱%.2f", total));
        updateChange(total);
    }

    private void updateChange(double total) {
        try {
            double received = Double.parseDouble(
                view.getCartPanel().getReceivedField().getText().replaceAll("[^\\d.]", "")
            );
            view.getCartPanel().getChangeField().setText(String.format("₱%.2f", received - total));
        } catch (Exception e) {
            view.getCartPanel().getChangeField().setText("₱0.00");
        }
    }
}