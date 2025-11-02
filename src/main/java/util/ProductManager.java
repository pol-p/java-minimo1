package util;

import models.ItemPedido;
import models.Pedido;
import models.Producto;
import models.SimpleItem;

import java.util.List;

public interface ProductManager {
    public Pedido realizarPedido(Integer idUsuario, List<SimpleItem> itemsSolicitados);
    public List<Producto> listarProductosPrecio();
    public Pedido servirPedido();
    public List<Pedido> listarPedidosDeUsuario();
    public List<Producto> listarProductosNumVentas();

    public void addProduct(int id, String nameProduct, double price);
    public void addUsr(String nameUsr, int idUsr);
}
