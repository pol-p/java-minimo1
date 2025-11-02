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
        assertEquals(3, pedidoCreado.getListPedido().size()); // Asumo Pedido.getItems()
        assertEquals("Antonio", pedidoCreado.getUsr().getName()); // Asumo Pedido.getUsuario().getName()
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
}