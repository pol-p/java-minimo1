package util;

import java.util.*;

import models.ItemPedido;
import models.Pedido;
import models.Producto;
import models.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductManagerImpl implements ProductManager {
    private static ProductManagerImpl PM;
    //Log4j
    private static final Logger LOGGER = LogManager.getLogger(ProductManagerImpl.class);
    //Mapa de los usuarios
    private Map<Integer, Usuario> mapUsuarios;
    //Lista de los Productos
    private List<Producto> listProductos;
    //Cola de comandas (Ordenes por hacer)
    private Queue<Pedido> queueComandas;
    //Lista de pedidos Realizados
    private List<Pedido> listPedidosRealizados;

    private ProductManagerImpl(){
       this.mapUsuarios = new HashMap<Integer, Usuario>();
       this.listProductos = new ArrayList<Producto>();
       this.queueComandas = new LinkedList<>();
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
    public void addProduct(int id, String nameProduct, double price) {
        for(Producto p: this.listProductos){
            if(p.getId().equals(id)){
                LOGGER.warn("El producto {} ya esta en la lista", p.getName());
                p.setPrice(price);
                LOGGER.info("Cambaindo precio a {}", p.getPrice());
                return;
            }
        }
        LOGGER.info("Añadiendo producto {}", nameProduct);
        this.listProductos.add(new Producto(id, nameProduct, price));
    }

    @Override
    public void addUsr(String nameUsr, int idUsr) {

    }
}
