import PManager.ProductManager;
import Products.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> listProductUsr1 = new ArrayList<>();
        listProductUsr1.add(new Pan(4));
        listProductUsr1.add(new Platano(6));
        listProductUsr1.add(new Fresa(3));

        ArrayList<Product> listProductUsr2 = new ArrayList<>();
        listProductUsr2.add(new Pan(6));
        listProductUsr2.add(new Platano(2));
        listProductUsr2.add(new Fresa(1));

        ProductManager PM = new ProductManager();

    }
}
