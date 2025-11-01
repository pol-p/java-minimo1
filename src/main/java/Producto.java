public class Producto implements Comparable<Producto>{
    private String name;
    private double price;
    int numVentas;

    public Producto(String n, double p){
        this.name = n;
        this.price = p;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Producto p) {
        return Double.compare(this.price, p.price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
