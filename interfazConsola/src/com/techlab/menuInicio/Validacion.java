package com.techlab.menuInicio;

public class Validacion {

    public static boolean nombreVacio(String nombreIngresado){
        return !nombreIngresado.isEmpty();
    }

    public static boolean esNumeroPositivo(int numero){
        return numero >= 0;
    }
}
