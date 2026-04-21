package controller;

import handler.*;
import model.base.Product;
import service.ProductService;
import gui.frame.POSFrame;

import javax.swing.*;
import java.util.List;

public class ProductController {
    private final POSFrame view;
    private final ProductService productService;
    private final CartHandler cartHandler;

    public ProductController(POSFrame view, ProductService productService, CartHandler cartHandler) {
        this.view = view;
        this.productService = productService;
        this.cartHandler = cartHandler;
    }

    public void displayCategory(String category) {
        JPanel grid = view.getProductPanel().getProductGrid();
        grid.removeAll();

        List<Product> products = productService.getMenu().get(category.toUpperCase());
        if (products != null) {
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                if (p.getImage() != null) {
                    view.getProductPanel().addProduct(i, p.getImage());
                } else {
                    view.getProductPanel().addProduct(p.getSimplifiedName(), p.getPrice(), i);
                }
                JButton pBtn = (JButton) grid.getComponent(i);
                pBtn.addActionListener(_ -> cartHandler.addToCart(p));
            }
        }
        view.getProductPanel().refreshGrid();
    }
}