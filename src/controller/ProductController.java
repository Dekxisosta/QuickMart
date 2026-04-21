package controller;

import listener.*;
import model.base.Product;
import service.ProductService;
import gui.frame.POSFrame;

import javax.swing.*;
import java.util.*;

public class ProductController {
    private final POSFrame view;
    private final ProductService productService;
    private final List<ProductListener> productListeners;

    public ProductController(POSFrame view, ProductService productService) {
        this.view = view;
        this.productService = productService;
        productListeners = new ArrayList<>();
    }
    public void addProductListener(ProductListener listener){
        productListeners.add(listener);
    }
    public void fireProductSelected(Product p){
        productListeners.forEach(listener -> listener.onProductSelected(p));
    }
    public void displayCategory(String category) {
        List<Product> products = productService.getMenu().get(category.toUpperCase());
        view.getProductPanel().displayCategory(products, this::fireProductSelected);
    }
}