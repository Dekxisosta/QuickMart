package core;

import javax.swing.SwingUtilities;

import controller.*;
import gui.dialog.DialogManager;
import gui.frame.LoginFrame;
import gui.frame.POSFrame;
import gui.panel.ActionPanel;
import gui.panel.CartPanel;
import gui.panel.ProductPanel;
import gui.panel.TopPanel;
import repository.ProductRepository;
import service.DiscountService;
import service.ReceiptArchiveService;
import service.ProductService;
import service.TaxService;
import service.TotalService;

public class Main {
	public static void main(String[] args) {
	    try {
	    	SwingUtilities.invokeLater(() -> {
                TotalService totalService = new TotalService();
                TaxService taxService = new TaxService();
                DiscountService discountService = new DiscountService();
                ProductService productService = new ProductService(new ProductRepository());
                ReceiptArchiveService receiptArchiveService = new ReceiptArchiveService();

                POSFrame frame = new POSFrame(
		        		new DialogManager(),
		        		new TopPanel(),
		        		new ProductPanel(),
		        		new CartPanel(),
		        		new ActionPanel()
	    		);
                ReceiptController receiptController = new ReceiptController(frame, totalService, taxService, discountService, productService);
                CartController cartController = new CartController(frame, totalService, productService);
                PaymentController paymentController = new PaymentController(frame, totalService, receiptArchiveService, receiptController, cartController);
                ProductController productController = new ProductController(frame, productService, cartController);

                // Not really referenced elsewhere so just creating the object is fine, since POSController
                // wires up behavior upon construction for all events in frame
                new POSController(frame, cartController, paymentController, receiptController, productController);
		        LoginFrame login = new LoginFrame(frame);
		        login.setVisible(true);
		    });
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}
