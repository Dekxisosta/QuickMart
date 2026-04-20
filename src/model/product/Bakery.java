package model.product;

import javax.swing.ImageIcon;
import model.base.Product;

public class Bakery extends Product {
    private static final String CATEGORY = "Bakery";
    private static final String ID_PREFIX = "BAK-";

    public enum BakeryType {
        BREAD, PASTRY, CAKE, COOKIE
    }

    private BakeryType type;

    public Bakery(String name, double price, double discount, ImageIcon image, BakeryType type) {
        super(name, price, CATEGORY, discount, image);
        this.type = type;
    }

    public Bakery(String name, double price) {
        this(name, price, 0.0, null, BakeryType.BREAD);
    }

    @Override
    public double getFinalPrice() {
        return getPrice() * (1 - getDiscount());
    }

    @Override
    public String getId() {
        return ID_PREFIX + super.getBaseId();
    }

    @Override
    public String getName() {
        return super.getSimplifiedName() + " - " + type.name();
    }

    public BakeryType getType() {
        return type;
    }

    public void setType(BakeryType type) {
        this.type = type;
    }
}