package PManager;

import Products.Product;

import java.util.ArrayList;

public class ProductManager implements ProdMan{
    private ArrayList<ArrayList<Product>> lista;

    public void addPedido(ArrayList<Product> l){
        this.lista.add(l.sort());
    }
    public void servirPedido(){

    }
}
