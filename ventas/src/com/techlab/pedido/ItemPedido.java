package com.techlab.pedido;

import com.techlab.producto.*;

public class ItemPedido {
    private Producto producto;
    private int cantidad;

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
}

