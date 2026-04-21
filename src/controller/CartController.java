package controller;

import handler.*;
import model.base.Product;
import service.ProductService;
import service.TotalService;
import gui.frame.POSFrame;

import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class CartController implements CartHandler {
    private final POSFrame view;
    private final TotalService totalService;
    private final ProductService productService;

    public CartController(POSFrame view, TotalService totalService, ProductService productService) {
        this.view = view;
        this.totalService = totalService;
        this.productService = productService;
    }

    public void handleTextFieldEntry() {
        String input = view.getQtyFieldText();
        if (input.isEmpty() || input.endsWith("*")) return;

        Product found = productService.findByBarcode(input);
        if (found != null) {
            addToCart(found);
        } else {
            Toolkit.getDefaultToolkit().beep();
            view.showMessage("Product not found: " + input);
            view.clearQtyField();
        }
    }

    public void addToCart(Product p) {
        try {
            String input = view.getQtyFieldText();
            int qty = 1;
            if (!input.isEmpty() && input.endsWith("*")) {
                qty = Integer.parseInt(input.substring(0, input.length() - 1));
            }

            int existingRow = view.findActiveCartRowByBarcode(p.getBarcode());

            if (existingRow != -1) {
                int currentQty = view.getCartRowQty(existingRow);
                int newQty = currentQty + qty;
                view.updateCartRow(existingRow, newQty, p.getFinalPrice());
            } else {
                view.addCartRow(p.getBarcode(), p.getName(), qty, p.getFinalPrice());
            }

            view.resetQuantityInput();
            refreshTotals();
        } catch (NumberFormatException e) {
            view.clearQtyField();
        }
    }

    public void handleVoidRequest() {
        String barcode = view.showInputDialog("Enter Barcode to Void:");
        if (barcode == null || barcode.isEmpty()) return;

        String pin = view.showPinDialog("Manager PIN Required");
        if ("1234".equals(pin)) {
            boolean found = view.voidCartItemByBarcode(barcode);
            if (!found) {
                view.showMessage("Active item with barcode " + barcode + " not found.");
            }
        } else {
            view.showMessage("Invalid Authentication.");
        }
        refreshTotals();
    }

    public void handleCancelRequest() {
        if (view.isCartEmpty()) return;

        String pin = view.showPinDialog("Manager PIN Required");
        if ("1234".equals(pin)) {
            clearCart();
        } else {
            view.showMessage("Invalid Authentication.");
        }
    }

    public void clearCart() {
        view.clearCartTable();
        view.clearReceivedField();
        refreshTotals();
    }

    public void refreshTotals() {
        DefaultTableModel model = view.getCartTableModel();
        double total = totalService.getCartTotal(model);
        view.setTotalLabel(total);
        updateChange(total);
    }

    private void updateChange(double total) {
        try {
            double received = Double.parseDouble(
                    view.getReceivedFieldText().replaceAll("[^\\d.]", "")
            );
            view.setChangeField(received - total);
        } catch (Exception e) {
            view.setChangeField(0.00);
        }
    }
}