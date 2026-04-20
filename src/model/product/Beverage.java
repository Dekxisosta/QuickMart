package model.product;

import javax.swing.ImageIcon;
import model.base.Product;

public class Beverage extends Product {
    private static final String CATEGORY = "Beverages";
    private static final String ID_PREFIX = "BEV-";

    public enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }

    private Size size;
    private boolean carbonated;

    public Beverage(String name, double price, double discount, ImageIcon image, Size size, boolean carbonated) {
        super(name, price, CATEGORY, discount, image);
        this.size = size;
        this.carbonated = carbonated;
    }
    public Beverage(String name, double price) {
        this(name, price, 0.0, null, Size.MEDIUM, false);
    }

    @Override
    public double getFinalPrice() {return getPrice() * (1 - getDiscount());}
    @Override
    public String getId() {return ID_PREFIX + super.getBaseId();}
    @Override
    public String getName() {return super.getSimplifiedName() + " - " + size.name();}
    
    public Size getSize() { return size; }
    public boolean isCarbonated() { return carbonated; }
    
    public void setSize(Size size) { this.size = size; }
    public void setCarbonated(boolean carbonated) { this.carbonated = carbonated; }
}