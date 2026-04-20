package service;

import javax.swing.table.DefaultTableModel;

public class TotalService {
	public double getCartTotal(DefaultTableModel model) {
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            Object val = model.getValueAt(i, 4);
            if (val==null) continue;
            String productTotal = (String) val;
            productTotal = productTotal.substring(1, productTotal.length());
            Object status = model.getValueAt(i, 5);
            if (status instanceof String && status.equals("")) {
                total += Double.parseDouble(productTotal);
            }
        }
        return total;
    }
}
