package util;

import java.util.*;

import models.*;
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
    public Pedido realizarPedido(Integer id, List<SimpleItem> lista) {
        if(!this.mapUsuarios.containsKey(id)){
            LOGGER.warn("Usuario no auth");
            return null;
        }
        List<ItemPedido> itemsCompletos = new ArrayList<>();

        for(SimpleItem i: lista){
            Producto prodEncontrado = getProductoById(i.getIdProducto());
            if(prodEncontrado == null){
                LOGGER.fatal("Pedido Cancelado ya que no existe el producto con id {}", i.getIdProducto());
                return null;
            }
            ItemPedido itemPedido = new ItemPedido(prodEncontrado, i.getCantidad());
            itemsCompletos.add(itemPedido);
        }
        Usuario usr = this.mapUsuarios.get(id);
        Pedido nuevoPedido = new Pedido(itemsCompletos, usr);
        this.queueComandas.add(nuevoPedido);

        LOGGER.info("Pedido encolado con {} items.", itemsCompletos.size());

        return nuevoPedido;
    }

    @Override
    public List<Producto> listarProductosPrecio() {
        LOGGER.info("Ordenando la lista por precio");
        List sorted = new ArrayList<>(this.listProductos);
        Collections.sort(sorted);
        return sorted;
    }

    @Override
    public Pedido servirPedido() {
        LOGGER.info("Sacando pedido de cocina");
        Pedido pedidoAServir = this.queueComandas.poll();

        if (pedidoAServir == null) {
            LOGGER.warn("No hay pedidos pendientes para servir.");
            return null; // No hay nada que servir
        }

        for(ItemPedido item: pedidoAServir.getListPedido()){
            Producto p = item.getProduct();
            p.setNumVentas(item.getCantidad());
        }
        this.listPedidosRealizados.add(pedidoAServir);
        LOGGER.info("Pedido servido");
        return pedidoAServir;
    }

    @Override
    public List<Pedido> listarPedidosDeUsuario(Integer idUsuario) {
        LOGGER.info("INICIO listarPedidosDeUsuario para: " + idUsuario);

        if (!this.mapUsuarios.containsKey(idUsuario)) {
            LOGGER.error("Usuario no encontrado: " + idUsuario);
            return new ArrayList<>();
        }

        List<Pedido> pedidosDelUsuario = new ArrayList<>();

        for (Pedido p : this.listPedidosRealizados) {
            if (p.getUsr().getId().equals(idUsuario)) {
                pedidosDelUsuario.add(p);
            }
        }

        LOGGER.info("FIN listarPedidosDeUsuario: Encontrados " + pedidosDelUsuario.size());
        return pedidosDelUsuario;
    }

    @Override
    public List<Producto> listarProductosNumVentas() {
        LOGGER.info("INICIO listarProductosNumVentas");

        List<Producto> listaCopiada = new ArrayList<>(this.listProductos);

        listaCopiada.sort((p1, p2) -> Integer.compare(p2.getNumVentas(), p1.getNumVentas()));

        LOGGER.info("FIN listarProductosNumVentas");
        return listaCopiada;
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
        if(this.mapUsuarios.containsKey(idUsr)){
            LOGGER.warn("El usuario con id = {} ya esta creado", idUsr);
            return;
        }
        this.mapUsuarios.put(idUsr, new Usuario(idUsr, nameUsr));
        LOGGER.info("Usuario {} creado", nameUsr);
    }

    private Producto getProductoById(int id) {
        for (Producto p : this.listProductos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
