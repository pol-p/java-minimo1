package models;

public class SimpleItem {
    private int idProducto; // El ID del producto que quieren
    private int cantidad;   // La cantidad que quieren

    public SimpleItem(int idProducto, int cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdProducto() { return idProducto; }
    public int getCantidad() { return cantidad; }
}
