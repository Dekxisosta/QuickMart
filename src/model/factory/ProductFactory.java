package model.factory;

import javax.swing.ImageIcon;
import model.product.Beverage;
import model.product.Snack;
import model.product.Meal;
import model.product.Dessert;
import model.product.Bakery;

public class ProductFactory {
    public static BeverageBuilder buildBeverage(String name, double price) {
        return new BeverageBuilder(name, price);
    }
    public static SnackBuilder buildSnack(String name, double price) {
        return new SnackBuilder(name, price);
    }
    public static MealBuilder buildMeal(String name, double price) {
        return new MealBuilder(name, price);
    }
    public static DessertBuilder buildDessert(String name, double price) {
        return new DessertBuilder(name, price);
    }
    public static BakeryBuilder buildBakery(String name, double price) {
        return new BakeryBuilder(name, price);
    }

    public static class BeverageBuilder {
        private String name;
        private double price;
        private double discount = 0.0;
        private ImageIcon image = null;
        private Beverage.Size size = Beverage.Size.MEDIUM;
        private boolean carbonated = false;

        public BeverageBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public BeverageBuilder withDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public BeverageBuilder withImage(ImageIcon image) {
            this.image = image;
            return this;
        }

        public BeverageBuilder withSize(Beverage.Size size) {
            this.size = size;
            return this;
        }

        public BeverageBuilder isCarbonated(boolean carbonated) {
            this.carbonated = carbonated;
            return this;
        }

        public Beverage build() {
            return new Beverage(name, price, discount, image, size, carbonated);
        }
    }

    public static class SnackBuilder {
        private String name;
        private double price;
        private double discount = 0.0;
        private ImageIcon image = null;
        private Snack.SnackType type = Snack.SnackType.CHIPS;

        public SnackBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public SnackBuilder withDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public SnackBuilder withImage(ImageIcon image) {
            this.image = image;
            return this;
        }

        public SnackBuilder ofType(Snack.SnackType type) {
            this.type = type;
            return this;
        }

        public Snack build() {
            return new Snack(name, price, discount, image, type);
        }
    }

    public static class MealBuilder {
        private String name;
        private double price;
        private double discount = 0.0;
        private ImageIcon image = null;
        private Meal.MealType type = Meal.MealType.RICE_MEAL;
        private boolean combo = false;

        public MealBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public MealBuilder withDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public MealBuilder withImage(ImageIcon image) {
            this.image = image;
            return this;
        }

        public MealBuilder ofType(Meal.MealType type) {
            this.type = type;
            return this;
        }

        public MealBuilder isCombo(boolean combo) {
            this.combo = combo;
            return this;
        }

        public Meal build() {
            return new Meal(name, price, discount, image, type, combo);
        }
    }

    public static class DessertBuilder {
        private String name;
        private double price;
        private double discount = 0.0;
        private ImageIcon image = null;
        private Dessert.DessertType type = Dessert.DessertType.CAKE;
        private boolean cold = false;

        public DessertBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public DessertBuilder withDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public DessertBuilder withImage(ImageIcon image) {
            this.image = image;
            return this;
        }

        public DessertBuilder ofType(Dessert.DessertType type) {
            this.type = type;
            return this;
        }

        public DessertBuilder isCold(boolean cold) {
            this.cold = cold;
            return this;
        }

        public Dessert build() {
            return new Dessert(name, price, discount, image, type, cold);
        }
    }

    public static class BakeryBuilder {
        private String name;
        private double price;
        private double discount = 0.0;
        private ImageIcon image = null;
        private Bakery.BakeryType type = Bakery.BakeryType.BREAD;

        public BakeryBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public BakeryBuilder withDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public BakeryBuilder withImage(ImageIcon image) {
            this.image = image;
            return this;
        }

        public BakeryBuilder ofType(Bakery.BakeryType type) {
            this.type = type;
            return this;
        }

        public Bakery build() {
            return new Bakery(name, price, discount, image, type);
        }
    }
}