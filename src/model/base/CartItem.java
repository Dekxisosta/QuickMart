package model.base;

public class CartItem {
    private final String BARCODE;
    private final String NAME;
    private final int QUANTITY;
    private final double UNIT_PRICE;
    private final boolean VOIDED;

    public CartItem(String barcode, String name, int qty, double unitPrice, boolean voided) {
        this.BARCODE = barcode;
        this.NAME = name;
        this.QUANTITY = qty;
        this.UNIT_PRICE = unitPrice;
        this.VOIDED = voided;
    }

    public String getBarcode() { return BARCODE; }
    public String getName() { return NAME; }
    public int getQuantity() { return QUANTITY; }
    public double getUnitPrice() { return UNIT_PRICE; }
    public double getSubtotal() { return UNIT_PRICE * QUANTITY; }
    public boolean isVoided() { return VOIDED; }
}