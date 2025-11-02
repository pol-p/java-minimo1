package util;

public class Main {
    public static void main(String[] args) {
        ProductManagerImpl PM = ProductManagerImpl.getInstance();
        PM.addProduct(7,"Pera", 3);
        PM.addProduct(7,"Pera", 2);
    }
}
