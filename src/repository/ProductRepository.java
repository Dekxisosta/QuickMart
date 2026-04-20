package repository;

import model.base.MenuData;
import model.base.Product;
import java.util.*;

public class ProductRepository {
    private final Map<String, List<Product>> menu;
    private final Map<String, Product> barcodeMap;

    public ProductRepository() {
        this.menu = MenuData.initializeMenu();
        this.barcodeMap = new HashMap<>();
        buildBarcodeIndex();
    }

    private void buildBarcodeIndex() {
        menu.values().stream()
            .flatMap(List::stream)
            .forEach(p -> barcodeMap.put(p.getBarcode(), p));
    }

    public Map<String, List<Product>> getMenu() { return menu; }
    public Product findByBarcode(String barcode) {
        return barcodeMap.get(barcode);
    }
}