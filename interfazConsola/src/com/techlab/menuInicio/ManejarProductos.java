package com.techlab.menuInicio;

import com.techlab.producto.*;
import java.util.Scanner;

public class ManejarProductos {

    public static void validacionAgregarProducto(Scanner sc) {

        System.out.println("AGREGAR PRODUCTOS");

        // Nombre del producto
        System.out.println("Ingrese el nombre del producto (1/3)");
        String nombreProducto = sc.nextLine();

        if (!nombreProducto.isEmpty()) {
            nombreProducto = NobreProducto.productNameFormat(nombreProducto);
        } else {
            System.out.println("El producto debe tener un nombre");
            eleccionContinuarDesdeManejarProductos("Volver a 'Agregar Producto'", sc);
            return; // si el usuario comete un error, corto el método para que no pida los siguientes datos
        }

        if(Validacion.esProductoRepetido(nombreProducto)){
            System.out.println("El producto ya fue cargado");
            eleccionContinuarDesdeManejarProductos("Volver a 'Agregar Producto'", sc);
            return;
        }

        // Precio del producto
        System.out.println("Ingrese el precio del producto (2/3)");
        String precioSinValidar = sc.nextLine();
        double precioProducto = Validacion.doubleValido(precioSinValidar);
        if (precioProducto < 0) {
            System.out.println("El precio del producto debe ser mayor o igual a 0");
            eleccionContinuarDesdeManejarProductos("Volver a 'Agregar Producto'", sc);
            return;
        }

        // Stock del producto
        System.out.println("Ingrese el stock de producto (3/3)");
        int stockProducto = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        if (stockProducto < 0) {
            System.out.println("El stock no puede ser negativo");
            eleccionContinuarDesdeManejarProductos("Volver a 'Agregar Producto'", sc);
            return;
        }

        // Crear el producto
        Producto.agregarProducto(nombreProducto, precioProducto, stockProducto);
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Precio: $" + precioProducto);
        System.out.println("Stock: " + stockProducto);
        System.out.println("Se agregó el producto correctamente");
        ManejarProductos.eleccionContinuarDesdeManejarProductos("Seguir cargando productos", sc);
    }

    public static void listarProductos(Scanner sc) {
        if (Producto.listaProductos.isEmpty()){
            System.out.println("La lista de productos está vacía");
            ManejarProductos.eleccionContinuarDesdeManejarProductos("ir a 'Agregar Producto'", sc);
        }else{
            Producto.mostrarProductos();
            ManejarProductos.eleccionContinuarDesdeManejarProductos("Agregar Producto", sc);
        }
    }

    public static void buscarProducto(Scanner sc){
        System.out.println("BUSQUEDA DE PRODUCTO");
        int indexProducto = buscarProductoPorNombreOID(sc);
        Producto productoEncontrado = Producto.listaProductos.get(indexProducto);
        productoEncontrado.toString();
    }


    public static void actualizarProducto(Scanner sc) {
        System.out.println();
        System.out.println("ACTUALIZAR PRODUCTO");
        System.out.println();

        int indexProducto = buscarProductoPorNombreOID(sc);
        Producto productoEncontrado = Producto.listaProductos.get(indexProducto);
        productoEncontrado.toString();
        System.out.println();
        System.out.println("1) Actualizar Nombre");
        System.out.println("2) Actualizar Precio");
        System.out.println("3) Actualizar Stock");
        System.out.println("4) Volver a Menú Inicio");
        System.out.println();
        System.out.println("1) Ingrese una opción: ");
        String eleccion = sc.nextLine();
        switch (eleccion){
            case "1":
                System.out.print("Ingrese el nuevo nombre: ");
                String nombre = sc.nextLine();
                productoEncontrado.setNombre(nombre);
                productoEncontrado.toString();
                break;

            case "2":
                System.out.print("Ingrese el nuevo precio: ");
                double precio = sc.nextDouble();
                productoEncontrado.setPrecio(precio);
                productoEncontrado.toString();
                break;

            case "3":
                System.out.print("Ingrese el nuevo stock: ");
                int stock = sc.nextInt();
                productoEncontrado.setStock(stock);
                productoEncontrado.toString();
                break;

            case "4":
                MenuInicio.menuDeOpciones();
                break;

            default:
                System.out.println("Ingresó una opción inválida");
        }
    }

    public static void eliminarProducto(Scanner sc) {
        System.out.println("ELIMINAR PRODUCTO");
        int indexProducto = buscarProductoPorNombreOID(sc);
        Producto.removerProducto(indexProducto);
    }

    //------------------------------------------------------------------
    // Separa por tipo de dato
    public static int buscarProductoPorNombreOID(Scanner sc) {
        System.out.print("Ingrese el nombre o ID del producto: ");
        String entrada = sc.nextLine();
        int indexProductoEncontrado;
        try {
            int idBusquedaProducto = Integer.parseInt(entrada);
            indexProductoEncontrado = Producto.buscarProductoPorId(idBusquedaProducto);

            if(indexProductoEncontrado>=0){
                Producto productoEncontrado = Producto.listaProductos.get(indexProductoEncontrado);
                System.out.println(productoEncontrado.toString());
                return indexProductoEncontrado;
            }else{
                System.out.println("Producto no encontrado");
                return -1;
            }
        } catch (NumberFormatException e) {
            indexProductoEncontrado = Producto.buscarProductoPorNombre(entrada);
            if(indexProductoEncontrado>=0){
                Producto productoEncontrado = Producto.listaProductos.get(indexProductoEncontrado);
                System.out.println(productoEncontrado.toString());
                return indexProductoEncontrado;
            }else{
                System.out.println("Producto no encontrado");
                return -1;
            }
        }
    }
    //---------------------------------------------------------------

    public static void eleccionContinuarDesdeManejarProductos(String agregar, Scanner sc) {
        System.out.println();
        System.out.println("1) " + agregar);
        System.out.println("2) Listar Productos");
        System.out.println("3) Volver al Menú Inicio");
        System.out.println("4) Salir del programa");

        String opcion = sc.nextLine();

        switch (opcion) {
            case "1":
                validacionAgregarProducto(sc);
                return;
            case "2":
                listarProductos(sc);
                return;
            case "3":
                MenuInicio.menuDeOpciones();
                return;
            case "4":
                System.out.println("Saliendo del programa...");
                System.exit(0);
                return;
            default:
                System.out.println("Usted ingresó una opción inválida");
                MenuInicio.eleccionContinuar();
                return;
        }
    }
}
