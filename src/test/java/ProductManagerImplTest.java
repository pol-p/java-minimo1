import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerImplTest {

    private ProductManagerImpl pm;

    @BeforeEach
    void setUp() {
        this.pm = ProductManagerImpl.getInstance();
        pm.addProduct("Mandarina", 2.1);
        pm.addProduct("Macarrones", 1);
        pm.addProduct("Brocoli", 3.0);
        pm.addProduct("Manzana", 2.0);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getInstance() {
    }

    @Test
    void realizarPedido() {
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