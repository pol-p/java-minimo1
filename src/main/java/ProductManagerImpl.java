public class ProductManagerImpl implements ProductManager{
    private static ProductManagerImpl PM;

    private ProductManagerImpl(){

    }

    public static ProductManagerImpl getInstance(){
        if(PM == null){
            PM = new ProductManagerImpl();
        }
        return PM;
    }

    @Override
    public void realizarPedido() {

    }

    @Override
    public void listarProductosPrecio() {

    }

    @Override
    public void servirPedido() {

    }

    @Override
    public void listarPedidosDeUsuario() {

    }

    @Override
    public void listarProductosNumVentas() {

    }
}
