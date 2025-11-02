package models;

public class ItemPedido {
    private Producto product;
    private int cantidad;

    public void ItemPedido(Producto p, int c){
        this.product = product;
        this.cantidad = c;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
