package model.product;

import javax.swing.ImageIcon;
import model.base.Product;

public class Dessert extends Product {
    private static final String CATEGORY = "Desserts";
    private static final String ID_PREFIX = "DES-";

    public enum DessertType {
        CAKE, ICE_CREAM, PASTRY, CANDY
    }

    private DessertType type;
    private boolean cold;

    public Dessert(String name, double price, double discount, ImageIcon image, DessertType type, boolean cold) {
        super(name, price, CATEGORY, discount, image);
        this.type = type;
        this.cold = cold;
    }
    public Dessert(String name, double price) {
        this(name, price, 0.0, null, DessertType.CAKE, false);
    }

    @Override
    public double getFinalPrice() {return getPrice() * (1 - getDiscount());}
    @Override
    public String getId() {return ID_PREFIX + super.getBaseId();}
    @Override
    public String getName() {return super.getSimplifiedName() + " - " + type.name();}
    
    public DessertType getType() { return type; }
    public boolean isCold() { return cold; }

    public void setType(DessertType type) { this.type = type; }
    public void setCold(boolean cold) { this.cold = cold; }
}