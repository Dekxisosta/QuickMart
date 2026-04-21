package model.base;

public class CartItem {
    private final String barcode;
    private final String name;
    private final int qty;
    private final double unitPrice;
    private final boolean voided;

    public CartItem(String barcode, String name, int qty, double unitPrice, boolean voided) {
        this.barcode = barcode;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.voided = voided;
    }

    public String getBarcode() { return barcode; }
    public String getName() { return name; }
    public int getQty() { return qty; }
    public double getUnitPrice() { return unitPrice; }
    public double getSubtotal() { return unitPrice * qty; }
    public boolean isVoided() { return voided; }
}