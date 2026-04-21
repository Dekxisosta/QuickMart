package controller;

import gui.frame.POSFrame;

public class POSController {
    private final CartController cartController;
    private final PaymentController paymentController;
    private final ReceiptController receiptController;
    private final ProductController productController;

    public POSController(
            POSFrame view,
            CartController cartController,
            PaymentController paymentController,
            ReceiptController receiptController,
            ProductController productController
    ) {
        this.cartController     = cartController;
        this.paymentController  = paymentController;
        this.receiptController  = receiptController;
        this.productController  = productController;
        initController(view);
    }

    private void initController(POSFrame view) {
        view.cartPanel().getQtyField().addActionListener(_ -> cartController.handleTextFieldEntry());
        view.cartPanel().getReceivedField().addActionListener(_ -> cartController.refreshTotals());
        view.cartPanel().getReceivedField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override public void keyReleased(java.awt.event.KeyEvent e) { cartController.refreshTotals(); }
        });

        view.getActionPanel().getVoidBtn().addActionListener(_ -> cartController.handleVoidRequest());
        view.getActionPanel().getCancelBtn().addActionListener(_ -> cartController.handleCancelRequest());
        view.getActionPanel().getCash50Btn().addActionListener(_ -> paymentController.incrementReceivedField(50));
        view.getActionPanel().getCash100Btn().addActionListener(_ -> paymentController.incrementReceivedField(100));
        view.getActionPanel().getCash500Btn().addActionListener(_ -> paymentController.incrementReceivedField(500));
        view.getActionPanel().getCash1000Btn().addActionListener(_ -> paymentController.incrementReceivedField(1000));
        view.getActionPanel().getExactBtn().addActionListener(_ -> paymentController.updateReceivedToExact());
        view.getActionPanel().getPrintBtn().addActionListener(_ -> receiptController.handlePrintRequest());
        view.getActionPanel().getPayBtn().addActionListener(_ -> paymentController.handlePayRequest());

        view.getTopPanel().getCategoryButtons().forEach(catBtn ->
                catBtn.addActionListener(_ -> productController.displayCategory(catBtn.getText()))
        );

        productController.displayCategory("BEVERAGES");
    }
}