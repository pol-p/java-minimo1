package models;

public class Producto implements Comparable<Producto>{
    private String name;
    private double price;
    private int id;
    int numVentas;

    public Producto() {
    }

    public Producto(int id, String n, double p){
        this.name = n;
        this.price = p;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }
}
