package com.techlab.producto;


import java.util.ArrayList;


public class Producto {

    public static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static int contador_id = 0;

    private int id_producto;
    private String nombre;
    private double precio;
    private int stock;

    //------------------------------------------------------------------------------------
    // setter y getter de id_producto
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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
        contador_id++;
        setId_producto(contador_id);
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        listaProductos.add(this); // ingresa el producto a la colección una vez construido.
    }
    //------------------------------------------------------------------------

    // Métodos
    @Override
    public String toString(){
        return "id Producto: " + this.id_producto + " | Nombre: " + this.nombre + " | Precio: $" + this.precio + " | Stock: " +  this.stock + " |";
    }

    public static void agregarProducto(String nombreProducto, double precioProducto, int stockProducto){
        Producto nuevoProducto = new Producto(nombreProducto, precioProducto, stockProducto);
    }

    public static void mostrarProductos(){
        for(Producto producto :listaProductos) {
            System.out.println(producto.toString());
        }
    }

    // Buscar por id o nombre
    public static int buscarProductoPorId(int id_producto) {
        for(int i=0; i<listaProductos.size() ;i++) {
            if (listaProductos.get(i).getId_producto() == id_producto) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarProductoPorNombre(String nombreProducto) {
        for(int i=0; i<listaProductos.size();i++) {
            if (listaProductos.get(i).getNombre().equalsIgnoreCase(nombreProducto)) {
                return i;
            }
        }
        return -1;
    }

    public static void removerProducto(int index){
        listaProductos.remove(index);
    }
}
