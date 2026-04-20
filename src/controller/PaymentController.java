package controller;

import service.ReceiptArchiveService;
import service.TotalService;
import gui.frame.POSFrame;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.UUID;

public class PaymentController {
    private final POSFrame view;
    private final TotalService totalService;
    private final ReceiptArchiveService receiptArchiveService;
    private final ReceiptController receiptController;
    private final CartController cartController;

    public PaymentController(
            POSFrame view,
            TotalService totalService,
            ReceiptArchiveService receiptArchiveService,
            ReceiptController receiptController,
            CartController cartController
    ) {
        this.view = view;
        this.totalService = totalService;
        this.receiptArchiveService = receiptArchiveService;
        this.receiptController = receiptController;
        this.cartController = cartController;
    }

    public void handlePayRequest() {
        DefaultTableModel model = view.getCartPanel().getTableModel();
        if(model.getRowCount()==0) {
        	view.getDialogService().showMessage(view, "No items in cart");
        	return;
        }
        double total = totalService.getCartTotal(model);
        String receivedStr = view.getCartPanel().getReceivedField().getText();
        
        if(receivedStr ==null || receivedStr.isEmpty()) {
        	view.getDialogService().showMessage(view,
                    "No amount received. Balance due: PHP " + String.format("%.2f", total));
                return;
        }
        
        try {
            double received = Double.parseDouble(receivedStr.replaceAll("[^\\d.]", ""));

            if (received < total) {
                view.getDialogService().showMessage(view,
                    "Insufficient amount. Balance due: PHP " + String.format("%.2f", total - received));
                return;
            }

            String transactionID = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            double change = received - total;

            String receiptHtml = receiptController.generateReceiptHtml(transactionID);
            receiptArchiveService.logTransaction(transactionID, receiptHtml);

            view.getDialogService().showSuccessDialog(view, transactionID, total, received, change);
            view.getDialogService().showReceiptDialog(view, receiptHtml);
            cartController.clearCart();

        } catch (NumberFormatException e) {
            view.getDialogService().showMessage(view, "Invalid amount entered.");
        }
    }

    public void incrementReceivedField(double amount) {
        JTextField txtField = view.getCartPanel().getReceivedField();
        try {
            double current = txtField.getText().isEmpty() ? 0
                : Double.parseDouble(txtField.getText().replaceAll("[^\\d.]", ""));
            txtField.setText(String.valueOf(current + amount));
            cartController.refreshTotals();
        } catch (NumberFormatException e) {
            txtField.setText("");
        }
    }

    public void updateReceivedToExact() {
        double total = totalService.getCartTotal(view.getCartPanel().getTableModel());
        view.getCartPanel().getReceivedField().setText("%.2f".formatted(total));
        cartController.refreshTotals();
    }
}