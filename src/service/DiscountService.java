package service;

import javax.swing.table.DefaultTableModel;
import model.base.Product;

public class DiscountService {
	public double getTotalDiscount(DefaultTableModel model, ProductService productService) {
        double totalDiscount = 0.00;
        for (int i = 0; i < model.getRowCount(); i++) {
            String status = String.valueOf(model.getValueAt(i, 5));
            if ("<<VOID>>".equals(status)) continue;

            String barcode = String.valueOf(model.getValueAt(i, 0));
            
            Product p = productService.findByBarcode(barcode);
            if (p!=null) {
            	String lineTotal = model.getValueAt(i,4).toString();
                double originalPrice = p.getPrice();
                int qty = Integer.parseInt(String.valueOf(model.getValueAt(i, 2)));
                
                double productTotal = parseCurrency(lineTotal);
                double expectedTotal = originalPrice * qty;
                
                if (expectedTotal > productTotal) {
                    totalDiscount += (expectedTotal - productTotal);
                }
            }
        }
        return totalDiscount;
    }
	private double parseCurrency(String value) {
        return Double.parseDouble(value.replaceAll("[^\\d.]", ""));
    }
}
