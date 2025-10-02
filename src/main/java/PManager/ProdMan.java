package PManager;

import Products.Product;

import java.util.ArrayList;

public interface ProdMan {
    public void addPedido(ArrayList<Product> l);
    public void servirPedido();
}
