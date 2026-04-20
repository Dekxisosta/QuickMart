package model.product;

import javax.swing.ImageIcon;
import model.base.Product;

public class Snack extends Product {
    private static final String CATEGORY = "Snacks";
    private static final String ID_PREFIX = "SNA-";

    public enum SnackType {
        CHIPS, NUTS, CHOCOLATE, BISCUITS
    }

    private SnackType type;

    public Snack(String name, double price, double discount, ImageIcon image, SnackType type) {
        super(name, price, CATEGORY, discount, image);
        this.type = type;
    }

    public Snack(String name, double price) {
        this(name, price, 0.0, null, SnackType.CHIPS);
    }

    @Override
    public double getFinalPrice() {return getPrice() * (1 - getDiscount());}
    @Override
    public String getId() {return ID_PREFIX + super.getBaseId();}
    @Override
    public String getName() {return super.getSimplifiedName() + " - " + type.name();}

    public SnackType getType() { return type; }
    public void setType(SnackType type) { this.type = type; }
}