package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

public class ReceiptFormatter {
	public static String getReceipt(
			DefaultTableModel model,
			String mockTIN,
			String cashier,
			String bagger,
			String transactionId,
			double subTotal,
			double totalDiscount,
			double cartTotal,
			double vatableSale,
			double vat
			) {
		StringBuilder items = new StringBuilder();
		LocalDateTime now = LocalDateTime.now();
		int itemCount = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String currentDateTime = now.format(dtf);
        
		for (int i = 0; i < model.getRowCount(); i++) {
            String status = String.valueOf(model.getValueAt(i, 5));
            if ("<<VOID>>".equals(status)) continue;

            String name = String.valueOf(model.getValueAt(i, 1)).toUpperCase();
            String qty = String.valueOf(model.getValueAt(i, 2));
            String price = String.valueOf(model.getValueAt(i, 3));
            String total = String.valueOf(model.getValueAt(i, 4));
            
            itemCount += Integer.parseInt(qty);

            items.append("""
                <div style='margin-top: 5px;'>
                    <div>%s</div>
                    <table style='width:100%%; font-family:monospace; font-size:11px;'>
                        <tr>
                            <td style='width:50%%;'> %s X %s</td>
                            <td style='text-align:right;'>%s V</td>
                        </tr>
                    </table>
                </div>
            """.formatted(name, qty, price, total));
        }
		
		
		return """
	            <html>
			    <body style='font-family:monospace; font-size:11px; width:250px; margin:0;'>
			        <div style='text-align:center;'>
		                <div style='font-size:14px; font-weight:bold;'>QUICKMART</div>
		                <div style='font-size:9px;'>IPC BRANCH #07 - SANTA ROSA, LAGUNA</div>
		                <div style='font-size:9px;'>BRGY. TAGAPO, OLD NATIONAL HIGHWAY, 4026</div>
		                <div>VAT REG TIN: %s</div>
		                <div style='font-size:9px;'>POSSystem by IPC Logistics</div>
		                <br>
		                <div style='font-weight:bold; border: 1px solid black; display:inline-block; padding: 2px 10px;'>SALES INVOICE</div>
		            </div>
			        
			        <div style='margin-top:10px;'>
			            <div>Trans. Date: %s</div>
			            <div>C: %s / B: %s</div>
			            %s
			        </div>
			        
			        <div style='border-top:1px dashed black; margin-top:5px;'></div>
	                
	                <div style='border-top:1px dashed black; margin-top:5px;'></div>
	                %s
	                <div style='border-top:1px dashed black; margin-top:5px;'></div>
	                
	                <table style='width:100%%; font-family:monospace; font-size:11px;'>
				        <tr>
				            <td>Subtotal</td>
				            <td style='text-align:right;'>%.2f</td>
				        </tr>
				        <tr>
				            <td>Total Discount</td>
				            <td style='text-align:right;'>%.2f</td>
				        </tr>
				        <tr>
				            <td><b>Total</b></td>
				            <td style='text-align:right;'><b>Php %.2f</b></td>
				        </tr>
				    </table>
				    
				    <div style='border-top:1px dashed black; margin-top:5px;'></div>
				    
				    <div style='margin-top:5px;'>
				        <table style='width:100%%; font-family:monospace; font-size:11px;'>
				            <tr>
				                <td>Item Purchased:</td>
				                <td style='text-align:right;'>%d</td>
				            </tr>
				            <tr>
				                <td>VATable Sale (V)</td>
				                <td style='text-align:right;'>%.2f</td>
				            </tr>
				            <tr>
				                <td>VAT (12%%)</td>
				                <td style='text-align:right;'>%.2f</td>
				            </tr>
				        </table>
				    </div>

	                <br>
	                <div style='text-align:center;'>
	                    *** THANK YOU ***
	                </div>
	            </body>
	            </html>
	            """.formatted(
	            		mockTIN, 
	            		currentDateTime, 
	            		cashier, 
	            		bagger, 
	            		(transactionId==null)?"DRAFT RECEIPT: NOT LOGGED": 
	            			String.format("<div>Transaction ID: %s</div>", transactionId),
	            		items.toString(), 
	            		subTotal, 
	            		totalDiscount, 
	            		cartTotal, 
	            		itemCount, 
	            		vatableSale, 
	            		vat);
	}
}
