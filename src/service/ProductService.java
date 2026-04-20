package service;

import model.base.Product;
import repository.ProductRepository;
import java.util.*;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

	public Map<String, List<Product>> getMenu() {
        return repository.getMenu();
    }

    public Product findByBarcode(String barcode) {
        return repository.findByBarcode(barcode);
    }
}