package gui.panel;

import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import gui.theme.POSTheme;
import model.base.*;

@SuppressWarnings("serial")
public class CartPanel extends JPanel {
    private JTable cartTable;
    private DefaultTableModel tableModel;
    private JTextField qtyField;
    private JTextField receivedField;
    private JTextField changeField;
    private JLabel totalLabel;

    public CartPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 0));
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(new Color(222, 226, 230)));

        add(createQtySection(), BorderLayout.NORTH);
        add(createTableSection(), BorderLayout.CENTER);
        add(createPaymentSection(), BorderLayout.SOUTH);
    }

    public java.util.List<CartItem> getCartItems() {
        List<CartItem> items = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String barcode = (String) tableModel.getValueAt(i, 0);
            String name = (String) tableModel.getValueAt(i, 1);
            int qty = (int) tableModel.getValueAt(i, 2);
            double unitPrice =
                    Double.parseDouble(
                            tableModel.getValueAt(i, 3).toString().replaceAll("[^\\d.]", "")
                    );
            boolean voided = "<<VOID>>".equals(tableModel.getValueAt(i, 5));
            items.add(new CartItem(barcode, name, qty, unitPrice, voided));
        }
        return items;
    }
    private JPanel createQtySection() {
        JPanel qtyPanel = new JPanel(new BorderLayout(10, 5));
        qtyPanel.setBackground(new Color(248, 249, 250));
        qtyPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        qtyField = new JTextField();
        qtyField.setFont(new Font("Arial", Font.BOLD, 32));
        qtyField.setHorizontalAlignment(JTextField.RIGHT);
        qtyField.setBorder(new LineBorder(new Color(206, 212, 218)));

        JLabel qtyLabel = new JLabel("INPUT / QTY MULTIPLIER");
        qtyLabel.setFont(POSTheme.FONT_BOLD);
        qtyLabel.setForeground(new Color(108, 117, 125));

        qtyPanel.add(qtyLabel, BorderLayout.NORTH);
        qtyPanel.add(qtyField, BorderLayout.CENTER);
        
        return qtyPanel;
    }

    private JScrollPane createTableSection() {
        String[] columnNames = {"BARCODE", "PRODUCT", "QTY", "PRICE", "TOTAL", ""};

        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override 
            public boolean isCellEditable(int r, int c) { return false; }
        };

        cartTable = new JTable(tableModel);
        cartTable.setRowHeight(40);
        cartTable.setShowGrid(false);
        cartTable.setIntercellSpacing(new Dimension(0, 0));
        cartTable.setSelectionBackground(new Color(232, 242, 255));
        
        cartTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                c.setFont(POSTheme.FONT_CART);

                Object status = table.getValueAt(row, 5);
                boolean isVoid = "<<VOID>>".equals(status);

                if (isVoid) {
                    c.setForeground(new Color(200, 50, 50));
                    c.setBackground(isSelected ? new Color(180, 180, 180) : new Color(245, 245, 245));
                } else {
                    c.setForeground(isSelected ? Color.WHITE : POSTheme.COLOR_DARK);
                    c.setBackground(isSelected ? new Color(60, 120, 200) : Color.WHITE);
                }

                return c;
            }
        });
        TableColumnModel columnModel = cartTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(30);
        columnModel.getColumn(5).setPreferredWidth(30);
        
        cartTable.getTableHeader().setBackground(new Color(241, 243, 245));
        cartTable.getTableHeader().setFont(POSTheme.FONT_BOLD);
        cartTable.getTableHeader().setPreferredSize(new Dimension(0, 35));

        JScrollPane tableScroll = new JScrollPane(cartTable);
        tableScroll.setBorder(null);
        tableScroll.getViewport().setBackground(Color.WHITE);
        
        return tableScroll;
    }

    private JPanel createPaymentSection() {
        JPanel paymentPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        paymentPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        paymentPanel.setBackground(Color.WHITE);

        JLabel totalText = new JLabel("TOTAL:");
        totalText.setFont(POSTheme.FONT_BOLD);

        totalLabel = new JLabel("₱0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel receivedText = new JLabel("RECEIVED:");
        receivedText.setFont(POSTheme.FONT_BOLD);

        receivedField = new JTextField();
        receivedField.setFont(new Font("Arial", Font.BOLD, 20));
        receivedField.setHorizontalAlignment(JTextField.RIGHT);

        JLabel changeText = new JLabel("CHANGE:");
        changeText.setFont(POSTheme.FONT_BOLD);

        changeField = new JTextField();
        changeField.setFont(new Font("Arial", Font.BOLD, 20));
        changeField.setHorizontalAlignment(JTextField.RIGHT);
        changeField.setEditable(false);
        changeField.setBackground(new Color(233, 236, 239));

        paymentPanel.add(totalText);
        paymentPanel.add(totalLabel);
        paymentPanel.add(receivedText);
        paymentPanel.add(receivedField);
        paymentPanel.add(changeText);
        paymentPanel.add(changeField);

        return paymentPanel;
    }

    public JTable getCartTable() { return cartTable; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public JTextField getQtyField() { return qtyField; }
    public JTextField getReceivedField() { return receivedField; }
    public JTextField getChangeField() { return changeField; }
    public JLabel getTotalLabel() { return totalLabel; }

    public void clearAndFocusQty() {
        qtyField.setText("");
        qtyField.requestFocusInWindow();
    }

    public String getQtyText() {
        return qtyField.getText();
    }
    public int findActiveRowByBarcode(String barcode) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(barcode)
                    && tableModel.getValueAt(i, 5).equals("")) {
                return i;
            }
        }
        return -1;
    }

    public int getRowQty(int row) {
        return (int) tableModel.getValueAt(row, 2);
    }

    public void updateRow(int row, int newQty, double finalPrice) {
        tableModel.setValueAt(newQty, row, 2);
        tableModel.setValueAt(String.format("₱%.2f", finalPrice * newQty), row, 4);
    }

    public void addRow(String barcode, String name, int qty, double finalPrice) {
        tableModel.addRow(new Object[]{
                barcode,
                name,
                qty,
                String.format("₱%.2f", finalPrice),
                String.format("₱%.2f", finalPrice * qty),
                ""
        });
    }

    public boolean voidItemByBarcode(String barcode) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(barcode)
                    && tableModel.getValueAt(i, 5).equals("")) {
                tableModel.setValueAt("<<VOID>>", i, 5);
                return true;
            }
        }
        return false;
    }
}