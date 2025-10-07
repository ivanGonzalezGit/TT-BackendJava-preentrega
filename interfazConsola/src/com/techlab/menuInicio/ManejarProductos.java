package com.techlab.menuInicio;

import com.techlab.producto.*;
import java.util.Scanner;

public class ManejarProductos {

    public static void validacionAgregarProducto() {
        Scanner sc = new Scanner(System.in);

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

    //------------------------------------------------------------------
    // Separa por tipo de dato
    public static void buscarProducto(Scanner sc) {
        ///////// hacer una nueva elección para que el tipo pueda decidir que hacer con lo que buscó
        System.out.print("Ingrese el nombre o ID del producto: ");
        String entrada = sc.nextLine();
        try {
            int idBusquedaProducto = Integer.parseInt(entrada);

            int idProductoBuscado = Producto.buscarProductoPorId(idBusquedaProducto);

            if(idProductoBuscado>=0){
                Producto productoEncontrado = Producto.listaProductos.get(idBusquedaProducto);
                System.out.println(productoEncontrado.toString());
                System.out.println("1) Actualizar Producto");
                System.out.println("2) Volver al Menú Inicio");
                System.out.println("3) Salir");
                int actualizar = sc.nextInt();
            }else{
                System.out.println("Producto no encontrado");
            }

            ManejarProductos.eleccionContinuarDesdeManejarProductos("Agregar Producto", sc);
        } catch (NumberFormatException e) {
            Producto.buscarProductoPorNombre(entrada);
            ManejarProductos.eleccionContinuarDesdeManejarProductos("Agregar Producto", sc);
        }
    }
    //---------------------------------------------------------------

    public static void actualizarProducto(int idProducto) {
        System.out.println("actualizó producto");
    }

    public static void eliminarProducto(Scanner sc) {
        // manejar el error de pedir un id que no existe, se rompe fuera de rango
        Producto.mostrarProductos();
        System.out.println("Ingrese el ID o el nombre del producto a eliminar: ");
        String identificador = sc.nextLine();
        //Producto.removerProducto(identificador);
    }

    public static void eleccionContinuarDesdeManejarProductos(String agregar, Scanner sc) {
        System.out.println();
        System.out.println("1) " + agregar);
        System.out.println("2) Listar Productos");
        System.out.println("3) Volver al Menú Inicio");
        System.out.println("4) Salir del programa");

        String opcion = sc.nextLine();

        switch (opcion) {
            case "1":
                validacionAgregarProducto();
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
