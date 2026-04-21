package core;

import javax.swing.SwingUtilities;

import controller.POSController;
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
	    		
		        POSFrame frame = new POSFrame(
		        		new DialogManager(),
		        		new TopPanel(),
		        		new ProductPanel(),
		        		new CartPanel(),
		        		new ActionPanel()
	    		);
		        new POSController(
		        		frame,
		        		new TotalService(),
		        		new TaxService(),
		        		new ReceiptArchiveService(),
		        		new DiscountService(),
		        		new ProductService(new ProductRepository())
	    		);
		        LoginFrame login = new LoginFrame(frame);
		        login.setVisible(true);
		    });
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}
