package model.base;

import javax.swing.ImageIcon;
import service.BarcodeService;

public abstract class Product {
    private static int idCounter;
    private String baseId;
    private String barcode;
    private String name;
    private double price;
    private String category;
    private ImageIcon image;
    private double discount;

    public Product(String name, double price, String category) {
        this.baseId = String.format("%03d", idCounter++);
        this.name = name;
        this.price = price;
        this.category = category;
        this.barcode = BarcodeService.generate(category);
    }

    public Product(String name, double price, String category, double discount) {
        this(name, price, category);
        this.discount = discount;
    }

    public Product(String name, double price, String category, ImageIcon image) {
        this(name, price, category);
        this.image = image;
    }

    public Product(String name, double price, String category, double discount, ImageIcon image) {
        this(name, price, category);
        this.discount = discount;
        this.image = image;
    }

    protected String getBaseId() { return baseId; }
    public String getBarcode() { return barcode; }
    public String getSimplifiedName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public double getDiscount() { return discount; }
    public ImageIcon getImage() { return image; }
    
    public abstract String getName();
    public abstract String getId();
    public abstract double getFinalPrice();
    
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setDiscount(double discount) { this.discount = discount; }
    public void setImage(ImageIcon image) { this.image = image; }
}