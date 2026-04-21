package controller;

import handler.*;
import service.DiscountService;
import service.ProductService;
import service.TaxService;
import service.TotalService;
import util.ReceiptFormatter;
import gui.frame.POSFrame;

import javax.swing.table.DefaultTableModel;

public class ReceiptController implements ReceiptHandler {
    private final POSFrame view;
    private final TotalService totalService;
    private final TaxService taxService;
    private final DiscountService discountService;
    private final ProductService productService;

    public ReceiptController(
            POSFrame view,
            TotalService totalService,
            TaxService taxService,
            DiscountService discountService,
            ProductService productService
    ) {
        this.view = view;
        this.totalService = totalService;
        this.taxService = taxService;
        this.discountService = discountService;
        this.productService = productService;
    }

    public void handlePrintRequest() {
        DefaultTableModel model = view.cartPanel().getTableModel();
        if (model.getRowCount() == 0) {
            view.getDialogService().showMessage(view, "Cart is empty. Nothing to print.");
            return;
        }
        view.getDialogService().showReceiptDialog(view, generateReceiptHtml(null));
    }

    public String generateReceiptHtml(String transactionId) {
        DefaultTableModel model = view.cartPanel().getTableModel();
        double totalDiscount = discountService.getTotalDiscount(model, productService);
        double cartTotal = totalService.getCartTotal(model);
        double subTotal = cartTotal + totalDiscount;
        double vatableSale = taxService.calculateVatableSale(cartTotal);
        double vat = taxService.calculateVat(cartTotal);

        return ReceiptFormatter.getReceipt(
                model, "777-420-069-00001",
                "ACHERON", "SILVERWOLF", transactionId,
                subTotal, totalDiscount, cartTotal,
                vatableSale, vat
        );
    }
}