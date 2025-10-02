package Products;

public abstract class Product implements Comparable<Product> {
    public int amount;

    public int compareTo(Product p){
        return Integer.compare(this.amount, p.amount);
    }
}
