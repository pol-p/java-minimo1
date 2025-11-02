package models;

public class ItemPedido {
    private Producto product;
    private Integer cantidad;

    public ItemPedido(Producto p, Integer c){
        this.product = p;
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
