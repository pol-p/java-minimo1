package util;

public class Main {
    public static void main(String[] args) {
        ProductManagerImpl PM = ProductManagerImpl.getInstance();
        PM.addProduct(7,"Pera", 3);
        PM.addProduct(7,"Pera", 2);
        PM.addUsr("antonio", 1);
        PM.addUsr("antonio", 1);
        PM.addUsr("Ramon", 2);
    }
}
