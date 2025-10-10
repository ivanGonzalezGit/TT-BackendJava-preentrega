package com.techlab.pedido;

import java.util.Scanner;
import java.util.ArrayList;
import com.techlab.producto.Producto;

public class Pedido {
    public ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    private int total;

    public void IngresarItem(Scanner sc, Producto producto, int cantidad){
        System.out.println("Ingrese el producto: ");
        String nombreProductoBuscado = sc.nextLine();
        // Producto productoIngresado = Producto.listaProductos.get(ManejarProducto.buscar...);
        System.out.println("Ingrese la cantidad");
    }
}
