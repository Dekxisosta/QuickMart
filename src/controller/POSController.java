package controller;

import service.*;
import gui.frame.POSFrame;

public class POSController {
    private final CartController cartController;
    private final PaymentController paymentController;
    private final ReceiptController receiptController;
    private final ProductController productController;

    public POSController(
            POSFrame view,
            TotalService totalService,
            TaxService taxService,
            ReceiptArchiveService receiptArchiveService,
            DiscountService discountService,
            ProductService productService
    ) {
        this.receiptController  = new ReceiptController(view, totalService, taxService, discountService, productService);
        this.cartController     = new CartController(view, totalService, productService);
        this.paymentController  = new PaymentController(view, totalService, receiptArchiveService, receiptController, cartController);
        this.productController  = new ProductController(view, productService, cartController);
        initController(view);
    }

    private void initController(POSFrame view) {
        view.getCartPanel().getQtyField().addActionListener(_ -> cartController.handleTextFieldEntry());
        view.getCartPanel().getReceivedField().addActionListener(_ -> cartController.refreshTotals());
        view.getCartPanel().getReceivedField().addKeyListener(new java.awt.event.KeyAdapter() {
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