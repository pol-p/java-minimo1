import java.util.*;

import MyOwnQueue.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductManagerImpl implements ProductManager{
    private static ProductManagerImpl PM;
    //Log4j
    private static final Logger LOGGER = LogManager.getLogger(ProductManagerImpl.class);
    //Mapa de los usuarios
    private Map<Integer, Usuario> mapUsuarios;
    //Lista de los Productos
    private List<Producto> listProductos;
    //Cola de comandas (Ordenes por hacer)
    private Queuee<Pedido> queueComandas;
    //Lista de pedidos Realizados
    private List<Pedido> listPedidosRealizados;

    private ProductManagerImpl(){
       this.mapUsuarios = new HashMap<Integer, Usuario>();
       this.listProductos = new ArrayList<Producto>();
       this.queueComandas = new QueueImpl<Pedido>(200);
       this.listPedidosRealizados = new ArrayList<Pedido>();
    }

    public static ProductManagerImpl getInstance(){
        if(PM == null){
            PM = new ProductManagerImpl();
        }
        return PM;
    }


    @Override
    public Pedido realizarPedido(String nameUsr, List<ItemPedido> lista) {
        return null;
    }

    @Override
    public List<Producto> listarProductosPrecio() {
        LOGGER.info("Ordenando la lista por precio");
        List sorted = new ArrayList<>(this.listProductos);
        Collections.sort(sorted);
        return sorted;
    }

    @Override
    public Producto servirPedido() {
        return null;
    }

    @Override
    public List<Pedido> listarPedidosDeUsuario() {
        return List.of();
    }

    @Override
    public List<Producto> listarProductosNumVentas() {
        return List.of();
    }

    @Override
    public void addProduct(String nameProduct, double price) {
        LOGGER.info("Añadiendo producto " + nameProduct);
        this.listProductos.add(new Producto(nameProduct, price));
    }

    @Override
    public void addUsr(String nameUsr, int idUsr) {

    }
}
