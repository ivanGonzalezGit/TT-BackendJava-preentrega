package com.techlab.menuInicio;

import com.techlab.producto.Producto;

public class Validacion {

    public static double doubleValido (String numeroInput){
        try {
            // Reemplaza la coma por punto (para adaptarse a Double.parseDouble)
            numeroInput = numeroInput.replace(',', '.');
            double precio = Double.parseDouble(numeroInput);
            return precio;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número válido.");
        }
        return -1;
    }

    public static boolean esProductoRepetido(String nombreProducto){
        for(Producto producto : Producto.listaProductos){
            if(nombreProducto.equalsIgnoreCase(producto.getNombre())){
                return true;
            }
        }
        return false;
    }
}
