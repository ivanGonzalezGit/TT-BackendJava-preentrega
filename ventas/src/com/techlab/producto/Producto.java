package com.techlab.producto;


import java.util.ArrayList;


public class Producto {

    private static ArrayList<Producto> listaProductos = new ArrayList<>();

    private int id_producto;
    private String nombre;
    private double precio;
    private int stock;

    public static void main(String[] args) {
        // pruebas
        System.out.println(listaProductos.size());
        Producto producto1 = new Producto("te DE hIerVAS", 2500, 50);
        agregarProducto(producto1);
        System.out.println(listaProductos.size());

        System.out.println(producto1.toString());

        Producto producto2 = new Producto("cafe molido", 2600, 60);

        Producto.mostrarProductos();
    }

    //------------------------------------------------------------------------------------
    // setter y getter de id_producto
    public void setId_producto() {
        this.id_producto = listaProductos.size();
    }
    public int getId_producto(){
        return this.id_producto;
    }

    // setter y getter de nombre
    public boolean setNombre(String nombreSinFormato){
        if (!nombreSinFormato.isEmpty()){
            this.nombre = NobreProducto.productNameFormat(nombreSinFormato);
            return true;
        } else {
            return false; // si la lógica del setter invalida la entrada, le aviso a la capa de presentación con el booleano.
        }
    }
    public String getNombre(){
        return this.nombre;
    }

    // setter y getter de precio
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public double getPrecio(){
        return this.precio;
    }

    // setter y getter de stock
    public void setStock(int stock){
        this.stock=stock;
    }
    public int getStock(){
        return this.stock;
    }
    //-----------------------------------------------------------------------

    // Constructor
    public Producto (String nombre, double precio, int stock){
        setId_producto();
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        listaProductos.add(this); // ingresa el producto a la colección una vez construido.
    }
    //------------------------------------------------------------------------

    // Métodos
    public static void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }

    @Override
    public String toString(){
        return "id Producto: " + this.id_producto + " | Nombre: " + this.nombre + " | Precio: $" + this.precio + " | Stock: " +  this.stock + " |";
    }

    public static void mostrarProductos(){
        for(Producto producto :listaProductos) {
            System.out.println(producto.toString());
        }
    }

    public void removerProducto(){
        //listaProductos.remove(id_producto);
    }
}
