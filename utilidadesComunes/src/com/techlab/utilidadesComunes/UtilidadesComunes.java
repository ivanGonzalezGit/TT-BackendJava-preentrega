package com.techlab.utilidadesComunes;

import java.util.ArrayList; // ya tiene cubierta la importación del método genérico ArrayList<T>
import java.util.Scanner;
import java.util.function.Predicate; // importa una interfaz funcional genérica (predicate<T>), se define con una función lambda

public class UtilidadesComunes {

    // Método genérico
    public static <T> int buscarPorNombreOID(
            String entidad,
            Scanner sc,
            ArrayList<T> lista, // toma por parámetro una lista Arraylist<objetoArgumento>
            Predicate<T> filtroPorId, // filtroPorId es el nombre de la función del tipo Predicate<T>
            // que se declara pasando una función lambda como argumento al llamar a la función.
            // recibe un objeto y devuelve un booleano si se cumple una condición de la función lambda

            Predicate<T> filtroPorNombre, // es una función lambda pasada por parámetro
            java.util.function.Consumer<T> mostrarElemento // Función pasada por parámetro que llamamos
            // como respuesta cuando la función lambda se cumple
    ) {
        System.out.print("Ingrese el nombre o ID de " + entidad + ": ");
        String entrada = sc.nextLine();
        int indexEncontrado = -1;

        try {
            int id = Integer.parseInt(entrada);
            // Buscar por ID
            for (int i = 0; i < lista.size(); i++) {
                if (filtroPorId.test(lista.get(i))) {// .test evalúa si la función lambda se cumple
                    mostrarElemento.accept(lista.get(i));//
                    return i;
                }
            }
        } catch (NumberFormatException e) {
            // Buscar por nombre
            for (int i = 0; i < lista.size(); i++) {
                if (filtroPorNombre.test(lista.get(i))) {
                    mostrarElemento.accept(lista.get(i));
                    return i;
                }
            }
        }

        System.out.println(entidad + " no encontrado");
        return indexEncontrado;
    }
}