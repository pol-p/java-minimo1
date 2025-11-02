package models;

import java.util.List;

public class Pedido {
    private List<ItemPedido> listPedido;
    private Usuario usr;
    private boolean servido;

    public Pedido() {
    }

    public Pedido(List<ItemPedido> listPedido, Usuario usr) {
        this.listPedido = listPedido;
        this.usr = usr;
        this.servido = false;
    }

    public List<ItemPedido> getListPedido() {
        return listPedido;
    }

    public void setListPedido(List<ItemPedido> listPedido) {
        this.listPedido = listPedido;
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

    public boolean isServido() {
        return servido;
    }

    public void setServido(boolean servido) {
        this.servido = servido;
    }
}
