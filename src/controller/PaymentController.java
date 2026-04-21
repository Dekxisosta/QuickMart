package controller;

import listener.*;
import service.ReceiptArchiveService;
import service.TotalService;
import gui.frame.POSFrame;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class PaymentController {
    private final POSFrame view;
    private final TotalService totalService;
    private final ReceiptArchiveService receiptArchiveService;
    private final List<CashReceivedListener> cashReceivedListeners;
    private final List<PaymentSuccessListener> paymentSuccessListeners;
    private ReceiptGenerator receiptGenerator;


    public PaymentController(
            POSFrame view,
            TotalService totalService,
            ReceiptArchiveService receiptArchiveService
    ) {
        this.view = view;
        this.totalService = totalService;
        this.receiptArchiveService = receiptArchiveService;
        this.paymentSuccessListeners = new ArrayList<>();
        this.cashReceivedListeners = new ArrayList<>();
    }

    public void addPaymentSuccessListener(PaymentSuccessListener listener) {
        paymentSuccessListeners.add(listener);
    }
    public void addCashReceivedListener(CashReceivedListener listener) {
        cashReceivedListeners.add(listener);
    }
    public void setReceiptGenerator(ReceiptGenerator receiptGenerator) {
        this.receiptGenerator = receiptGenerator;
    }
    private void fireCashReceived(){
        cashReceivedListeners.forEach(listener -> listener.onCashReceived());
    }
    private void firePaymentSuccess(){
        paymentSuccessListeners.forEach(listener -> listener.onPaymentSuccess());
    }
    private String generateReceiptHtml(String transactionId){
        if(receiptGenerator == null){
            throw new IllegalStateException("ReceiptGenerator has not been set");
        }
        return receiptGenerator.generate(transactionId);
    }

    public void handlePayRequest() {
        DefaultTableModel model = view.getCartPanel().getTableModel();
        if(model.getRowCount()==0) {
        	view.getDialogManager().showMessage(view, "No items in cart");
        	return;
        }
        double total = totalService.getCartTotal(model);
        String receivedStr = view.getCartPanel().getReceivedField().getText();
        
        if(receivedStr ==null || receivedStr.isEmpty()) {
        	view.getDialogManager().showMessage(view,
                    "No amount received. Balance due: PHP " + String.format("%.2f", total));
                return;
        }
        
        try {
            double received = Double.parseDouble(receivedStr.replaceAll("[^\\d.]", ""));

            if (received < total) {
                view.getDialogManager().showMessage(view,
                    "Insufficient amount. Balance due: PHP " + String.format("%.2f", total - received));
                return;
            }

            String transactionID = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            double change = received - total;

            String receiptHtml = generateReceiptHtml(transactionID);
            receiptArchiveService.archiveReceipt(transactionID, receiptHtml);

            view.getDialogManager().showSuccessDialog(view, transactionID, total, received, change);
            view.getDialogManager().showReceiptDialog(view, receiptHtml);
            firePaymentSuccess();

        } catch (NumberFormatException e) {
            view.getDialogManager().showMessage(view, "Invalid amount entered.");
        }
    }

    public void incrementReceivedField(double amount) {
        JTextField txtField = view.getCartPanel().getReceivedField();
        try {
            double current = txtField.getText().isEmpty() ? 0
                : Double.parseDouble(txtField.getText().replaceAll("[^\\d.]", ""));
            txtField.setText(String.valueOf(current + amount));
            fireCashReceived();
        } catch (NumberFormatException e) {
            txtField.setText("");
        }
    }

    public void updateReceivedToExact() {
        double total = totalService.getCartTotal(view.getCartPanel().getTableModel());
        view.getCartPanel().getReceivedField().setText("%.2f".formatted(total));
        fireCashReceived();
    }
}