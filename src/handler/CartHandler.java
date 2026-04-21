package handler;

import model.base.*;

public interface CartHandler {
    void addToCart(Product p);
    void clearCart();
    void refreshTotals();
}