import Products.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> listProduct = new ArrayList<>();
        listProduct.add(new Pan(4));
        listProduct.add(new Platano(6));
        listProduct.add(new Fresa(3));
    }
}
