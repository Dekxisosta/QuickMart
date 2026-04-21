package service;

import javax.swing.table.DefaultTableModel;

public class TotalService {
    private static final int TOTAL_COLUMN = 4;
    private static final int STATUS_COLUMN = 5;
	public double getCartTotal(DefaultTableModel model) {
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            Object val = model.getValueAt(i, TOTAL_COLUMN);
            if (val==null) continue;
            String productTotal = (String) val;
            productTotal = productTotal.substring(1, productTotal.length());
            Object status = model.getValueAt(i, STATUS_COLUMN);
            if (status instanceof String && status.equals("")) {
                total += Double.parseDouble(productTotal);
            }
        }
        return total;
    }
}
