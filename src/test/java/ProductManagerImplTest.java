import models.ItemPedido;
import models.Pedido;
import models.Producto;
import models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ProductManagerImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerImplTest {

    private ProductManagerImpl pm;

    @BeforeEach
    void setUp() {
        this.pm = ProductManagerImpl.getInstance();
        pm.addProduct(1, "Mandarina", 2.1);
        pm.addProduct(2, "Macarrones", 1);
        pm.addProduct(3, "Brocoli", 3.0);
        pm.addProduct(4, "Manzana", 2.0);

        pm.addUsr("Antonio", 1);
        pm.addUsr("Maria", 2);
    }

    @AfterEach
    void tearDown() {
        pm = null;
    }

    @Test
    void getInstance() {
    }

    @Test
    void realizarPedido() {
        // --- 1. Crear la "cesta" simple (List<SimpleItem>) ---
        List<SimpleItem> miCestaSimple = new ArrayList<>();

        // Queremos 2 Mandarinas (ID: 1) y 1 Macarrones (ID: 2)
        miCestaSimple.add(new SimpleItem(1, 2));
        miCestaSimple.add(new SimpleItem(2, 1));
        miCestaSimple.add(new SimpleItem(4, 3));


        // --- 2. Llamar al manager ---
        Integer idUsuarioAntonio = 1;
        Pedido pedidoCreado = pm.realizarPedido(idUsuarioAntonio, miCestaSimple);

        // --- 3. Comprobar (Assert) los resultados ---
        assertNotNull(pedidoCreado);
        assertEquals(3, pedidoCreado.getListPedido().size());
        assertEquals("Antonio", pedidoCreado.getUsr().getName());
    }

    @Test
    void listarProductosPrecio() {
        List<Producto> list = pm.listarProductosPrecio();

        assertEquals(4, list.size());
        // Orden esperado: 1.0, 2.0, 2.1, 3.0
        assertEquals("Macarrones", list.get(0).getName());
        assertEquals("Manzana",    list.get(1).getName());
        assertEquals("Mandarina",  list.get(2).getName());
        assertEquals("Brocoli",    list.get(3).getName());

        // Comprobación numérica adicional
        assertTrue(list.get(0).getPrice() <= list.get(1).getPrice());
        assertTrue(list.get(1).getPrice() <= list.get(2).getPrice());
        assertTrue(list.get(2).getPrice() <= list.get(3).getPrice());
    }

    @Test
    void servirPedido() {
    }

    @Test
    void listarPedidosDeUsuario() {
    }

    @Test
    void listarProductosNumVentas() {
    }

    @Test
    void addProduct() {
    }

    @Test
    void addUsr() {
    }
    @Test
    void testServirPedidoYComprobarEfectos() {
        // --- 1. PREPARAR (Arrange) ---
        // Primero, creamos un pedido para que la cola no esté vacía

        List<SimpleItem> miCesta = new ArrayList<>();
        miCesta.add(new SimpleItem(1, 2)); // 2 Mandarinas (ID 1)
        miCesta.add(new SimpleItem(2, 1)); // 1 Macarrones (ID 2)

        // Realizamos el pedido para el usuario "Antonio" (ID 1)
        Pedido pedidoEnCola = pm.realizarPedido(1, miCesta);
        assertNotNull(pedidoEnCola); // Comprueba que el pedido se creó

        // --- 2. ACTUAR (Act) ---
        // Ahora, llamamos al método que queremos testear
        Pedido pedidoServido = pm.servirPedido();

        // --- 3. COMPROBAR (Assert) ---

        // A. ¿Devolvió el pedido correcto?
        assertNotNull(pedidoServido);
        assertEquals("Antonio", pedidoServido.getUsr().getName());

        // B. ¿Se actualizaron las ventas?
        List<Producto> listaVentas = pm.listarProductosNumVentas();
        assertEquals("Mandarina", listaVentas.get(0).getName()); // Mandarina es la más vendida (2)
        assertEquals("Macarrones", listaVentas.get(1).getName()); // Macarrones el segundo (1)
        assertEquals(2, listaVentas.get(0).getNumVentas()); // Comprueba la cantidad
        assertEquals(1, listaVentas.get(1).getNumVentas()); // Comprueba la cantidad
        assertEquals(0, listaVentas.get(2).getNumVentas()); // Brocoli no se vendió

        // C. ¿Está el pedido en el historial del usuario?
        List<Pedido> historialAntonio = pm.listarPedidosDeUsuario(1);
        assertEquals(1, historialAntonio.size());

        // D. ¿Está la cola vacía ahora?
        Pedido pedidoVacio = pm.servirPedido();
        assertNull(pedidoVacio); // Si llamamos otra vez, debe dar null
    }
}