package model.product;

import javax.swing.ImageIcon;
import model.base.Product;

public class Meal extends Product {
    private static final String CATEGORY = "Meals";
    private static final String ID_PREFIX = "MEA-";

    public enum MealType {
        FAST_FOOD, RICE_MEAL, PASTA, COMBO
    }

    private MealType type;
    private boolean combo;

    public Meal(String name, double price, double discount, ImageIcon image, MealType type, boolean combo) {
        super(name, price, CATEGORY, discount, image);
        this.type = type;
        this.combo = combo;
    }

    public Meal(String name, double price) {
        this(name, price, 0.0, null, MealType.RICE_MEAL, false);
    }

    @Override
    public double getFinalPrice() {return getPrice() * (1 - getDiscount());}
    @Override
    public String getId() {return ID_PREFIX + super.getBaseId();}
    @Override
    public String getName() {return super.getSimplifiedName() + " - " + type.name();}

    public MealType getType() { return type; }
    public boolean isCombo() { return combo; }

    public void setType(MealType type) { this.type = type; }
    public void setCombo(boolean combo) { this.combo = combo; }
}