package gui.panel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import gui.theme.POSTheme;

@SuppressWarnings("serial")
public class CartPanel extends JPanel {
    private JTable cartTable;
    private DefaultTableModel tableModel;
    private JTextField qtyField;
    private JTextField receivedField;
    private JTextField changeField;
    private JLabel totalLabel;

    public CartPanel() {
        // Configure the main CartPanel (this)
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 0));
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(new Color(222, 226, 230)));

        // Assemble the pieces
        add(createQtySection(), BorderLayout.NORTH);
        add(createTableSection(), BorderLayout.CENTER);
        add(createPaymentSection(), BorderLayout.SOUTH);
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
                    // Light gray background for voided rows
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

        // TOTAL
        JLabel totalText = new JLabel("TOTAL:");
        totalText.setFont(POSTheme.FONT_BOLD);

        totalLabel = new JLabel("₱0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // RECEIVED
        JLabel receivedText = new JLabel("RECEIVED:");
        receivedText.setFont(POSTheme.FONT_BOLD);

        receivedField = new JTextField();
        receivedField.setFont(new Font("Arial", Font.BOLD, 20));
        receivedField.setHorizontalAlignment(JTextField.RIGHT);

        // CHANGE
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
}