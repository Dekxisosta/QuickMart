package listener;

import model.base.Product;

public interface ProductListener {
    void onProductSelected(Product product);
}