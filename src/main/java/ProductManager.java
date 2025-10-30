import java.util.List;

public interface ProductManager {
    public Pedido realizarPedido(String nameUsr, List<ItemPedido> lista);
    public List<Producto> listarProductosPrecio();
    public Producto servirPedido();
    public List<Pedido> listarPedidosDeUsuario();
    public List<Producto> listarProductosNumVentas();

    public void addProduct(String nameProduct, double price);
    public void addUsr(String nameUsr, int idUsr);
}
