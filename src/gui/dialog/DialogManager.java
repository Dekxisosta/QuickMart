package gui.dialog;

import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import gui.util.AutoHideScrollPane;

public class DialogManager {
	public void showReceiptDialog(JFrame view, String htmlContent) {
        JEditorPane receiptPane = new JEditorPane("text/html", htmlContent);
        receiptPane.setEditable(false);
        receiptPane.setOpaque(false);
        receiptPane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);

        JScrollPane scrollPane = new AutoHideScrollPane(receiptPane);
        scrollPane.setPreferredSize(new Dimension(320, 450));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JOptionPane.showMessageDialog(
                view,
                scrollPane,
                "Receipt",
                JOptionPane.PLAIN_MESSAGE
        );
    }
	public String showInputDialog(JFrame frame, String message) {
        return JOptionPane.showInputDialog(frame, message, "Input Required", JOptionPane.QUESTION_MESSAGE);
    }

    public void showMessage(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, "POS System", JOptionPane.INFORMATION_MESSAGE);
    }

    public String showPinDialog(JFrame frame, String title) {
        JPasswordField pf = new JPasswordField();
        int auth = JOptionPane.showConfirmDialog(frame, pf, title, JOptionPane.OK_CANCEL_OPTION);
        return (auth == JOptionPane.OK_OPTION) ? new String(pf.getPassword()) : null;
    }
    
    public void showSuccessDialog(
    		JFrame view,
    		String transactionID,
    		double total,
    		double received,
    		double change
    		) {
    	String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    	String successMsg = """
                <html>
                <body style='width: 300px; font-family: monospace; color: black;'>
                    <div style='border: 2px solid black; padding: 10px; text-align: center;'>
                        <h2 style='margin: 0; font-size: 16px;'>TRANSACTION COMPLETE</h2>
                        <div style='font-size: 10px;'>QUICKMART x IPC LOGISTICS</div>
                    </div>
                    <div style='padding: 10px;'>
                        <b>ID:</b> #%s<br>
                        <b>DATE:</b> %s
                        <table style='width: 100%%; margin-top: 15px;'>
                            <tr><td>TOTAL DUE:</td><td style='text-align: right;'>PHP %.2f</td></tr>
                            <tr><td>CASH RECEIVED:</td><td style='text-align: right;'>PHP %.2f</td></tr>
                        </table>
                        <div style='border: 2px solid black; margin-top: 15px; padding: 10px; text-align: center;'>
                            <div style='font-size: 10px;'>TENDERED CHANGE</div>
                            <div style='font-size: 24px; font-weight: bold;'>PHP %.2f</div>
                        </div>
                    </div>
                </body>
                </html>
                """.formatted(transactionID, currentDateTime, total, received, change);
    	JOptionPane.showMessageDialog(view, successMsg, "QuickMart", JOptionPane.PLAIN_MESSAGE);
    }
}
